package jetz.server.repository;

import jetz.server.entity.Zuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZuserRepository extends JpaRepository<Zuser, String> {
}
