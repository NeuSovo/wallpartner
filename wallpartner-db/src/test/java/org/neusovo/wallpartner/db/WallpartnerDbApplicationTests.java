package org.neusovo.wallpartner.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neusovo.wallpartner.db.domain.AdminUser;
import org.neusovo.wallpartner.db.domain.UserRole;
import org.neusovo.wallpartner.db.domain.repo.AdminUserRepo;
import org.neusovo.wallpartner.db.domain.repo.UserRoleRepo;
import org.neusovo.wallpartner.db.domain.repo.WxUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaAuditing
public class WallpartnerDbApplicationTests {

    @Autowired
    WxUserRepository userRepository;

    @Autowired
    AdminUserRepo adminUserRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    @Test
    public void testUsers() {

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

    @Test
    public void testAdmin(){
//        UserRole ur = new UserRole();
//
//        ur.setRole(Role.ADMIN);
//
//        userRoleRepo.save(ur);

        UserRole ur = userRoleRepo.getOne((long) 4);
        AdminUser adminUser = new AdminUser();
        adminUser.setUserName("1");
        adminUser.setPassword("2");
        adminUser.setUserRole(ur);
        adminUserRepo.save(adminUser);


        System.out.println(adminUserRepo.findAll());
//        System.out.println(userRoleRepo.getOne((long) 4).toString());

        System.out.println(ur);
    }

}
