package org.neusovo.wallpartner.db.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class WxUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String wxOpenid;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastTime;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "wxUser")
    private WxUserInfo wxUserInfo;

    @Override
    public String toString() {
        return "WxUser{" +
                "id=" + id +
                ", wxOpenid='" + wxOpenid + '\'' +
                ", createdDate=" + createdDate +
                ", lastTime=" + lastTime +
                ", wxUserInfo=" + wxUserInfo +
                '}';
    }
}
