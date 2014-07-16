package org.jugbd.mnet.web.editor;

import org.jugbd.mnet.domain.enums.Relationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyEditorSupport;

/**
 * @author ronygomes
 */
public class RelationshipEditor extends PropertyEditorSupport {

    private static final Logger log = LoggerFactory.getLogger(RelationshipEditor.class);
    @Override
    public void setAsText(String text) {
        for (Relationship relationship : Relationship.values()) {
            if (relationship.getLabel().equalsIgnoreCase(text)) {
                setValue(relationship);
                break;
            }
        }
    }

    @Override
    public String getAsText() {
        log.info("RelationshipEditor value: " + getValue());
        return String.valueOf(getValue());
    }
}
