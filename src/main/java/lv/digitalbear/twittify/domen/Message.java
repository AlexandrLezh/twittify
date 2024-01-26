package lv.digitalbear.twittify.domen;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	@NotBlank(message = "Fill message please.")
	@Size(max = 2000, message = "Message cannot be more than 2000 characters.")
	private String text;
	@Size(max = 20, message = "Tag should be less than 20 characters")
	private String tag;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User author;

	private String filename;

	public Message(String text, String tag, User author) {
		this.tag = tag;
		this.text = text;
		this.author = author;
	}
	public String getAuthorName() {
		return author != null ? author.getUsername() : "<none>";
	}
}
