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
        for (RegistrationType registrationType : RegistrationType.values()) {
            if (registrationType.name().equalsIgnoreCase(text)) {

                setValue(registrationType);
                break;
            }
        }

        if (text.equalsIgnoreCase("opd")) setValue(RegistrationType.OUTDOOR);
        else if (text.equalsIgnoreCase("ipd")) setValue(RegistrationType.INDOOR);
    }

    @Override
    public String getAsText() {

        return String.valueOf(getValue());
    }
}
