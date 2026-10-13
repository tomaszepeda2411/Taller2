package taller2;

public class Choripan {
	private Participante consumidor;
	private int largo;
	private int ancho;
	private String fecha;
	
	public Choripan(Participante consumidor, int largo, int ancho, String fecha) {
		
		this.consumidor = consumidor;
		this.largo = largo;
		this.ancho = ancho;
		this.fecha = fecha;
	}

	public Participante getConsumidor() {
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
	
	
}
