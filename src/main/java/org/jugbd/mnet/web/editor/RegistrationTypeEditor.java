package org.jugbd.mnet.web.editor;

import org.jugbd.mnet.domain.enums.RegistrationType;

import java.beans.PropertyEditorSupport;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/3/15.
 */
public class RegistrationTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        for (RegistrationType gender : RegistrationType.values()) {
            if (gender.name().equalsIgnoreCase(text)) {

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
