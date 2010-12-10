package ch.eiafr.gmd;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;

import ch.eiafr.gmd.helpers.I18nHelper;
import ch.eiafr.gmd.helpers.SwingHelper;
import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

public class AddPanel extends JPanel {
    private final JTextField textField2;
    private final JTextField textField1;

    AddPanel(StatsController controller) {
        super();

        setBorder(BorderFactory.createTitledBorder(I18nHelper.getString("add.view.title")));

        ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();

        layout.addRow("a<a2b");
        layout.addRow("c<c2d");

        setLayout(layout);

        Action validateAction = new ValidateAction(controller, this);

        add(new JLabel(I18nHelper.getString("add.view.label.first")), "a");

        textField1 = new JTextField(5);
        SwingHelper.bind(textField1, validateAction, KeyEvent.VK_ENTER);
        add(textField1, "b");

        add(new JLabel(I18nHelper.getString("add.view.label.second")), "c");

        textField2 = new JTextField(5);
        SwingHelper.bind(textField2, validateAction, KeyEvent.VK_ENTER);
        add(textField2, "d");

        setVisible(false);
    }

    public void startAdd() {
        setVisible(true);
        textField1.requestFocus();
    }

    public void stopAdd() {
        setVisible(false);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }
}