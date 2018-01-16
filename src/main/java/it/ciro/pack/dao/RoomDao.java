package it.ciro.pack.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.ciro.pack.model.Room;

@Repository
public interface RoomDao extends CrudRepository<Room, Integer> {
	public Room findByCodice(String codice);
}
