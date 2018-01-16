package it.ciro.pack.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.ciro.pack.model.Prenotazione;
import it.ciro.pack.model.Room;
import it.ciro.pack.model.User;
import it.ciro.pack.service.PrenotazioneService;
import it.ciro.pack.service.RoomService;
import it.ciro.pack.service.UserService;

@RestController
@RequestMapping("/pren")
public class PrenotazioneController {

	@Autowired
	private PrenotazioneService prenService;

	@Autowired
	private UserService userService;

	@Autowired
	private RoomService roomService;

	@GetMapping("/")
	public Prenotazione getModel() {
		return new Prenotazione();
	}

	@PostMapping("/save")
	public Prenotazione saveOrUpdatePrenotazione(@RequestHeader String inizio, @RequestHeader String fine,
			@RequestHeader String nome, @RequestHeader String cognome, @RequestHeader String codice_room,
			@RequestHeader String codice_pren) throws ParseException {

		User user = userService.getByNomeCognome(nome, cognome);
		Room room = roomService.getByCodice(codice_room);
		Prenotazione pren = new Prenotazione();

		// Formattazione da stringa a sql.Date
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date parsedInizio = format.parse(inizio);
		java.util.Date parsedFine = format.parse(fine);
		Date inizioData = new Date(parsedInizio.getTime());
		Date fineData = new Date(parsedFine.getTime());

		pren.setInizio(inizioData);
		pren.setFine(fineData);
		pren.setCod(codice_pren);
		pren.setUser(user);
		pren.setRoom(room);

		return prenService.saveOrUpdate(pren);
	}

	@DeleteMapping("/delete")
	public void deletePrenotazione(@RequestHeader String codice) {
		Prenotazione temp = new Prenotazione();
		temp.setCod(codice);

		prenService.delete(temp);
	}

	@GetMapping("/user/nome={name}/cognome={surname}")
	public Prenotazione getPrenotazioneByUser(@PathVariable("name") String nome,
			@PathVariable("surname") String cognome) {
		User user = new User();
		user.setNome(nome);
		user.setCognome(cognome);

		return prenService.getByUser(user);
	}

	@GetMapping("/room/codice={codice}")
	public Prenotazione getPrenotazioneByRoom(@PathVariable("codice") String codice) {
		Room room = new Room();
		room.setCodice(codice);

		return prenService.getByRoom(room);
	}

	@GetMapping("/getAll")
	public List<Prenotazione> getAllPrenotazioni() {
		return prenService.getAll();
	}

}
