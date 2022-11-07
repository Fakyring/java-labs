import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        IDocument iDocument = new IDocument() {
            @Override
            public JFrame document() {
                IDocument.super.document();
                return null;
            }
        };
        iDocument.document();
    }
}
