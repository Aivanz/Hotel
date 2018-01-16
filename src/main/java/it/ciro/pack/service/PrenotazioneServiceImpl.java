package it.ciro.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ciro.pack.dao.PrenotazioneDao;
import it.ciro.pack.model.Prenotazione;
import it.ciro.pack.model.Room;
import it.ciro.pack.model.User;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	private PrenotazioneDao prenDao;

	@Override
	public Prenotazione saveOrUpdate(Prenotazione prenotazione) {
		return prenDao.save(prenotazione);
	}

	@Override
	public void delete(Prenotazione prenotazione) {
		List<Prenotazione> tempList = getAll();
		boolean check = false;

		for (Prenotazione prenotazione2 : tempList) {
			if (prenotazione2.equals(prenotazione)) {
				prenDao.delete(prenotazione2);
				check = true;
			}
		}

		if (!check)
			System.out.println("Non è stata trovata nessuna prenotazione. Impossibile eliminare.");
		else
			System.out.println("Prenotazione eliminata");

	}

	@Override
	public Prenotazione getByUser(User user) {
		return prenDao.findByUser(user);
	}

	@Override
	public Prenotazione getByRoom(Room room) {
		return prenDao.findByRoom(room);
	}

	@Override
	public List<Prenotazione> getAll() {
		return (List<Prenotazione>) prenDao.findAll();
	}

}
