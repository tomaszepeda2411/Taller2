package taller2;

public class Terremoto {
	private Participante consumidor;
	private float litros;
	private String fecha;
	
	public Terremoto(Participante consumidor, float litros, String fecha) {
		
		this.consumidor = consumidor;
		this.litros = litros;
		this.fecha = fecha;
	}

	public Participante getConsumidor() {
		return consumidor;
	}

	public float getLitros() {
		return litros;
	}

	public String getFecha() {
		return fecha;
	}
	
	
}
