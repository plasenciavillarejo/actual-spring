package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClientService {

	@Autowired
	private IClienteDao clienteDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findall() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	
	@Override
	public void guardar(Cliente cliente) {
		clienteDao.save(cliente);		
	}


	@Override
	@Transactional(readOnly = true)
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}


	@Override
	public Page<Cliente> findall(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	
	
	
	
	
	
	
	
}
