package lv.digitalbear.twittify.repos;

import lv.digitalbear.twittify.domen.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepo extends JpaRepository<Message, Long> {

	Page<Message> findByTag(String tag, Pageable pageable);

}
