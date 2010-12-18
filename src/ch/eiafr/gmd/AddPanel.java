package ch.eiafr.gmd;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import ch.eiafr.gmd.helpers.I18nHelper;
import ch.eiafr.gmd.helpers.SwingHelper;
import com.atticlabs.zonelayout.swing.ZoneLayout;
import com.atticlabs.zonelayout.swing.ZoneLayoutFactory;

public class AddPanel extends JPanel {
    private JFormattedTextField textField2;
    private JFormattedTextField textField1;

    AddPanel(StatsController controller) {
        super();

        setBorder(BorderFactory.createTitledBorder(I18nHelper.getString("add.view.title")));

        ZoneLayout layout = ZoneLayoutFactory.newZoneLayout();

        layout.addRow("a<a2b");
        layout.addRow("c<c2d");
        layout.addRow("e2f..");

        setLayout(layout);

        Action validateAction = new ValidateAction(controller, this);
        Action cancelAction = new CancelAction(this);

        add(new JLabel(I18nHelper.getString("add.view.label.first")), "a");

        textField1 = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textField1.setInputVerifier(new SimpleVerifier());
        textField1.setColumns(5);
        SwingHelper.bind(textField1, validateAction, KeyEvent.VK_ENTER);
        add(textField1, "b");

        add(new JLabel(I18nHelper.getString("add.view.label.second")), "c");

        textField2 = new JFormattedTextField(NumberFormat.getIntegerInstance());
        textField2.setInputVerifier(new SimpleVerifier());
        textField2.setColumns(5);
        SwingHelper.bind(textField2, validateAction, KeyEvent.VK_ENTER);
        add(textField2, "d");

        add(new JButton(validateAction), "e");
        add(new JButton(cancelAction), "f");

        setVisible(false);
    }

    public void startAdd() {
        setVisible(true);
        textField1.requestFocus();
    }

    public void stopAdd() {
        textField1.setText("");
        textField2.setText("");

        setVisible(false);
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    private static class SimpleVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            if (!(input instanceof JFormattedTextField)) {
                return true; // give up focus
            }

            boolean valid = ((JFormattedTextField) input).isEditValid();

            if(!valid){
                input.setForeground(Color.red);

                Toolkit.getDefaultToolkit().beep();
            } else {
                input.setForeground(Color.black);
            }

            return valid;
        }
    }
}
