package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.LifeStyle;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Component
public interface LifeStyleService {
    LifeStyle save(LifeStyle lifeStyle);

    LifeStyle findOne(Long id);

}
