package org.neusovo.wallpartner.wx.service;

import com.auth0.jwt.JWTSigner;
import org.neusovo.wallpartner.db.domain.WxUser;
import org.neusovo.wallpartner.db.domain.WxUserInfo;
import org.neusovo.wallpartner.db.service.WxUserService;
import org.neusovo.wallpartner.wx.dao.WxReginInfo;
import org.neusovo.wallpartner.wx.util.JWTUtil;
import org.neusovo.wallpartner.wx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxAuthService {

    @Autowired
    private WxUserService wxUserService;

    public R regWxUser(WxReginInfo wxReginInfo, String openid){
        WxUserInfo wxUserInfo = new WxUserInfo();

        wxUserInfo.setNickName(wxReginInfo.getNickName());
        wxUserInfo.setAvatarUrl(wxReginInfo.getAvatarUrl());
        wxUserInfo.setCity(wxReginInfo.getCity());
        wxUserInfo.setGender(wxReginInfo.getGender());
        wxUserInfo.setCountry(wxReginInfo.getCountry());
        wxUserInfo.setLanguage(wxReginInfo.getLanguage());
        wxUserInfo.setProvince(wxReginInfo.getProvince());


        WxUser wxUser;

        wxUser = wxUserService.findByWxOpenid(openid);
        if (wxUser!=null){
            wxUserInfo.setWxUser(wxUser);
            wxUser.setWxUserInfo(wxUserInfo);
        }else{
            wxUser = new WxUser();
            wxUser.setWxOpenid(openid);
            wxUserInfo.setWxUser(wxUser);
            wxUser.setWxUserInfo(wxUserInfo);
        }


        if (wxUserService.addWxUser(wxUser)){
            String token = JWTUtil.sign(wxUser);
            return new R().success().setData("token", token)
                    .setData("info",wxUser);
        }else{
            return new R().error("注册失败");
        }
    }

    public List<WxUser> getUsers(){
        return wxUserService.allUsers();
    }

}
