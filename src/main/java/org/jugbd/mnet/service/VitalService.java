package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.Vital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Bazlur Rahman Rokon
 * @since 10/17/14.
 */
@Component
public interface VitalService {

    Vital saveByRegisterId(Vital vital, Long registerId);

    Vital findOne(Long id);

    List<Vital> findByRegisterId(Long registerId);

    Long delete(Long id);
}
