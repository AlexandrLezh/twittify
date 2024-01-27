package lv.digitalbear.twittify.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lv.digitalbear.twittify.domain.util.MessageHelper;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Fill message please.")
	@Size(max = 2000, message = "Message cannot be more than 2000 characters.")
	private String text;
	@Size(max = 20, message = "Tag should be less than 20 characters")
	private String tag;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User author;

	private String filename;

	@ManyToMany
	@JoinTable(
			name = "message_likes",
			joinColumns = { @JoinColumn(name = "message_id") },
			inverseJoinColumns = { @JoinColumn(name = "user_id")}
	)
	private Set<User> likes = new HashSet<>();

	public Message(String text, String tag, User author) {
		this.tag = tag;
		this.text = text;
		this.author = author;
	}
	public String getAuthorName() {
		return MessageHelper.getAuthorName(author);
	}
}
