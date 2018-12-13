package org.neusovo.wallpartner.db.domain;

import lombok.Data;
import org.neusovo.wallpartner.db.common.Role;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<AdminUser> users;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", users=" + users +
                ", role=" + role +
                '}';
    }
}


