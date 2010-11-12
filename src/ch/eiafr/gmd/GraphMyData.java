package ch.eiafr.gmd;

import javax.swing.SwingUtilities;

public class GraphMyData {
    public static void main(String[] args) {
        final Stats stats = new StatsModel();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame(stats).setVisible(true);
            }
        });
    }
}
