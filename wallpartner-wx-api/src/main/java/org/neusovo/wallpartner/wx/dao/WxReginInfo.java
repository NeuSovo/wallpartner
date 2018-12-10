package org.neusovo.wallpartner.wx.dao;

import lombok.Data;

@Data
public class WxReginInfo {
    private String nickName;

    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private String language;
    private Byte gender;
}
