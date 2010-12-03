package ch.eiafr.gmd;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import ch.eiafr.gmd.helpers.I18nHelper;

public class AddAction extends AbstractAction {
    private final StatsController controller;
    private static final Pattern PATTERN = Pattern.compile(" ");

    public AddAction(StatsController controller) {
        super();

        this.controller = controller;

        putValue(Action.NAME, I18nHelper.getString("actions.add"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = JOptionPane.showInputDialog(null, I18nHelper.getString("actions.add.ask"));

        if(input != null){
            String[] parts = PATTERN.split(input);
            Integer[] values = new Integer[parts.length];

            if(parts.length < 2){
                JOptionPane.showMessageDialog(null, I18nHelper.getString("actions.add.errors.not.enough"));
            } else if(parts.length > 2){
                JOptionPane.showMessageDialog(null, I18nHelper.getString("actions.add.errors.too.many"));
            } else {
                for (int i = 0; i < parts.length; i++) {
                    values[i] = Integer.parseInt(parts[i].trim());
                }

                controller.addResult(values);
            }
        }
    }
}