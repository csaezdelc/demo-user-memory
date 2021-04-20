package cl.uv.ici.arq.labs.demo.service;

import java.util.List;

import cl.uv.ici.arq.labs.demo.dtos.UserDTO;

public interface UserService {

	public UserDTO createUser(UserDTO user);
	public boolean removeUser(Integer idUser);
	public List<UserDTO> getUsers();
	public UserDTO updateUser(UserDTO user);
	public UserDTO getUser(Integer idUser);
	public List<UserDTO> findBylastName(String lastName);

}
