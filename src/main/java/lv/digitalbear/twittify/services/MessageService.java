package lv.digitalbear.twittify.services;

import jakarta.persistence.EntityManager;
import lv.digitalbear.twittify.domain.Message;
import lv.digitalbear.twittify.domain.User;
import lv.digitalbear.twittify.domain.dto.MessageDto;
import lv.digitalbear.twittify.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	private MessageRepo messageRepo;
	@Autowired
	private EntityManager em;

	public Page<MessageDto> messagesList(Pageable pageable, String filter, User user) {

		if (filter != null && !filter.isEmpty()) {
			return messageRepo.findByTag(filter, pageable, user);
		} else {
			return messageRepo.findAll(pageable, user);
		}
	}

	public Page<MessageDto> messagesListForUser(Pageable pageable, User currentUser, User author) {
		return messageRepo.findByUser(pageable, author, currentUser);
	}

	public void saveMessage(Message message) {
		messageRepo.save(message);
	}

	public Iterable<Message> findAllMessages() {
		return messageRepo.findAll();
	}
}
