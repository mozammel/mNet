package org.jugbd.mnet.web.editor;

import org.jugbd.mnet.domain.enums.Gender;

import java.beans.PropertyEditorSupport;

/**
 * @author ronygomes
 */
public class GenderEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.getLabel().equalsIgnoreCase(text)) {
                setValue(gender);
                break;
            }
        }
    }

    @Override
    public String getAsText() {
        return String.valueOf(getValue());
    }
}
