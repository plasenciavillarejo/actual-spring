package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.bolsadeideas.springboot.app.models.entity.Cliente;

/* Patron de diseño : Facade

La clase Service está basado en el patron fachada, un único punto de acceso hacia distintos daos o repositorios.
Podemos trabajar con diferentes clases daos, ademas podemos evitar tener que acceder de forma directa a los datos 
dentro los controladores 
*/


public interface IClientService {
		
	/* Listar de forma continua */
	public List<Cliente> findall();
	
	/* Con estos 2 métodos se puede buscar un cliente, guardar y editarlo. */
	public Cliente findOne(Long id);	
	public void guardar(Cliente cliente);
	

	public void delete(Long id);

	public Page<Cliente> findall(Pageable pageable);
}
