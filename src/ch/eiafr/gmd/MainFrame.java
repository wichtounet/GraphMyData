package ch.eiafr.gmd;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.HeadlessException;

import ch.eiafr.gmd.helpers.Config;
import ch.eiafr.gmd.helpers.I18nHelper;

public class MainFrame extends JFrame {
    private final Stats model;

    public MainFrame(Stats stats, StatsController controller) throws HeadlessException {
        super();

        model = stats;

        setTitle(I18nHelper.getString("title"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(Config.getIntValue("frame.width"), Config.getIntValue("frame.height"));
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(Config.getIntValue("frame.width"), Config.getIntValue("frame.height")));
        
        setJMenuBar(new MainMenu(this));

        setContentPane(new MainPanel(stats, controller));
    }
    
    public void openHelp() {
        new HelpDialog(this);
        
    }

    public void openAbout() {
        new AboutDialog(this);
    }
    
    public void quit() {
        dispose();
        System.exit(0);
    }

    public Stats getModel() {
        return model;
    }
}