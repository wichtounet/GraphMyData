package ch.eiafr.gmd.helpers;

import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class SwingHelper {
    public static void bind(JComponent table, Action deleteAction, int key) {
        KeyStroke delete = KeyStroke.getKeyStroke(key, 0);
        table.getInputMap().put(KeyStroke.getKeyStroke(key, 0), delete);
        table.getActionMap().put(table.getInputMap().get(KeyStroke.getKeyStroke(key, 0)), deleteAction);
    }
}