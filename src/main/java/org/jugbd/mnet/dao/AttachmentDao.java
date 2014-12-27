package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/28/14.
 */
@Repository
public interface AttachmentDao extends JpaRepository<Attachment, Long> {
}
