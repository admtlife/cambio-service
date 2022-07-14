package br.com.curso.cambio.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.cambio.model.Cambio;
import br.com.curso.cambio.repository.CambioRepository;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CambioRepository repository;
	
	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio recuperarCambio(@PathVariable("amount") BigDecimal amount,
			@PathVariable("from") String from,
			@PathVariable("to") String to) {
		
		var cambio = repository.findByFromAndTo(from, to);

		if (cambio == null) {
			throw new RuntimeException("Currency Unsupported");
		}
		
		var port = environment.getProperty("local.server.port");
		
		BigDecimal conversor = cambio.getConversionFactor();
		BigDecimal valorConvertido = conversor.multiply(amount);
		
		cambio.setConvertedValue(valorConvertido.setScale(2, RoundingMode.CEILING));
		cambio.setEnvironment(port); 
		
		return cambio;
	}

}
