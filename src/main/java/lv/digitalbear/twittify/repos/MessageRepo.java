package lv.digitalbear.twittify.repos;

import lv.digitalbear.twittify.domen.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {

	List<Message> findByTag(String tag);

}
