package ma.enset.backend.security.repositories;

import ma.enset.backend.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUserName(String username);
}
