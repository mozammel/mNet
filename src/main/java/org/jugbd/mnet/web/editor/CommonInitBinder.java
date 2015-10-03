package org.jugbd.mnet.web.editor;

import org.jugbd.mnet.domain.enums.RegistrationType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/3/15.
 */
@ControllerAdvice
public class CommonInitBinder {
    private static final Logger log = LoggerFactory.getLogger(CommonInitBinder.class);

    @InitBinder
    public void registerCustomEditors(WebDataBinder binder) {
        binder.registerCustomEditor(RegistrationType.class, new RegistrationTypeEditor());
    }
}
