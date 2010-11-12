package ch.eiafr.gmd;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
    public ButtonPanel() {
        super();

        add(new JButton("Test1"));
        add(new JButton("Test2"));
    }
}