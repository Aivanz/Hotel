package it.ciro.pack.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.ciro.pack.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	public List<User> findByNome(String nome);

	public List<User> findByCognome(String cognome);

	public User findById(int id);
}
