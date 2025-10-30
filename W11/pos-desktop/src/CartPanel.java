import java.awt.*;
import java.awt.print.PrinterException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class CartPanel extends JPanel {
  private JTable cartTable;
  private JLabel totalLabel;
  private JLabel pointsLabel;
  private JButton checkoutButton;
  private JButton printButton;
  private JTextArea receiptArea;
  private DefaultTableModel cartTableModel;

  private long totalAmount = 0;
  private ProductPanel productPanel;

  private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));

  public CartPanel() {
    setLayout(new BorderLayout(5, 5));
    setBorder(new TitledBorder("Keranjang"));

    add(createCartTablePanel(), BorderLayout.CENTER);
    add(createBottomPanel(), BorderLayout.SOUTH);

    addListeners();
  }

  public void setProductPanel(ProductPanel productPanel) {
    this.productPanel = productPanel;
  }

  public void addProductToCart(String id, String name, int price, int qty) {

    for (int i = 0; i < cartTableModel.getRowCount(); i++) {
      if (cartTableModel.getValueAt(i, 0).equals(id)) {

        int currentQty = (int) cartTableModel.getValueAt(i, 2);
        int newQty = currentQty + qty;
        long newSubtotal = (long) price * newQty;
        cartTableModel.setValueAt(newQty, i, 2);
        cartTableModel.setValueAt(newSubtotal, i, 4);
        updateTotal();
        return;
      }
    }

    long subtotal = (long) price * qty;
    Object[] rowData = { id, name, qty, price, subtotal };
    cartTableModel.addRow(rowData);
    updateTotal();
  }

  private void updateTotal() {
    totalAmount = 0;
    for (int i = 0; i < cartTableModel.getRowCount(); i++) {
      totalAmount += (long) cartTableModel.getValueAt(i, 4);
    }
    totalLabel.setText("Total: " + currencyFormatter.format(totalAmount));

    long points = totalAmount / 10000;
    pointsLabel.setText("Points: " + points);
  }

  private void addListeners() {
    checkoutButton.addActionListener(e -> {
      if (cartTableModel.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Keranjang masih kosong.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
      }

      generateReceipt();

      checkoutButton.setEnabled(false);
      if (productPanel != null) {
        productPanel.setInputEnabled(false);
      }

      printButton.setEnabled(true);
    });

    printButton.addActionListener(e -> {
      try {
        boolean complete = receiptArea.print();
        if (complete) {
          JOptionPane.showMessageDialog(this,
              "Struk telah dikirim ke printer.",
              "Cetak Berhasil",
              JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(this,
              "Proses mencetak dibatalkan.",
              "Cetak Dibatalkan",
              JOptionPane.WARNING_MESSAGE);
        }
      } catch (PrinterException ex) {
        JOptionPane.showMessageDialog(this,
            "Terjadi error saat mencoba mencetak: " + ex.getMessage(),
            "Error Mencetak",
            JOptionPane.ERROR_MESSAGE);
      }
    });
  }

  private void generateReceipt() {
    StringBuilder receipt = new StringBuilder();
    receipt.append("      *** POIN OFF-SALES ***\n");
    receipt.append("---------------------------------------\n");

    Vector<Vector> data = cartTableModel.getDataVector();
    for (Vector<Object> row : data) {
      String name = (String) row.get(1);
      int qty = (int) row.get(2);
      int price = (int) row.get(3);

      String line = String.format("%-20s\n      %d x %s\n",
          name,
          qty,
          currencyFormatter.format(price));
      receipt.append(line);
    }

    receipt.append("---------------------------------------\n");
    receipt.append(String.format("TOTAL: %s\n", currencyFormatter.format(totalAmount)));
    receipt.append(String.format("POIN DIDAPAT: %d\n\n", totalAmount / 10000));
    receipt.append("      Terima kasih telah berbelanja!\n");

    receiptArea.setText(receipt.toString());
  }

  private JScrollPane createCartTablePanel() {
    String[] columnNames = { "ID", "Nama Produk", "Qty", "Harga", "Subtotal" };
    Object[][] data = {};

    cartTableModel = new DefaultTableModel(data, columnNames) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }

      @Override
      public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex >= 2)
          return Integer.class;
        return String.class;
      }
    };

    cartTable = new JTable(cartTableModel);
    return new JScrollPane(cartTable);
  }

  private JPanel createBottomPanel() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.add(createCheckoutPanel(), BorderLayout.NORTH);
    panel.add(createReceiptPanel(), BorderLayout.CENTER);
    return panel;
  }

  private JPanel createCheckoutPanel() {
    JPanel panel = new JPanel();

    panel.setLayout(new GridBagLayout());
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.LINE_START;

    totalLabel = new JLabel("Total: Rp0,00");
    totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    panel.add(totalLabel, gbc);

    pointsLabel = new JLabel("Points: 0");
    pointsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
    gbc.gridy = 1;
    panel.add(pointsLabel, gbc);

    checkoutButton = new JButton("Checkout");
    gbc.gridy = 2;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(checkoutButton, gbc);

    printButton = new JButton("Cetak");
    printButton.setEnabled(false);
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(printButton, gbc);

    return panel;
  }

  private JPanel createReceiptPanel() {
    JPanel panel = new JPanel(new BorderLayout(5, 5));
    panel.setBorder(new EmptyBorder(10, 0, 0, 0));
    panel.add(new JLabel("Struk:"), BorderLayout.NORTH);
    receiptArea = new JTextArea(10, 30);
    receiptArea.setEditable(false);
    receiptArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
    JScrollPane scrollPane = new JScrollPane(receiptArea);
    panel.add(scrollPane, BorderLayout.CENTER);
    return panel;
  }
}