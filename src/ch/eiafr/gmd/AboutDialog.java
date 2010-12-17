package ch.eiafr.gmd;
import javax.swing.JDialog;
import javax.swing.JFrame;

import ch.eiafr.gmd.helpers.I18nHelper;

public class AboutDialog extends JDialog {
    
    public AboutDialog(JFrame parent) {
        super(parent, I18nHelper.getString("aboutdialog.title"), true);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        setVisible(true);
    }
    
}
