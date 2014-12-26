package org.jugbd.mnet.service;

import org.jugbd.mnet.domain.ComplicationManagement;
import org.springframework.stereotype.Component;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/26/14.
 */
@Component
public interface ComplicationManagementService {

    ComplicationManagement save(ComplicationManagement complicationManagement);

    ComplicationManagement findOne(Long id);
}
