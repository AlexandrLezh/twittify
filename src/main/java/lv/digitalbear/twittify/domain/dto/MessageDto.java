package lv.digitalbear.twittify.domain.dto;

import lombok.Getter;
import lv.digitalbear.twittify.domain.Message;
import lv.digitalbear.twittify.domain.User;
import lv.digitalbear.twittify.domain.util.MessageHelper;

@Getter
public class MessageDto {
	private Long id;
	private String text;
	private String tag;
	private User author;
	private String filename;
	private Long likes;
	private Boolean meLiked;

	public MessageDto(Message message, Long likes, Boolean meLiked) {
		this.id = message.getId();
		this.text = message.getText();
		this.tag = message.getTag();
		this.author = message.getAuthor();
		this.filename = message.getFilename();
		this.likes = likes;
		this.meLiked = meLiked;
	}

	public String getAuthorName() {
		return MessageHelper.getAuthorName(author);
	}

	@Override
	public String toString() {
		return "MessageDto{" +
				"id=" + id +
				", author=" + author +
				", likes=" + likes +
				", meLiked=" + meLiked +
				'}';
	}
}
