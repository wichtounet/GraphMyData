package ch.eiafr.gmd;

import javax.swing.JFrame;

import java.awt.HeadlessException;

import ch.eiafr.gmd.helpers.Config;
import ch.eiafr.gmd.helpers.I18nHelper;

public class MainFrame extends JFrame {
    public MainFrame(Stats stats) throws HeadlessException {
        super();

        setTitle(I18nHelper.getString("title"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(Config.getIntValue("frame.width"), Config.getIntValue("frame.height"));

        setContentPane(new MainPanel(stats));
    }
}
