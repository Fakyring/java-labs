import javax.swing.*;
import java.awt.*;

public class ImageDocument implements IDocument {
    public void documentIMG() {
        JFrame jFrame = (IDocument.super.document());
        JLabel jLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("img.png").getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT));
        jLabel.setIcon(imageIcon);
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }
}
