package cl.uv.ici.arq.labs.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.uv.ici.arq.labs.demo.dtos.UserDTO;
import cl.uv.ici.arq.labs.demo.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	private List<UserDTO> userList = new ArrayList<UserDTO>();
	private int count = 0;
	
	@Override
	public UserDTO createUser(UserDTO user) {
		user.setUserId(++count);
		userList.add(user);
		return user;
	}

	@Override
	public boolean removeUser(Integer idUser) {
		boolean delete=false;
		
		UserDTO userDelete=this.userList.stream().filter(user -> idUser.equals(user.getUserId())).findAny().orElse(null);
		
		if(userDelete!=null) {
			this.userList.remove(userDelete);
			delete=true;
		}		
		
		return delete;
	}

	@Override
	public UserDTO updateUser(UserDTO user) {
		int index;
		for (index = 0; index < this.userList.size(); index++) {
			if (user.getUserId() == this.userList.get(index).getUserId()) {
				this.userList.get(index).setFirstName(user.getFirstName());
				this.userList.get(index).setLastName(user.getLastName());
				break;
			}
		}
		return this.userList.get(index);
	}

	@Override
	public UserDTO getUser(Integer idUser) {
		return this.userList.stream().filter(user -> idUser.equals(user.getUserId())).findAny().orElse(null);
	}

	@Override
	public List<UserDTO> getUsers() {
		return userList;
	}

	@Override
	public List<UserDTO> findBylastName(String lastName) {
		return this.userList.stream().filter(user -> lastName.equals(user.getLastName())).collect(Collectors.toList());
	}

}
