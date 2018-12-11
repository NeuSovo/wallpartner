package org.neusovo.wallpartner.db.service;

import org.neusovo.wallpartner.db.domain.WxUser;

import java.util.List;
import java.util.Optional;

public interface WxUserService {
    boolean addWxUser(WxUser user);

    List<WxUser> allUsers();

    WxUser findByWxOpenid(String openid);

    Optional<WxUser> getOne(Long id);
}
