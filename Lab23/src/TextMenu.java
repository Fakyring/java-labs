import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextMenu extends JFrame {
    public TextMenu() {
        JTextArea textField = new JTextArea();
        JMenuBar menuBar = new JMenuBar();

        Font tnr = new Font("Times new roman", Font.BOLD, 20);
        Font msss = new Font("MS Sans Serif", Font.BOLD, 20 );
        Font cn = new Font("Courier New", Font.BOLD, 20 );

        JMenu color = new JMenu("Цвет");
        JMenu font = new JMenu("Шрифт");
        JMenuItem blue = new JMenuItem("Синий");
        JMenuItem red = new JMenuItem("Красный");
        JMenuItem black = new JMenuItem("Черный");
        JMenuItem timesNewRoman = new JMenuItem("Times New Roman");
        JMenuItem msSansSerif = new JMenuItem("MS Sans Serif");
        JMenuItem courierNew = new JMenuItem("Courier New");
        color.add(blue);
        color.add(red);
        color.add(black);
        font.add(timesNewRoman);
        font.add(msSansSerif);
        font.add(courierNew);

        textField.setFont(tnr);

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setForeground(Color.blue);
            }
        });

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setForeground(Color.red);
            }
        });

        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setForeground(Color.black);
            }
        });

        timesNewRoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setFont(tnr);
            }
        });

        msSansSerif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setFont(msss);
            }
        });

        courierNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setFont(cn);
            }
        });

        menuBar.add(color);
        menuBar.add(font);

        setSize(300, 300);
        setJMenuBar(menuBar);
        add(textField);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextMenu();
    }
}