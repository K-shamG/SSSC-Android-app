package ghelani.kshamina.sssc_android_app.ui.common.list.model;

import ghelani.kshamina.sssc_android_app.ui.common.events.FormInputItemListener;

public class InputItem implements DiffItem {

    public enum InputStyle {
        BUTTON,
        TEXT,
        SWITCH,
        SELECTION_SCREEN
    }

    private String value;
    private String hint;
    private String name;
    private FormInputItemListener listener;
    private int keyboardType;
    private InputStyle type;
    private String error;

    public InputItem(String value,String hint, String name, InputStyle type, int keyboardType, FormInputItemListener listener) {
        this.hint = hint;
        this.name = name;
        this.listener = listener;
        this.type = type;
        this.keyboardType = keyboardType;
        this.value = value;
        this.error =  "";
    }

    public InputItem(String hint, String name, int keyboardType, FormInputItemListener listener) {
        this("",hint, name, InputStyle.TEXT, keyboardType, listener);
    }

    public InputItem(String hint, String name, InputStyle type, int keyboardType, FormInputItemListener listener) {
        this("",hint, name, type,keyboardType, listener);
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FormInputItemListener getListener() {
        return listener;
    }

    public void setListener(FormInputItemListener listener) {
        this.listener = listener;
    }

    public InputStyle getType() {
        return type;
    }

    public void setType(InputStyle type) {
        this.type = type;
    }

    public int getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(int keyboardType) {
        this.keyboardType = keyboardType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
