package taller2;

public class Terremoto {
	private String consumidor;
	private float litros;
	private String fecha;
	
	public Terremoto(String consumidor, float litros, String fecha) {
		
		this.consumidor = consumidor;
		this.litros = litros;
		this.fecha = fecha;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public float getLitros() {
		return litros;
	}

	public String getFecha() {
		return fecha;
	}
	
	public float calcularKcal() {
		float calorias =  ((litros*10)/3);
		return calorias;
	}

	public void setConsumidor(String consumidor) {
		this.consumidor = consumidor;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
