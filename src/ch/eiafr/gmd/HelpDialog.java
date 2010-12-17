package ch.eiafr.gmd;

import javax.swing.JDialog;
import javax.swing.JFrame;

import ch.eiafr.gmd.helpers.I18nHelper;

public class HelpDialog extends JDialog {

    public HelpDialog(JFrame parent) {
        super(parent, I18nHelper.getString("helpdialog.title"), true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        setVisible(true);
    }
    
}
