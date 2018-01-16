package it.ciro.pack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ciro.pack.model.User;
import it.ciro.pack.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public User getModel() {
		return new User();
	}

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveOrUpdate(user);
	}

	@DeleteMapping("/delete")
	public void deleteUser(@RequestHeader String nome, @RequestHeader String cognome) {
		User temp = new User();
		temp.setNome(nome);
		temp.setCognome(cognome);

		userService.delete(temp);
	}

	@GetMapping("/nome={name}")
	public List<User> getUsersByNome(@PathVariable("name") String nome) {
		return userService.getByNome(nome);
	}

	@GetMapping("/cognome={surname}")
	public List<User> getUsersByCognome(@PathVariable("surname") String cognome) {
		return userService.getByCognome(cognome);
	}

	@GetMapping("/nome={name}/cognome={surname}")
	public User getUserByNomeCognome(@PathVariable("name") String nome, @PathVariable("surname") String cognome) {
		return userService.getByNomeCognome(nome, cognome);
	}

	@GetMapping("/id={id}")
	public User getUserById(@PathVariable("id") int id) {
		return userService.getById(id);
	}

	@GetMapping("/getAll")
	public List<User> getAllUsers() {
		return userService.getAll();
	}

}
