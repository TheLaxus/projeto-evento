package irfn.pi.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import irfn.pi.eventos.models.Evento;
import irfn.pi.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired // quem cuida de criar e vincular o objeto
	private EventoRepository er;

	@GetMapping("/form") // metodo get
	public ModelAndView viewCadastrarEvento() {
		ModelAndView mv = new ModelAndView("eventos/formEvento");
		mv.addObject("evento", new Evento());
		return mv;
	}

	@PostMapping // metodo post
	public String adicionar(@ModelAttribute Evento evento) {

		// receber dados do formulario
		System.out.println(evento);
		er.save(evento);

		return "eventos/evento-adicionar";
	}

	@GetMapping
	public ModelAndView listar() {

		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {

		Optional<Evento> opt = er.findById(id);
		ModelAndView mv = new ModelAndView();

		// se o id for vazio
		if (opt.isEmpty()) {
			mv.setViewName("redirect:/eventos");
			return mv;
		}

		mv.setViewName("eventos/detalhes");
		Evento evento = opt.get();

		mv.addObject("detalhe", evento);

		return mv;
	}
}
