package com.bolsadeideas.springboot.app.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

public interface IClienteDao extends  PagingAndSortingRepository<Cliente, Long> {


}
