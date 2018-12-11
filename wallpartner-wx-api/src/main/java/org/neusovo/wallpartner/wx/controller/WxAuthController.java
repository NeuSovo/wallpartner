package org.neusovo.wallpartner.wx.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.neusovo.wallpartner.db.domain.WxUser;
import org.neusovo.wallpartner.wx.annotation.LoginUser;
import org.neusovo.wallpartner.wx.dao.WxReginInfo;
import org.neusovo.wallpartner.wx.service.WxAuthService;
import org.neusovo.wallpartner.wx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableSwagger2
@RestController
@RequestMapping("/wx/auth")
@Api
public class WxAuthController {

    private final static boolean DEBUG = true;

    @Autowired
    private WxAuthService wxAuthService;

    @Autowired
    private WxMaService wxMaService;

    @GetMapping("list")
    @ApiOperation(value = "获取所有用户", response = WxUser.class)
    public List<WxUser> getUsers(){
        return wxAuthService.getUsers();
    }

    @PostMapping("reg/{code}")
    @ApiOperation(value = "注册", response = R.class)
    public R Reg(@RequestBody WxReginInfo wxReginInfo, @PathVariable("code") String code){
        String sessionKey = null;
        String openId = null;
        try {
            WxMaJscode2SessionResult result = this.wxMaService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            if (DEBUG){
                sessionKey = "debug";
                openId = code;
            }else {
                return new R().error("e.getMessage()");
            }
        }

        return wxAuthService.regWxUser(wxReginInfo, openId);
    }

    @GetMapping("check")
    public WxUser check(@ApiIgnore @LoginUser WxUser wxuser){
        System.out.println(wxuser);

        return wxuser;
    }

}
