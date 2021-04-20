package cl.uv.ici.arq.labs.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.labs.demo.config.CustomConfig;
import cl.uv.ici.arq.labs.demo.dtos.UserDTO;
import cl.uv.ici.arq.labs.demo.service.UserService;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	CustomConfig config;
	
	@Autowired
	UserService service;
	
	@GetMapping("/configuration")
	public ResponseEntity<CustomConfig> getProperties(){
		return new ResponseEntity<CustomConfig>(config,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody @Valid UserDTO userDTO) {
		return new ResponseEntity<>(service.createUser(userDTO), HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable String userId) {
		return new ResponseEntity<>(service.getUser(Integer.valueOf(userId)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<UserDTO> update(@RequestBody @Valid UserDTO userDTO) {
		return new ResponseEntity<>(service.updateUser(userDTO), HttpStatus.OK);
	}
	
	
	@GetMapping("/custom")
	public ResponseEntity<List<UserDTO>> findBylastName(@RequestParam String lastName) {
		return new ResponseEntity<>(service.findBylastName(lastName), HttpStatus.OK);
	}

}
