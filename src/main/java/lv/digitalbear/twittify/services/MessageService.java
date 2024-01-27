package lv.digitalbear.twittify.services;

import lv.digitalbear.twittify.domen.Message;
import lv.digitalbear.twittify.domen.User;
import lv.digitalbear.twittify.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	private MessageRepo messageRepo;

	public Page<Message> messagesList(Pageable pageable, String filter) {

		if (filter != null && !filter.isEmpty()) {
			return messageRepo.findByTag(filter, pageable);
		} else {
			return messageRepo.findAll(pageable);
		}
	}

	public Page<Message> messagesListForUser(Pageable pageable, User currentUser, User author) {
		return messageRepo.findByUser(pageable, author);
	}

	public void saveMessage(Message message) {
		messageRepo.save(message);
	}

	public Iterable<Message> findAllMessages() {
		return messageRepo.findAll();
	}
}
