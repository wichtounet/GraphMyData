package ch.eiafr.gmd.helpers;

import java.util.ResourceBundle;

public class I18nHelper {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("ch.eiafr.gmd.i18n.gmd");

    public static String getString(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}