package ch.eiafr.gmd.helpers;

import java.util.ResourceBundle;

public final class I18nHelper {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("ch.eiafr.gmd.i18n.gmd");

    private I18nHelper() {
        throw new AssertionError();
    }

    public static String getString(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}