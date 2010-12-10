package ch.eiafr.gmd;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

import ch.eiafr.gmd.helpers.I18nHelper;

public class CancelAction extends AbstractAction {
    private final AddPanel addView;

    public CancelAction(AddPanel addView) {
        super();

        this.addView = addView;

        putValue(Action.NAME, I18nHelper.getString("actions.cancel"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addView.stopAdd();
    }
}