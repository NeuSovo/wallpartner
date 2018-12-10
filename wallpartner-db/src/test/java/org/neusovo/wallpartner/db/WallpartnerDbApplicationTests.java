package org.neusovo.wallpartner.db;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neusovo.wallpartner.db.domain.WxUser;
import org.neusovo.wallpartner.db.domain.WxUserInfo;
import org.neusovo.wallpartner.db.domain.repo.WxUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class WallpartnerDbApplicationTests {

    @Autowired
    WxUserRepository userRepository;

    @Test
    public void contextLoads() {

//        WxUser wxUser = new WxUser();
//        wxUser.setWxOpenid("123");
//
//        WxUserInfo wxUserInfo = new WxUserInfo();
//        wxUserInfo.setNickName("hello");
//        wxUserInfo.setWxUser(wxUser);
//        wxUser.setWxUserInfo(wxUserInfo);
//        userRepository.save(wxUser);
//        System.out.println(userRepository.findByWxOpenid("123").toString());
//        assert userRepository.findByWxOpenid("123").getWxOpenid().equals(wxUser.getWxOpenid());
    }

}
