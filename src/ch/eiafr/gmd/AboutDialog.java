package ch.eiafr.gmd;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ch.eiafr.gmd.helpers.Config;
import ch.eiafr.gmd.helpers.I18nHelper;

/**
 * Represents the about dialog shown when the user
 * clicks on the about menu
 */
public class AboutDialog extends JDialog {
    
    /**
     * Constructor
     * 
     * @param parent the parent component
     */
    public AboutDialog(JFrame parent) {
        super(parent, I18nHelper.getString("aboutdialog.title"), true);
        setSize(Config.getIntValue("aboutdialog.width"), Config.getIntValue("aboutdialog.height"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        buildUI();
        
        setVisible(true);
    }
    
    private void buildUI() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        // Title
        JLabel lb = new JLabel(I18nHelper.getString("aboutdialog.content.title"), JLabel.CENTER);
        lb.setFont(lb.getFont().deriveFont(20.0f));
        add(lb, gbc);
        
        // Copyright
        JLabel copyright = new JLabel(I18nHelper.getString("aboutdialog.content.copyright"), JLabel.CENTER);
        gbc.gridy = 1;
        add(copyright, gbc);
        
        // Description
        JLabel description = new JLabel(I18nHelper.getString("aboutdialog.content.desc"));
        gbc.gridy = 2;
        add(description, gbc);
        
        // Authors
        JLabel authors = new JLabel("<html>" + I18nHelper.getString("aboutdialog.content.authors") + "<ul><li>" +
                                    I18nHelper.getString("aboutdialog.content.author1") +
                                    "</li><li>" +
                                    I18nHelper.getString("aboutdialog.content.author2") +
                                    "</li><li>" +
                                    I18nHelper.getString("aboutdialog.content.author3") +
                                    "</li><ul></html>");
        gbc.gridy = 3;
        add(authors, gbc);
        
        // Button
        JButton buttonClose = new JButton(I18nHelper.getString("aboutdialog.button.close"));
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        add(buttonClose, gbc);
    }
}