package ch.eiafr.gmd;

import javax.swing.*;

import ch.eiafr.gmd.helpers.I18nHelper;

/**
 * Manages the main menu of the application
 */
public class MainMenu extends JMenuBar {
    private JMenu menuFile      = new JMenu(I18nHelper.getString("menu.file.title"));
    private JMenu menuLanguages = new JMenu(I18nHelper.getString("menu.languages.title"));
    private JMenu menuHelp      = new JMenu(I18nHelper.getString("menu.help.title"));
    
    private JMenuItem itemLoad;
    private JMenuItem itemQuit;
    
    // TODO: also manage with actions??? or not necessary?
    private JRadioButtonMenuItem itemDefault = new JRadioButtonMenuItem(I18nHelper.getString("menu.languages.default"));
    private JRadioButtonMenuItem itemEnglish = new JRadioButtonMenuItem(I18nHelper.getString("menu.languages.english"));
    private JRadioButtonMenuItem itemFrench  = new JRadioButtonMenuItem(I18nHelper.getString("menu.languages.french"));
    
    private JMenuItem itemHelp;
    private JMenuItem itemAbout;
    
    /**
     * Constructor
     * 
     * @param mainFrame
     */
    public MainMenu(MainFrame mainFrame) {
        MenuActions actions = new MenuActions(mainFrame);
        
        itemLoad  = new JMenuItem(actions.ACTION_LOAD);
        itemQuit  = new JMenuItem(actions.ACTION_QUIT);
        itemHelp  = new JMenuItem(actions.ACTION_HELP);
        itemAbout = new JMenuItem(actions.ACTION_ABOUT);
        
        buildMenu();
        createShortcuts();
    }

    private void buildMenu() {
        ButtonGroup languagesGroup = new ButtonGroup();
        languagesGroup.add(itemDefault);
        languagesGroup.add(itemEnglish);
        languagesGroup.add(itemFrench);
        
        menuFile.add(itemLoad);
        menuFile.add(itemQuit);
        menuLanguages.add(itemDefault);
        menuLanguages.add(new JSeparator());
        menuLanguages.add(itemEnglish);
        menuLanguages.add(itemFrench);
        menuHelp.add(itemHelp);
        menuHelp.add(itemAbout);
        
        add(menuFile);
        add(menuLanguages);
        add(menuHelp);
    }
    
    private void createShortcuts() {
        menuFile.setMnemonic(I18nHelper.getString("menu.file.mnemonic").charAt(0));
        menuLanguages.setMnemonic(I18nHelper.getString("menu.languages.mnemonic").charAt(0));
        menuHelp.setMnemonic(I18nHelper.getString("menu.help.mnemonic").charAt(0));
    }
}
