package org.neusovo.wallpartner.db.domain.repo;

import org.neusovo.wallpartner.db.domain.AdminUser;
import org.neusovo.wallpartner.db.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

}
