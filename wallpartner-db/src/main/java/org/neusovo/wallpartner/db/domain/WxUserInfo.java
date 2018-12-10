package org.neusovo.wallpartner.db.domain;

import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
public class WxUserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wx_user_id", unique = true)
    private WxUser wxUser;

    private String nickName;

    private String avatarUrl;
    private String country;
    private String province;
    private String city;
    private String language;
    private Byte gender;


    @Override
    public String toString() {
        return "WxUserInfo{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", language='" + language + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getCountry() {
        return country;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getLanguage() {
        return language;
    }

    public Byte getGender() {
        return gender;
    }
}
