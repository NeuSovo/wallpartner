package org.neusovo.wallpartner.db.service.impl;

import org.neusovo.wallpartner.db.domain.WxUser;
import org.neusovo.wallpartner.db.domain.repo.WxUserRepository;
import org.neusovo.wallpartner.db.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxUserServiceimpl implements WxUserService {

    @Autowired
    WxUserRepository wxUserRepository;

    @Override
    public boolean addWxUser(WxUser user) {
        wxUserRepository.save(user);
        return true;
    }

    @Override
    public List<WxUser> allUsers() {
        return wxUserRepository.findAll();
    }

    @Override
    public WxUser findByWxOpenid(String openid) {
        return wxUserRepository.findByWxOpenid(openid);
    }
}
