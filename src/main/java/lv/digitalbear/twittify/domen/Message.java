package lv.digitalbear.twittify.domen;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text;
	private String tag;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User author;

	public Message(String text, String tag, User author) {
		this.tag = tag;
		this.text = text;
		this.author = author;
	}
	public String getAuthorName() {
		return author != null ? author.getUsername() : "<none>";
	}
}
