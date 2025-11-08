package id.ac.polban.poinoffsales;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ProductPanel extends JPanel {
  private JTable productTable;
  private JTextField qtyField;
  private JButton addToCartButton;
  private JLabel selectionLabel;

  private CartPanel cartPanel;

  private transient Object[] selectedProductData = null;

  private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.of("id", "ID"));

  public ProductPanel(CartPanel cartPanel) {
    this.cartPanel = cartPanel;

    setLayout(new BorderLayout(5, 5));
    setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JPanel tablePanel = createTablePanel();
    add(tablePanel, BorderLayout.CENTER);

    JPanel inputPanel = createInputPanel();
    add(inputPanel, BorderLayout.SOUTH);

    addListeners();
  }

  private JPanel createTablePanel() {

    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(new TitledBorder("Produk"));

    String[] columnNames = { "ID", "Nama Produk", "Harga (Rp)" };
    Object[][] data = {
        { "P001", "Air Mineral 600ml", 3000 },
        { "P002", "Kopi Sachet", 5000 },
        { "P003", "Roti isi", 8000 },
        { "P004", "Snack Keripik", 6000 },
        { "P005", "Minuman Botol", 12000 }
    };

    DefaultTableModel model = new DefaultTableModel(data, columnNames) {
      @Override
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };

    productTable = new JTable(model);
    productTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    JScrollPane scrollPane = new JScrollPane(productTable);
    panel.add(scrollPane, BorderLayout.CENTER);

    return panel;
  }

  private JPanel createInputPanel() {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    selectionLabel = new JLabel("Pilih produk dari tabel di kiri");
    selectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(selectionLabel);
    panel.add(Box.createRigidArea(new java.awt.Dimension(0, 5)));

    JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    actionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

    JPanel qtyPanel = new JPanel();
    qtyPanel.add(new JLabel("Qty:"));
    qtyField = new JTextField("1", 3);
    qtyPanel.add(qtyField);
    actionPanel.add(qtyPanel);

    addToCartButton = new JButton("Add to Cart");
    actionPanel.add(addToCartButton);

    panel.add(actionPanel);

    return panel;
  }

  private void addListeners() {
    productTable.getSelectionModel().addListSelectionListener(e -> {
      if (!e.getValueIsAdjusting()) {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {

          String id = productTable.getValueAt(selectedRow, 0).toString();
          String name = productTable.getValueAt(selectedRow, 1).toString();
          int price = (int) productTable.getValueAt(selectedRow, 2);

          selectedProductData = new Object[] { id, name, price };

          String formattedPrice = currencyFormatter.format(price);

          selectionLabel.setText(String.format("Dipilih: %s - %s (%s)", id, name, formattedPrice));
        } else {
          selectedProductData = null;
          selectionLabel.setText("Pilih produk dari tabel di kiri");
        }
      }
    });

    addToCartButton.addActionListener(_ -> {
      if (selectedProductData == null) {
        JOptionPane.showMessageDialog(this, "Silakan pilih produk terlebih dahulu.", "Peringatan",
            JOptionPane.WARNING_MESSAGE);
        return;
      }

      try {
        int qty = Integer.parseInt(qtyField.getText());
        if (qty <= 0) {
          JOptionPane.showMessageDialog(this, "Kuantitas harus lebih dari 0.", "Error",
              JOptionPane.ERROR_MESSAGE);
          return;
        }

        String id = selectedProductData[0].toString();
        String name = selectedProductData[1].toString();
        int price = (int) selectedProductData[2];

        cartPanel.addProductToCart(id, name, price, qty);

      } catch (NumberFormatException _) {
        JOptionPane.showMessageDialog(this, "Kuantitas harus berupa angka.", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    });
  }

  public void setInputEnabled(boolean enabled) {
    addToCartButton.setEnabled(enabled);
    qtyField.setEnabled(enabled);
    productTable.setEnabled(enabled);
  }
}