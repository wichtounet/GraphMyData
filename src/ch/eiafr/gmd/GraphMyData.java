package ch.eiafr.gmd;

import javax.swing.SwingUtilities;

public final class GraphMyData {
    public static void main(String[] args) {
        final StatsModel stats = new StatsModel();
        final StatsController controller = new StatsController(stats);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(stats, controller).setVisible(true);
            }
        });
    }
}
