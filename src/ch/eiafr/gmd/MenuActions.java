package ch.eiafr.gmd;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import ch.eiafr.gmd.helpers.I18nHelper;

/**
 * Group all actions relative to the menu
 */
public class MenuActions {
    
    private MainFrame mainFrame;
    
    public final Action ACTION_LOAD  = new LoadAction();
    public final Action ACTION_QUIT  = new QuitAction();
    public final Action ACTION_HELP  = new HelpAction();
    public final Action ACTION_ABOUT = new AboutAction();

    public MenuActions(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
    
    class LoadAction extends AbstractAction {
        public LoadAction() {
            super(I18nHelper.getString("menu.file.load"));
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(I18nHelper.getString("menu.file.load.accel")));
            putValue(AbstractAction.SHORT_DESCRIPTION, I18nHelper.getString("menu.file.load.desc"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: mainFrame.loadData() ?
        }
    }

    class QuitAction extends AbstractAction {
        public QuitAction() {
            super(I18nHelper.getString("menu.file.quit"));
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(I18nHelper.getString("menu.file.quit.accel")));
            putValue(AbstractAction.SHORT_DESCRIPTION, I18nHelper.getString("menu.file.quit.desc"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.quit();
        }
    }
    
    class HelpAction extends AbstractAction {
        public HelpAction() {
            super(I18nHelper.getString("menu.help.help"));
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(I18nHelper.getString("menu.help.help.accel")));
            putValue(AbstractAction.SHORT_DESCRIPTION, I18nHelper.getString("menu.help.help.desc"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.openHelp();
        }
    }
    
    class AboutAction extends AbstractAction {
        public AboutAction() {
            super(I18nHelper.getString("menu.help.about"));
            putValue(AbstractAction.SHORT_DESCRIPTION, I18nHelper.getString("menu.help.about.desc"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.openAbout();
        }
    }
    
}
