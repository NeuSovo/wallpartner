package org.neusovo.wallpartner.db.service;

import org.neusovo.wallpartner.db.domain.WxUser;

import java.util.List;

public interface WxUserService {
    boolean addWxUser(WxUser user);

    List<WxUser> allUsers();

    WxUser findByWxOpenid(String openid);
}
