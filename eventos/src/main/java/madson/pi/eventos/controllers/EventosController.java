package madson.pi.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import madson.pi.eventos.models.Evento;
import madson.pi.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosController {
	@Autowired
	private EventoRepository er;
	
	@GetMapping("/form")
	public String form() {
		return "eventos/FormEvento";
	}

	@RequestMapping(path = "/eventos", method = RequestMethod.POST)
	public String adicionar(Evento evento) {
		System.out.println(evento);
		er.save(evento);
		return "eventos/evento-adicionado";
	}
	
	@GetMapping 
	public ModelAndView listar(){
		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
	}

}
