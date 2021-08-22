package irfn.pi.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import irfn.pi.eventos.models.Evento;
import irfn.pi.eventos.repositories.EventoRepository;

@Controller
public class EventosController {
	
	@Autowired //quem cuida de criar e vincular o objeto
	private EventoRepository er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "formEvento";
	}
	
	@PostMapping("/eventos") //metodo post
	public String adicionar(Evento evento) {
		
		//receber dados do formulario
		System.out.println(evento);
		er.save(evento);
		
		return "evento-adicionar";
	}
}
