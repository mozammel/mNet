package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Vital;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Component
public interface VitalService {

    Vital saveByRegisterId(Vital vital, Long registerId);

    Vital findOne(Long id);
}
