package ch.eiafr.gmd;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.util.Locale;

import ch.eiafr.gmd.helpers.I18nHelper;

public final class GraphMyData {
    public static void main(String[] args) {
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        launch("en", new StatsModel());
    }

    public static void launch(final String language, final Stats stats) {
        if("fr".equals(language)){
            Locale.setDefault(Locale.FRENCH);
        } else {
            Locale.setDefault(Locale.ENGLISH);
        }
        
        I18nHelper.setLocale(Locale.getDefault());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(stats, new StatsController(stats), language).setVisible(true);
            }
        });
    }
}