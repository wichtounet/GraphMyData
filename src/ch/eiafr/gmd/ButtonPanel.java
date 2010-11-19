package ch.eiafr.gmd;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class ButtonPanel extends JPanel {
    public ButtonPanel(StatsController controller) {
        super();

        add(new JButton(new AddAction(controller)));
        add(new JButton("Test2"));
    }
}