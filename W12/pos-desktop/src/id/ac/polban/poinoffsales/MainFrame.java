package id.ac.polban.poinoffsales;

import java.awt.BorderLayout;

import javax.swing.*;

public class MainFrame extends JFrame {
  public MainFrame() {
    setTitle("POIN OFF-SALES - Java Swing");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(900, 600);
    setLocationRelativeTo(null);

    setJMenuBar(createMenuBar());

    CartPanel cartPanel = new CartPanel();
    ProductPanel productPanel = new ProductPanel(cartPanel);

    cartPanel.setProductPanel(productPanel);

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, productPanel, cartPanel);
    splitPane.setDividerLocation(450);

    getContentPane().add(splitPane, BorderLayout.CENTER);
  }

  private JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    exitMenuItem.addActionListener(_ -> System.exit(0));
    fileMenu.add(exitMenuItem);
    menuBar.add(fileMenu);
    return menuBar;
  }
}