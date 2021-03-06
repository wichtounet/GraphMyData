package ch.eiafr.gmd;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import ch.eiafr.gmd.helpers.Config;
import ch.eiafr.gmd.helpers.I18nHelper;

/**
 * Represents the help dialog shown when the user
 * clicks on the help menu
 */
public class HelpDialog extends JDialog implements HyperlinkListener {
    
    private static String HELP_PATH = "ch/eiafr/gmd/resources/";
    
    /**
     * Constructor
     * 
     * @param parent the parent component
     */
    public HelpDialog(JFrame parent) {
        super(parent, I18nHelper.getString("helpdialog.title"), false);
        setSize(Config.getIntValue("helpdialog.width"), Config.getIntValue("helpdialog.height"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        try {
            buildUI();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "", "", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    private void buildUI() throws IOException {
        getContentPane().setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        
        // Create the JEditorPane from the help HTML file
        URL help = getClass().getClassLoader().getResource(HELP_PATH + I18nHelper.getString("help.file.name"));

        JEditorPane helpPane = new JEditorPane(help);
        helpPane.setEditable(false);
        helpPane.addHyperlinkListener(this);
        
        JScrollPane scrollHelp = new JScrollPane(helpPane);
        
        // Title
        JLabel lb = new JLabel(I18nHelper.getString("helpdialog.content.title"), JLabel.CENTER);
        lb.setFont(lb.getFont().deriveFont(20.0f));
        add(lb, gbc);
        
        // Help content
        gbc.gridy = 1;
        gbc.weighty = 8.0;
        add(scrollHelp, gbc);
        
        // Button
        JButton buttonClose = new JButton(I18nHelper.getString("helpdialog.button.close"));
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.NONE;
        add(buttonClose, gbc);
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
            JEditorPane helpPane = (JEditorPane)e.getSource();
            
            // Here we follow only anchor links
            if(e.getDescription().startsWith("#"))
                helpPane.scrollToReference(e.getDescription().substring(1));
        }
    }
}
