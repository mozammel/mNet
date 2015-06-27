package org.jugbd.mnet.dao;

import org.jugbd.mnet.domain.PictureInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
@Repository
public interface PictureInformationDao extends JpaRepository<PictureInformation, Long> {
    PictureInformation findPictureInformationByRegister_Id(Long id);
}
