package org.jugbd.mnet.web.editor;

import org.jugbd.mnet.domain.enums.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;

/**
 * Created by Bazlur Rahman Rokon on 7/17/14.
 */

public class AuthorityEditor extends PropertyEditorSupport {
    private static final Logger log = LoggerFactory.getLogger(AuthorityEditor.class);

    @Override
    public void setAsText(String text) {
        for (Role authority : Role.values()) {
            if (authority.name().equalsIgnoreCase(text)) {
                setValue(authority);
                break;
            }
        }
    }

    @Override
    public String getAsText() {
        log.info("AuthorityEditor value ={}", getValue());
        return String.valueOf(getValue());
    }
}
