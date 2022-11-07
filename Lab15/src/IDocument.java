import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface IDocument {
    public default JFrame document() {
        JFrame jFrame = new JFrame();
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuNew = new JMenu("New");
        JMenu menuOpen = new JMenu("Open");

        JMenuItem menuSave = new JMenuItem("Save");
        JMenuItem menuExit = new JMenuItem("Exit");

        JMenuItem music = new JMenuItem("mp3");
        JMenuItem image = new JMenuItem("PNG");
        JMenuItem text = new JMenuItem("text");
        JMenuItem omusic = new JMenuItem("mp3");
        JMenuItem oimage = new JMenuItem("PNG");
        JMenuItem otext = new JMenuItem("text");

        //
        menuFile.add(menuNew);
        menuFile.add(menuOpen);
        menuFile.add(menuSave);
        menuFile.add(menuExit);

        //New
        menuNew.add(music);
        menuNew.add(image);
        menuNew.add(text);

        //Open
        menuOpen.add(omusic);
        menuOpen.add(oimage);
        menuOpen.add(otext);

        //Text document
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ((TextDocument) new CreateTextDocument().CreateNew()).documentTXT();
            }
        });
        otext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ((TextDocument) new CreateTextDocument().CreateNew()).documentTXT();
            }
        });

        //Image
        image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ((ImageDocument) new CreateImageDocument().CreateNew()).documentIMG();
            }
        });
        oimage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                ((ImageDocument) new CreateImageDocument().CreateNew()).documentIMG();
            }
        });

        //Music
        music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Currently unavailable!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        omusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Currently unavailable!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Exit
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
            }
        });

        //Saving
        menuSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saved!", "Save", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jMenuBar.add(menuFile);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
