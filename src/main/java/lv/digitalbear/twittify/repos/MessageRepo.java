package lv.digitalbear.twittify.repos;

import lv.digitalbear.twittify.domen.Message;
import lv.digitalbear.twittify.domen.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MessageRepo extends JpaRepository<Message, Long> {

	Page<Message> findByTag(String tag, Pageable pageable);

	@Query("from Message m where m.author = :author")
	Page<Message> findByUser(Pageable pageable, @Param("author") User author);
}
