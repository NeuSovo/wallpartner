package org.neusovo.wallpartner.db.domain.repo;

import org.neusovo.wallpartner.db.domain.WxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WxUserRepository extends JpaRepository<WxUser, Long> {

    WxUser findByWxOpenid(String openid);

}
