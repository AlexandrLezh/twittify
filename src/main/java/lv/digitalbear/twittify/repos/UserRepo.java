package lv.digitalbear.twittify.repos;

import lv.digitalbear.twittify.domen.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findByActivationCode(String code);
}
