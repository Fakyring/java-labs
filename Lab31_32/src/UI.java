import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {
    public String[] tableList = new String[]{"Table 1", "Table 2", "Table 3", "Table 4",
            "Table 5", "Table 6", "Table 7", "Table 8", "Table 9", "Table 10"};
    public static int WIDTH_FRAME = 520;
    public static int HEIGHT_FRAME = 440;
    private JPanel mainFrame = new JPanel(null);
    private TableOrdersManager orderManager = new TableOrdersManager();
    private JButton addBtn = DefaultElements.customButton("Добавить", 245, 20);
    private JButton delBtn = DefaultElements.customButton("Удалить заказ по номеру стола", 245, 20);

    private JLabel nameLabel = DefaultElements.customJlabel("Name", 14, 50, 18);
    private JLabel descriptionLabel = DefaultElements.customJlabel("Description", 14, 100, 18);
    private JLabel costLabel = DefaultElements.customJlabel("Cost", 14, 40, 18);
    private JLabel tableLabel = DefaultElements.customJlabel("Table", 14, 45, 18);

    private JTextField nameTextField = DefaultElements.customJTextField();
    private JTextField descriptionTextField = DefaultElements.customJTextField();
    private JTextField costTextField = DefaultElements.customJTextField();
    private JTextField tableTextField = DefaultElements.customJTextField();
    private JLabel errorLabel = DefaultElements.customError("", 495, 100);

    private JScrollPane tableScroll;
    private JScrollPane dishScroll;

    private void event() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder stringBuilder = new StringBuilder();
                MenuItem drink = new Drink(nameTextField.getText(), descriptionTextField.getText());
                if (costTextField.getText().length() != 0 && costTextField.getText().matches("[0-9]+(.[0-9]*)?")) {
                    drink.setCost(Double.parseDouble(costTextField.getText()));
                } else {
                    stringBuilder.append("Не верная стоимость<br>");
                }
                if (tableTextField.getText().matches("[1-9]+")) {
                    int tableNumber = Integer.parseInt(tableTextField.getText());
                    if (tableNumber > 0 && tableNumber <= 10) {
                        orderManager.addItem(drink, tableNumber);
                    } else {
                        stringBuilder.append("Не верный стол<br>");
                    }
                } else {
                    stringBuilder.append("Не верный стол<br>");
                }
                errorLabel.setText("<html>" + stringBuilder.toString() + "</html>");
                if (stringBuilder.length() == 0) {
                    nameTextField.setText("");
                    descriptionTextField.setText("");
                    costTextField.setText("");
                    tableTextField.setText("");
                }
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder stringBuilder = new StringBuilder();
                if (tableTextField.getText().matches("[1-9]+")) {
                    int tableNumber = Integer.parseInt(tableTextField.getText());
                    if (tableNumber > 0 && tableNumber <= 10) {
                        orderManager.remove(tableNumber);
                    } else {
                        stringBuilder.append("Не верный стол\n");
                    }
                } else {
                    stringBuilder.append("Не верный стол\n");
                }
                errorLabel.setText(stringBuilder.toString());
            }
        });
    }

    private void tableView() {
        JList<String> list = new JList<String>(tableList);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JTextArea content = new JTextArea(5, 20);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Получение элемента
                    int selected = list.locationToIndex(e.getPoint());
                    String drinksInfo = "";
                    if (orderManager.freeTableNumber() == 0 || orderManager.getOrder(selected + 1) == null) {
                        content.setText("Заказа нет");
                    } else {
                        MenuItem[] drinks = orderManager.getOrder(selected + 1).getItems();
                        TableOrder order = (TableOrder)orderManager.getOrder(selected+1);
                        for (int i = 0; i < order.getSize(); i++) {
                            content.append("Drink{ cost: " + drinks[i].getCost() + ", name: " + drinks[i].getName() + " desc: " + drinks[i].getDescription()
                                    + ", type: " + ((Drink) drinks[i]).getType() + "}\n");
                        }
                    }
                }
            }
        });
        tableScroll = new JScrollPane(list);
        dishScroll = new JScrollPane(content);
    }

    private void grid() {
        addBtn.setLocation(5, 60);
        delBtn.setLocation(255, 60);

        nameLabel.setLocation(5, 10);
        nameTextField.setLocation(5, 30);

        descriptionLabel.setLocation(130, 10);
        descriptionTextField.setLocation(130, 30);

        costLabel.setLocation(255, 10);
        costTextField.setLocation(255, 30);

        tableLabel.setLocation(380, 10);
        tableTextField.setLocation(380, 30);

        errorLabel.setLocation(5, 90);

        tableScroll.setLocation(5, 195);
        tableScroll.setSize(140, 200);

        dishScroll.setLocation(150, 195);
        dishScroll.setSize(350, 200);
    }

    public UI() {
        super("Orders");

        tableView();
        grid();
        event();
        mainFrame.add(addBtn);
        mainFrame.add(delBtn);

        mainFrame.add(nameLabel);
        mainFrame.add(nameTextField);
        mainFrame.add(descriptionLabel);
        mainFrame.add(descriptionTextField);
        mainFrame.add(costLabel);
        mainFrame.add(costTextField);
        mainFrame.add(tableLabel);
        mainFrame.add(tableTextField);
        mainFrame.add(errorLabel);

        mainFrame.add(dishScroll);
        mainFrame.add(tableScroll);
        getContentPane().add(mainFrame);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UI();
    }
}

class DefaultElements {
    public static JButton customButton(String title, int width, int height) {
        JButton newButton = new JButton();
        newButton.setSize(width, height);
        newButton.setText(title);
        newButton.setBackground(Color.decode("#D9D9D9"));
        newButton.setFocusPainted(false);
        newButton.setFont(new Font("Inter", 0, 12));
        return newButton;
    }

    public static JLabel customJlabel(String title, int fontSize, int width, int height) {
        JLabel newJlabel = new JLabel(title);
        newJlabel.setSize(width, height);
        newJlabel.setFont(new Font("Inter", 0, fontSize));
        newJlabel.setOpaque(true);
        return newJlabel;
    }

    public static JLabel customError(String title, int width, int height) {
        JLabel newJlabel = new JLabel(title);
        newJlabel.setSize(width, height);
        newJlabel.setFont(new Font("Inter", 0, 12));
        newJlabel.setBackground(Color.decode("#D9D9D9"));
        newJlabel.setForeground(Color.red);
        newJlabel.setOpaque(true);
        return newJlabel;
    }

    public static JTextField customJTextField() {
        JTextField newJTextField = new JTextField();
        newJTextField.setSize(120, 20);
        newJTextField.setBackground(Color.decode("#D9D9D9"));
        newJTextField.setFont(new Font("Inter", 0, 12));
        newJTextField.setMargin(new Insets(0, 5, 0, 10));
        return newJTextField;
    }

    public static JTextArea customJTextArea(int width, int height) {
        JTextArea newJTextArea = new JTextArea();
        newJTextArea.setSize(width, height);
        newJTextArea.setBackground(Color.decode("#D9D9D9"));
        newJTextArea.setFont(new Font("Inter", 0, 14));
        newJTextArea.setForeground(Color.black);
        newJTextArea.setMargin(new Insets(0, 10, 0, 10));
        return newJTextArea;
    }
}