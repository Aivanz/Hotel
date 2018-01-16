package it.ciro.pack.service;

import java.util.List;

import it.ciro.pack.model.Prenotazione;
import it.ciro.pack.model.Room;
import it.ciro.pack.model.User;

public interface PrenotazioneService {

	public Prenotazione saveOrUpdate(Prenotazione prenotazione);

	public void delete(Prenotazione prenotazione);

	public Prenotazione getByUser(User user);

	public Prenotazione getByRoom(Room room);

	public List<Prenotazione> getAll();

}
