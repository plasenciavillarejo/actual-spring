package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bolsadeideas.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
// "select u from #{#entityName} u where u.username = ?1"
	@Query( value = "select id, username, enabled, password from users where username = ?1",
			nativeQuery = true)
	public Usuario findByUsername(String username);
}


