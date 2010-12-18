package ch.eiafr.gmd;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public final class GraphMyData {
    public static void main(String[] args) {
        final StatsModel stats = new StatsModel();
        final StatsController controller = new StatsController(stats);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);

                new MainFrame(stats, controller).setVisible(true);
            }
        });
    }
}
