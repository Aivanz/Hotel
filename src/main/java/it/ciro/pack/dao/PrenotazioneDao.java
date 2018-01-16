package it.ciro.pack.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.ciro.pack.model.Prenotazione;
import it.ciro.pack.model.Room;
import it.ciro.pack.model.User;

@Repository
public interface PrenotazioneDao extends CrudRepository<Prenotazione, Integer> {

	public Prenotazione findByUser(User user);

	public Prenotazione findByRoom(Room room);

}
