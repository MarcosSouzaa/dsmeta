package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SalesRepository;

@Service
public class SaleService {
	
	@Autowired
	private SalesRepository repository; //para acessar o banco de dados
	
	public List<Sale> findSales() { //retorna uma lista de vendas
		return repository.findAll(); //return = o resultado da minha função é o resultado que o repository vai buscar
	}

}
