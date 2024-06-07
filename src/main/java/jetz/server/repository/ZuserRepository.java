package jetz.server.repository;

import java.util.Optional;
import jetz.server.entity.Zuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZuserRepository extends JpaRepository<Zuser, String> {
    Optional<Zuser> findByEmail(String email);

    Zuser findByZname(String zname);
}
