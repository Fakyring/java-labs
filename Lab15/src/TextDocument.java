import javax.swing.*;

public class TextDocument extends JFrame implements IDocument{

    public void documentTXT() {
        JFrame jFrame = (IDocument.super.document());
        JTextField jTextField = new JTextField();
        jFrame.add(jTextField);
        jFrame.setVisible(true);
    }
}
