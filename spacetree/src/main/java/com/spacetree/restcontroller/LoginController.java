package com.spacetree.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spacetree.entity.UserDepEntity;
import com.spacetree.entity.UsersEntity;
import com.spacetree.repository.UserDepRepository;
import com.spacetree.repository.UserReposistory;

@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	UserReposistory userReposistory;

	@Autowired
	UserDepRepository userDepRepository;

	@PostMapping("/add")
	public ResponseEntity<UsersEntity> enroll(@RequestBody UsersEntity usersEntity) {
		try {

			UsersEntity usersEntityObj = userReposistory
					.save(new UsersEntity(usersEntity.getId(), usersEntity.getName(), usersEntity.getDob(),
							usersEntity.isActiveStatus(), usersEntity.getPhone(), usersEntity.getUserDepList()));
			return new ResponseEntity<>(usersEntityObj, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add-dependent")
	public ResponseEntity<UserDepEntity> addDependent(@RequestBody UserDepEntity userDepEntity) {
		try {

			UserDepEntity userDepEntityObj = userDepRepository.save(new UserDepEntity(userDepEntity.getId(),
					userDepEntity.getName(), userDepEntity.getDob(), userDepEntity.getDepId()));
			return new ResponseEntity<>(userDepEntityObj, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/enrolleelist")
	public ResponseEntity<List<UsersEntity>> getAllUsersEntitys() {
		try {
			List<UsersEntity> UsersEntitys = new ArrayList<UsersEntity>();

			userReposistory.findAll().forEach(UsersEntitys::add);

			if (UsersEntitys.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(UsersEntitys, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete-enrollee/{id}")
	public ResponseEntity<HttpStatus> deleteUsersEntity(@PathVariable("id") long id) {
		try {
			userReposistory.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete-dependent/{id}")
	public ResponseEntity<HttpStatus> deleteDependent(@PathVariable("id") long id) {
		try {
			userDepRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete-enrollers")
	public ResponseEntity<HttpStatus> deleteUsers() {
		try {
			
			userDepRepository.deleteAll();
			userReposistory.deleteAll();

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/dependents")
	public ResponseEntity<List<UserDepEntity>> getDependentDetailsById() {
		try {
			List<UserDepEntity> UsersEntitys = new ArrayList<UserDepEntity>();

			userDepRepository.findAll().forEach(UsersEntitys::add);

			if (UsersEntitys.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(UsersEntitys, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// user
	@GetMapping("edit-enrolle/{id}")
	public ResponseEntity<UsersEntity> getUserById(@PathVariable("id") long id) {
		Optional<UsersEntity> UsersEntityData = userReposistory.findById(id);

		if (UsersEntityData.isPresent()) {
			return new ResponseEntity<>(UsersEntityData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// dependent

	@GetMapping("/dependent-edit/{id}")
	public ResponseEntity<UserDepEntity> getDepdentById(@PathVariable("id") long id) {
		Optional<UserDepEntity> UsersEntityData = userDepRepository.findById(id);

		if (UsersEntityData.isPresent()) {
			return new ResponseEntity<>(UsersEntityData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update-enrolle/{id}")
	public ResponseEntity<UsersEntity> updateUsersEntity(@PathVariable("id") long id,
			@RequestBody UsersEntity UsersEntity) {
		Optional<UsersEntity> UsersEntityData = userReposistory.findById(id);

		if (UsersEntityData.isPresent()) {
			UsersEntity _UsersEntity = UsersEntityData.get();
			_UsersEntity.setName(UsersEntity.getName());
			_UsersEntity.setActiveStatus(UsersEntity.isActiveStatus());
			_UsersEntity.setPhone(UsersEntity.getPhone());
			_UsersEntity.setDob(UsersEntity.getDob());
			return new ResponseEntity<>(userReposistory.save(_UsersEntity), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/update-dependent/{id}")
	public ResponseEntity<UserDepEntity> dependentUpdate(@PathVariable("id") long id,
			@RequestBody UserDepEntity userDepEntity) {
		Optional<UserDepEntity> UsersEntityData = userDepRepository.findById(id);

		if (UsersEntityData.isPresent()) {
			UserDepEntity _UsersEntity = UsersEntityData.get();
			_UsersEntity.setName(userDepEntity.getName());
			_UsersEntity.setDob(userDepEntity.getDob());
			return new ResponseEntity<>(userDepRepository.save(_UsersEntity), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping("/")
	public String home() {

		return "Hello World";
	}
}
