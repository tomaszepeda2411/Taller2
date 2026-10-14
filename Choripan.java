package taller2;

public class Choripan {
	private String consumidor;
	private int largo;
	private int ancho;
	private String fecha;
	private int calorias = 0;
	public Choripan(String consumidor, int largo, int ancho, String fecha) {
		
		this.consumidor = consumidor;
		this.largo = largo;
		this.ancho = ancho;
		this.fecha = fecha;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public int getLargo() {
		return largo;
	}

	public int getAncho() {
		return ancho;
	}

	public String getFecha() {
		return fecha;
	}
	
	public float calcularKcal() {
		calorias = (largo*ancho)/3;
		return calorias;
	}
}
