package ch.eiafr.gmd;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import ch.eiafr.gmd.helpers.I18nHelper;

public class ValidateAction extends AbstractAction {
    private final StatsController controller;
    private final AddPanel addView;

    public ValidateAction(StatsController controller, AddPanel addView) {
        super();

        this.controller = controller;
        this.addView = addView;

        putValue(Action.NAME, I18nHelper.getString("actions.add"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String firstValue = addView.getTextField1().getText();
        String secondValue = addView.getTextField2().getText();

        if (firstValue.isEmpty() || secondValue.isEmpty()) {
            JOptionPane.showMessageDialog(null, I18nHelper.getString("actions.add.errors.not.enough"));
        } else if (isNotNumeric(firstValue) || isNotNumeric(secondValue)) {
            JOptionPane.showMessageDialog(null, I18nHelper.getString("actions.add.errors.not.numeric"));
        } else {
            Integer[] values = {
                    Integer.parseInt(firstValue),
                    Integer.parseInt(secondValue)
            };

            controller.addResult(values);

            addView.stopAdd();
        }
    }

    private static boolean isNotNumeric(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return true;
        }

        return false;
    }
}