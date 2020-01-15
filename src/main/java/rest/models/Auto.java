package rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Auto {
	@JsonProperty("Marca")	
	private String marca;
	
	@JsonProperty("Color")
	private String color;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
}
}