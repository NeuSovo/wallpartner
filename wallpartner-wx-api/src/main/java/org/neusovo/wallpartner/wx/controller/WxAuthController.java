package org.neusovo.wallpartner.wx.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.neusovo.wallpartner.db.domain.WxUser;
import org.neusovo.wallpartner.db.service.WxUserService;
import org.neusovo.wallpartner.wx.annotation.LoginUser;
import org.neusovo.wallpartner.wx.dao.WxReginInfo;
import org.neusovo.wallpartner.wx.service.WxAuthService;
import org.neusovo.wallpartner.wx.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
@RequestMapping("/wx/auth")
@Api
public class WxAuthController {

    private final static boolean DEBUG = true;

    private final WxAuthService wxAuthService;

    private final WxUserService wxUserService;

    private final WxMaService wxMaService;

    @Autowired
    public WxAuthController(WxAuthService wxAuthService, WxUserService wxUserService, WxMaService wxMaService) {
        this.wxAuthService = wxAuthService;
        this.wxUserService = wxUserService;
        this.wxMaService = wxMaService;
    }

    @GetMapping("list")
    @ApiOperation(value = "获取所有用户", response = WxUser.class)
    public List<WxUser> getUsers() {
        return wxAuthService.getUsers();
    }

    @PostMapping("reg/{code}")
    @ApiOperation(value = "注册", response = R.class)
    public R Reg(@RequestBody WxReginInfo wxReginInfo, @PathVariable("code") String code) {
        String sessionKey = null;
        String openId = null;
        try {
            WxMaJscode2SessionResult result = this.wxMaService.getUserService().getSessionInfo(code);
            sessionKey = result.getSessionKey();
            openId = result.getOpenid();
        } catch (Exception e) {
            if (DEBUG) {
                sessionKey = "debug";
                openId = code;
            } else {
                return new R().error("e.getMessage()");
            }
        }

        return wxAuthService.regWxUser(wxReginInfo, openId);
    }

    @GetMapping("check")
    @ApiOperation(value = "验证token", authorizations = {@Authorization(value = "apiKey")})
    public R check(@ApiIgnore @LoginUser Long userId) {
        if (userId == null) {
            return new R().error("token error");
        }
        return new R().success().setData("info", wxUserService.getOne(userId));
    }


    private static final int _1M = 1024*1024;

    @PostMapping(value = "/test")
    public R test(Integer mem, Integer num ){
        for (int i = 0; i < num ; i++) {
            byte [] mems = new byte[mem * _1M];
        }

        return new R().success();
    }
}
