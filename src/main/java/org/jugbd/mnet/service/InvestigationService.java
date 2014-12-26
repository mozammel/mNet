package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Investigation;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Component
public interface InvestigationService {
    Investigation save(Investigation investigation);

    Investigation findOne(Long id);

}
