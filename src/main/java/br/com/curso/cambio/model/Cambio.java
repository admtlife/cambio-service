package br.com.curso.cambio.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cambio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2129369021285582580L;
	private Long id;
	private String from;
	private String to;
	private BigDecimal convertionFactor;
	private BigDecimal convertedValue;
	private String environment;
	
	public Cambio() {
		// TODO Auto-generated constructor stub
	}
	
	public Cambio(Long id, String from, String to, BigDecimal convertionFactor, BigDecimal convertedValue,
			String enviroment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionFactor = convertionFactor;
		this.convertedValue = convertedValue;
		this.environment = enviroment;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConvertionFactor() {
		return convertionFactor;
	}
	public void setConvertionFactor(BigDecimal convertionFactor) {
		this.convertionFactor = convertionFactor;
	}
	public BigDecimal getConvertedValue() {
		return convertedValue;
	}
	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String enviroment) {
		this.environment = enviroment;
	}
	

}
