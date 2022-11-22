package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SalesRepository;

@Service
public class SaleService {
	
	@Autowired
	private SalesRepository repository; //para acessar o banco de dados
	
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) { //retorna uma lista de vendas no primeiro momento e depois mudo pra Page
		
		//cria uma data para o dia de hoje
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//vamos converter a data que está sendo passada com texto pelo argumento para localDate
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate); //data mínima um ano atrás
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		// ? se a data max for igual vazio vou colocar today no lugar : se não for verdade, converto para localDate
		
		return repository.findSales(min, max, pageable); //return = o resultado da minha função é o resultado que o repository vai buscar
		
		
		
	
	}

}
