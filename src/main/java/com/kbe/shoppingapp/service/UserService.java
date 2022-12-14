
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.exception.EmailAlreadyExistsException;
import com.kbe.shoppingapp.model.User;
import com.kbe.shoppingapp.repository.UserRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		this.userRepository.deleteAll();
	}

	@Override
	public User signUp(User user) throws EmailAlreadyExistsException {
		String email = user.getEmail();
		User exists = null;
		try {
			exists = this.userRepository.findById(email).get();
		} catch (Exception e) { }
		if (exists != null) {
			throw new EmailAlreadyExistsException();
		}
		return this.userRepository.save(user);
	}

	@Override
	public User signIn(String email, String password) throws Exception {
		User user = this.userRepository.findById(email).get();
		if (user == null) {
			throw new Exception("Email not found!");
		}
		if (user.getPassword().equals(password)) {
			return user;
		}
		throw new Exception("Login error! Wrong email or password");
		//return null;
	}

	@Override
	public List<User> readAll() {
		return this.userRepository.findAll();
		//return null;
	}

	@Override
	public User readByEmail(String email) {
		// return this.userRepository.findByEmail(email);
		return null;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


}