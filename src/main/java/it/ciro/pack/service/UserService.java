package it.ciro.pack.service;

import java.util.List;

import it.ciro.pack.model.User;

public interface UserService {

	public User saveOrUpdate(User user);

	public void delete(User user);

	public List<User> getByNome(String nome);

	public List<User> getByCognome(String cognome);

	public User getByNomeCognome(String nome, String cognome);

	public User getById(int id);

	public List<User> getAll();

}
