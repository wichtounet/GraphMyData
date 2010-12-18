package ch.eiafr.gmd.helpers;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class I18nHelper {
    private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("ch.eiafr.gmd.i18n.gmd");

    private I18nHelper() {
        throw new AssertionError();
    }

    public static void setLocale(Locale locale){
        RESOURCE_BUNDLE = ResourceBundle.getBundle("ch.eiafr.gmd.i18n.gmd", locale);
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            System.err.println(key + " has not been found in i18n bundle");

            return key;
        }
    }
}