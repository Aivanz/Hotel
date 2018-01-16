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

import it.ciro.pack.model.Room;
import it.ciro.pack.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@GetMapping("/")
	public Room getModel() {
		return new Room();
	}

	@PostMapping("/save")
	public Room saveOrUpdateRoom(@RequestBody Room room) {
		return roomService.saveOrUpdate(room);
	}

	@DeleteMapping("/delete")
	public void deleteRoom(@RequestHeader String codice) {
		Room temp = new Room();
		temp.setCodice(codice);

		roomService.delete(temp);
	}

	@GetMapping("/codice={cod}")
	public Room getRoomByCodice(@PathVariable("cod") String codice) {
		return roomService.getByCodice(codice);
	}

	@GetMapping("/dim={dim}")
	public List<Room> getRoomsByDim(@PathVariable("dim") int dim) {
		return roomService.getByDim(dim);
	}

	@GetMapping("/getAll")
	public List<Room> getAllRooms() {
		return roomService.getAll();
	}

}
