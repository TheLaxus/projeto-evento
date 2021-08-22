package irfn.pi.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import irfn.pi.eventos.models.Evento;
import irfn.pi.eventos.repositories.EventoRepository;

@Controller
public class EventosController {

	@Autowired // quem cuida de criar e vincular o objeto
	private EventoRepository er;

	@GetMapping("/eventos/form") // metodo get
	public ModelAndView viewCadastrarEvento() {
		ModelAndView mv = new ModelAndView("eventos/formEvento");
		mv.addObject("evento", new Evento());
		return mv;
	}


	@PostMapping("/eventos") // metodo post
	public String adicionar(@ModelAttribute Evento evento) {

		// receber dados do formulario
		System.out.println(evento);
		er.save(evento);

		return "eventos/evento-adicionar";
	}
}
