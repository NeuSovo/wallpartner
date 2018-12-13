package org.neusovo.wallpartner.db.domain.repo;

import org.neusovo.wallpartner.db.domain.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepo extends JpaRepository<AdminUser, Long> {

}
