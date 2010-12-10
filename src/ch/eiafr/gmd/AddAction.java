package ch.eiafr.gmd;

import javax.swing.AbstractAction;
import javax.swing.Action;

import java.awt.event.ActionEvent;

import ch.eiafr.gmd.helpers.I18nHelper;

public class AddAction extends AbstractAction {
    private final AddPanel addPanel;

    public AddAction(AddPanel addPanel) {
        super();

        this.addPanel = addPanel;

        putValue(Action.NAME, I18nHelper.getString("actions.add"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addPanel.startAdd();
    }
}