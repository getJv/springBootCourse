package br.com.listavip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.listavip.model.Guest;
import br.com.listavip.service.GuestService;

@Controller
public class GuestController {

	@Autowired	
	private GuestService gs;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("guestList")
	public String guestList(Model model) {

		Iterable<Guest> guests = gs.getAll();

		model.addAttribute("guests", guests);

		return "guestList";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Guest guest = new Guest(nome, email, telefone);
		

		gs.save(guest);

		Iterable<Guest> guests = gs.getAll();

		model.addAttribute("guests", guests);

		return "guestList";
	}

}
