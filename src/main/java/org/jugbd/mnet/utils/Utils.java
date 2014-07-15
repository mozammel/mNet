package org.jugbd.mnet.utils;

import org.jugbd.mnet.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Bazlur Rahman Rokon on 7/6/14.
 */
public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    /**
     * Update given entity with authority and time
     *
     * @param entity
     * @param user
     */
    public static <T> void updatePersistentProperties(T entity, User user) {

        try {
            for (Field field : entity.getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().equals("lastUpdatedBy")) {
                    field.setAccessible(true);
                    field.set(entity, user);
                } else if (field.getName().equals("dateLastUpdated")) {
                    field.setAccessible(true);
                    field.set(entity, new Date());
                }
                if (isNew(entity)) {
                    if (field.getName().equals("createdBy")) {
                        field.setAccessible(true);
                        field.set(entity, user);
                    }
                    if (field.getName().equals("dateCreated")) {
                        field.setAccessible(true);
                        field.set(entity, new Date());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            log.error("unable to update persistent properties", e);
        }
    }

    /**
     * Checks if the given entity is new or not
     *
     * @param entity
     * @return true if entity is a new or return false if entity is not new
     */
    public static <T> boolean isNew(T entity) {
        log.debug("isNew");
        for (Field field : entity.getClass().getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase("id")) {
                field.setAccessible(true);
                try {
                    if (field.get(entity) == null) {
                        return true;
                    }
                } catch (IllegalAccessException e) {
                    log.error("unable to find whether id is new or not", e);
                }
            }
        }
        return false;
    }
}
