package it.ciro.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ciro.pack.dao.UserDao;
import it.ciro.pack.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User saveOrUpdate(User user) {
		return userDao.save(user);
	}

	@Override
	public void delete(User user) {
		List<User> listaUsers = getAll();
		boolean check = false;

		for (User user2 : listaUsers) {
			if (user.equals(user2)) {
				userDao.delete(user2);
				check = true;
			}
		}

		if (!check)
			System.out.println("Nessun utente trovato, impossibile eliminare utente.");
		else
			System.out.println("Utente eliminato.");
	}

	@Override
	public List<User> getByNome(String nome) {
		return userDao.findByNome(nome);
	}

	@Override
	public List<User> getByCognome(String cognome) {
		return userDao.findByCognome(cognome);
	}

	@Override
	public User getByNomeCognome(String nome, String cognome) {
		List<User> tempList = userDao.findByCognome(cognome);

		for (User user2 : tempList) {
			if (user2.getNome().equalsIgnoreCase(nome))
				return user2;
		}

		System.out.println("Non è stato travato alcun utente.");
		return null;
	}

	@Override
	public User getById(int id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userDao.findAll();
	}

}
