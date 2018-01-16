package it.ciro.pack.service;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.ciro.pack.dao.RoomDao;
import it.ciro.pack.model.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDao roomDao;

	@Override
	public Room saveOrUpdate(Room room) {
		return roomDao.save(room);
	}

	@Override
	public void delete(Room room) {
		List<Room> listRoom = getAll();
		boolean check = false;

		for (Room room2 : listRoom) {
			if (room2.equals(room)) {
				roomDao.delete(room2);
				check = true;
			}
		}

		if (!check)
			System.out.println("Non è stata trovata nessuna stanza, impossibile eliminare.");
		else
			System.out.println("Stanza eliminata.");
	}

	@Override
	public List<Room> getAll() {
		return (List<Room>) roomDao.findAll();
	}

	@Override
	public List<Room> getByDim(int dim) {
		List<Room> tempList = getAll();

		// Uso dei predicati di Java8. Predicate<Class> dichiara una condizione per cui
		// attivarsi. List.removeIf(Predicate<Class>) rimuove un elemento dalla lista
		// secondo il predicato passato
		Predicate<Room> dimPredicate = room -> room.getDimensione() < dim;
		tempList.removeIf(dimPredicate);

		return tempList;
	}

	@Override
	public Room getByCodice(String codice) {
		return roomDao.findByCodice(codice);
	}
}
