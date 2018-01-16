package it.ciro.pack.service;

import java.util.List;

import it.ciro.pack.model.Room;

public interface RoomService {

	public Room saveOrUpdate(Room room);

	public void delete(Room room);

	public List<Room> getAll();

	public List<Room> getByDim(int dim);

	public Room getByCodice(String codice);

}
