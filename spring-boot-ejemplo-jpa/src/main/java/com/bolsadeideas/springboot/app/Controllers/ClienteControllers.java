package com.bolsadeideas.springboot.app.Controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.IClientService;
import com.bolsadeideas.springboot.app.util.paginator.PageRender;

/*
 * Usamos sesiones para guardar el id del cliente cuando se invoca el método
 * crear o editar (método get) Obtenemos el objeto cliente, lo guarda en le
 * sesión y lo pasa a la vista de está forma todos los datos pasados a la vista
 * quedan persistentes hasta que se envíe al método guardar que posteriormente
 * se tiene que eliminar la sesión.
 */

@Controller
@SessionAttributes("cliente")
public class ClienteControllers {

	@Autowired
	private IClientService clienteService;

	private final Logger log = (Logger) LoggerFactory.getLogger(this.getClass());

	/*
	 * Listar de forma continuada, sin usar page render // @RequestMapping(value="/listar", method = RequestMethod.GET)
	 
	@GetMapping(value = "/listar")
	public String Listar(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findall());
		log.info("Leyendo clase Listar.");
		return "listar";
	}*/


	/* Listar Cliente: Queremos obtener el Page la página actual, página '0', '1','2', etc ... */

	@RequestMapping(value = {"/listar", "/"}, method = RequestMethod.GET)
	public String Listar(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {

		/* Lo hacemos de la forma estática, Pageable pageRequest = new ... (Está Deprecated) size= Cantidad registros que queremos mostrar por cada página.
		 (Indico 4 Registro por página) */
		Pageable pageRequest = PageRequest.of(page, 5);

		/* Llamamos al método Page de la clase ClientesServiceImple.java y le pasamos el  valor recogido pageRequest De modo que obtendemos la lísta paginada de
		   cliente con este método. */
		Page<Cliente> clientes = clienteService.findall(pageRequest);

		/* Creamos el PageRender Sirve para desplazarnos entre páginas. */
		PageRender<Cliente> pageRender = new PageRender<>("/listar", clientes);

		model.addAttribute("titulo", "Listado de clientes");
		/* Pasamos como párametro los cliente obtenidos por cada página. */
		model.addAttribute("clientes", clientes);
		/* Pasamoa a la vista nuestro PageRender */
		model.addAttribute("page", pageRender);
		return "listar";
	}
	/* ----------------------------------------------------------------------- */

	/* 1.- Creas el cliente. */
	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		/* Metemos un nuevo cliente. */
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		return "form";
	}

	/* 2.- Se crea un Cliente y se guarda.. */
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	private String guardar(@Valid Cliente cliente, Model model, SessionStatus status, BindingResult result) {
		/* Validacion */

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Cliente");
			return "form";
		}

		clienteService.guardar(cliente);
		status.setComplete();
		return "redirect:listar";
	}

	/* 3.- Se edita un cliente y se guarda. */
	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	private String guardareditar(@Valid Cliente cliente, Model model, SessionStatus status, BindingResult result) {
		/* Validacion */

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario Cliente");
			return "editar";
		}

		clienteService.guardar(cliente);
		status.setComplete();
		return "redirect:listar";
	}
		
	/* 3.- Editar un cliente accediendo a la vista creada editar.html */

	@RequestMapping(value = "/editar/{id}")
	private String edit(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = null;

		if (id > 0) {
			cliente = clienteService.findOne(id);
			if (cliente == null) {
				flash.addFlashAttribute("Error", "El cliente no existe en la BD");
			}
		} else {
			flash.addFlashAttribute("Error", "El ID del cliente no puede ser 0.");
			return "redirect:/listar";
		}

		/* Pasamos los datos a la vista. */
		model.put("cliente", cliente);
		model.put("titulo", "Editar Cliente");

		return "editar";
	}
	
	
	@RequestMapping(value = "/eliminar/{id}")
	public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {

		if (id > 0) {
			clienteService.delete(id);
			flash.addFlashAttribute("success", "Cliente borrado con éxito.!");
			log.info("Leyendo clase Borrar.");
		}
		return "redirect:/listar";
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
	/* Seteo de datos de un cliente */
	
//	@GetMapping("/listar")
//	public String pr(@RequestParam(name = "nombre", required = false) String repo, Model model) {
//		Cliente cliente = new Cliente();
//		
//		cliente.setId(35);
//		cliente.setNombre("Prueba");
//		cliente.setApellido("pepito");
//		
//		
//		model.addAttribute("name", repo);
//		
//		return "listar";
//	}
	
	
}
