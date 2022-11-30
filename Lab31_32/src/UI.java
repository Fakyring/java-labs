import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {
    public String[] tableList = new String[]{"Стол 1", "Стол 2", "Стол 3", "Стол 4",
            "Стол 5", "Стол 6", "Стол 7", "Стол 8", "Стол 9", "Стол 10"};
    public static int WIDTH_FRAME = 520;
    public static int HEIGHT_FRAME = 440;
    private JPanel mainFrame = new JPanel(null);
    private TableOrdersManager orderManager = new TableOrdersManager();
    private JButton addBtn = DefaultElements.Button("Добавить", 245, 20);
    private JButton delBtn = DefaultElements.Button("Удалить заказ по номеру стола", 245, 20);

    private JLabel nameLabel = DefaultElements.Jlabel("Название", 14, 70, 18);
    private JLabel descriptionLabel = DefaultElements.Jlabel("Описание", 14, 70, 18);
    private JLabel costLabel = DefaultElements.Jlabel("Стоимость", 14, 80, 18);
    private JLabel tableLabel = DefaultElements.Jlabel("Стол", 14, 45, 18);

    private JTextField nameTextField = DefaultElements.JTextField();
    private JTextField descriptionTextField = DefaultElements.JTextField();
    private JTextField costTextField = DefaultElements.JTextField();
    private JTextField tableTextField = DefaultElements.JTextField();
    private JLabel errorLabel = DefaultElements.Error("", 495, 100);

    private JScrollPane tableScroll;
    private JScrollPane drinkScroll;

    private void buttonsActions() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder stringBuilder = new StringBuilder();
                MenuItem drink = new Drink(nameTextField.getText(), descriptionTextField.getText());
                if (nameTextField.getText().length() == 0 || descriptionTextField.getText().length() == 0) {
                    stringBuilder.append("Отсутствует название и/или описание<br>");
                }
                if (costTextField.getText().length() != 0 && costTextField.getText().matches("[0-9]+(.[0-9]*)?")) {
                    drink.setCost(Double.parseDouble(costTextField.getText()));
                } else {
                    stringBuilder.append("Неверная стоимость<br>");
                }
                if (tableTextField.getText().matches("[1-9]+")) {
                    int tableNumber = Integer.parseInt(tableTextField.getText());
                    if (tableNumber > 0 && tableNumber <= 10) {
                        if (stringBuilder.length() == 0)
                            orderManager.addItem(drink, tableNumber);
                    } else {
                        stringBuilder.append("Неверный стол<br>");
                    }
                } else {
                    stringBuilder.append("Неверный стол<br>");
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
                        stringBuilder.append("Неверный стол\n");
                    }
                } else {
                    stringBuilder.append("Неверный стол\n");
                }
                errorLabel.setText(stringBuilder.toString());
            }
        });
    }

    private void tablesInfo() {
        JList<String> list = new JList<String>(tableList);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JTextArea content = new JTextArea(5, 20);
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Получение элемента
                    int selected = list.locationToIndex(e.getPoint());
                    String drinksInfo = "";
                    if (orderManager.getOrder().length <= selected + 1 || orderManager.getOrder()[selected + 1] == null) {
                        content.setText("Заказа нет");
                    } else {
                        content.setText("");
                        MenuItem[] drinks = orderManager.getOrder(selected + 1).getItems();
                        TableOrder order = (TableOrder) orderManager.getOrder(selected + 1);
                        for (int i = 0; i < order.getSize(); i++) {
                            content.append("Drink{ cost: " + drinks[i].getCost() + ", name: " + drinks[i].getName() + " desc: " + drinks[i].getDescription()
                                    + ", type: " + ((Drink) drinks[i]).getType() + "}\n");
                        }
                    }
                }
            }
        });
        tableScroll = new JScrollPane(list);
        drinkScroll = new JScrollPane(content);
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

        drinkScroll.setLocation(150, 195);
        drinkScroll.setSize(350, 200);
    }

    public UI() {
        super("Orders");

        tablesInfo();
        grid();
        buttonsActions();
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

        mainFrame.add(drinkScroll);
        mainFrame.add(tableScroll);
        mainFrame.setBackground(Color.decode("#323232"));
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
    public static JButton Button(String title, int width, int height) {
        JButton newButton = new JButton();
        newButton.setSize(width, height);
        newButton.setBackground(Color.decode("#787777"));
        newButton.setText(title);
        newButton.setForeground(Color.white);
        newButton.setFocusPainted(false);
        newButton.setFont(new Font(Font.SANS_SERIF, 0, 12));
        return newButton;
    }

    public static JLabel Jlabel(String title, int fontSize, int width, int height) {
        JLabel newJlabel = new JLabel(title);
        newJlabel.setSize(width, height);
        newJlabel.setForeground(Color.white);
        newJlabel.setFont(new Font(Font.SANS_SERIF, 0, fontSize));
        return newJlabel;
    }

    public static JLabel Error(String title, int width, int height) {
        JLabel newJlabel = new JLabel(title);
        newJlabel.setSize(width, height);
        newJlabel.setBackground(Color.decode("#787777"));
        newJlabel.setFont(new Font(Font.SANS_SERIF, 0, 12));
        newJlabel.setForeground(Color.orange);
        newJlabel.setOpaque(true);
        return newJlabel;
    }

    public static JTextField JTextField() {
        JTextField newJTextField = new JTextField();
        newJTextField.setSize(120, 20);
        newJTextField.setBackground(Color.decode("#787777"));
        newJTextField.setForeground(Color.white);
        newJTextField.setFont(new Font(Font.SANS_SERIF, 0, 12));
        return newJTextField;
    }
}