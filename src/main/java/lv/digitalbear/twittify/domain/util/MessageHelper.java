package lv.digitalbear.twittify.domain.util;

import lv.digitalbear.twittify.domain.User;

public abstract class MessageHelper {
	public static String getAuthorName(User author) {
		return author != null ? author.getUsername() : "<none>";
	}
}
