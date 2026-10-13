package taller2;

public class Participante {
	private String nombre;
	private int cantChoripanes = 0;
	private int cantTerremotos = 0;
	
	public Participante(String nombre) {
		
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public int getCantChoripanes() {
		return cantChoripanes;
	}

	public int getCantTerremotos() {
		return cantTerremotos;
	}
	
	
}
