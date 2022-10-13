import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AnimBall extends JFrame {
    int iFrame = 1;
    ImageIcon img1 = new ImageIcon(Objects.requireNonNull(getClass().getResource("1.png")));
    ImageIcon img2 = new ImageIcon(Objects.requireNonNull(getClass().getResource("2.png")));
    ImageIcon img3 = new ImageIcon(Objects.requireNonNull(getClass().getResource("3.png")));
    JPanel panel = new JPanel(new BorderLayout());
    JLabel image = new JLabel(new ImageIcon("1.png"));

    AnimBall() {
        super("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        add(image);
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (iFrame) {
                    case 1:
                        image.setIcon(img2);
                        break;
                    case 2:
                        image.setIcon(img3);
                        break;
                    case 3:
                        image.setIcon(img1);
                        iFrame = 0;
                        break;
                }
                iFrame++;
            }
        });
        timer.start();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnimBall();
    }
}
