package org.neusovo.wallpartner.db.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private UserRole userRole;
}
