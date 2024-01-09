package lv.digitalbear.twittify.services;

import lv.digitalbear.twittify.domen.Role;
import lv.digitalbear.twittify.domen.User;
import lv.digitalbear.twittify.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return user;
	}

	public boolean addUser(User user) {
		User userFromDb = userRepo.findByUsername(user.getUsername());

		if (userFromDb != null) {
			return false;
		}

		user.setActive(true);
		user.setRoles(Collections.singleton(Role.USER));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.save(user);

		//sendMessage(user);

		return true;
	}
	public User getUserById(Long userId) {
		Optional<User> optionalUser = userRepo.findById(userId);

		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			throw new UsernameNotFoundException("User not found with ID: " + userId);
		}
	}


}
