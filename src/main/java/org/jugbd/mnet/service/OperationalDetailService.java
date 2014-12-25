package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.OperationalDetail;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Component
public interface OperationalDetailService {
    OperationalDetail save(OperationalDetail operationalDetail);

    OperationalDetail findOne(Long id);
}
