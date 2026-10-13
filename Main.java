package taller2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static Participante[] participantes = new Participante[200];
	
	static Scanner scan;
	public static void main(String[] args) throws FileNotFoundException {
		leerParticipantes();
		leerConsumidos();
			
	}
	private static void leerConsumidos() throws FileNotFoundException {
		File txtConsumidos = new File("Consumidos.txt");
		scan = new Scanner(txtConsumidos);
		
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String tipo = partes[0];
			String consumidor = partes[1];
			if (tipo.equalsIgnoreCase("choripan")) {
				int largo = Integer.parseInt(partes[2]);
				int ancho = Integer.parseInt(partes[3]);
				String fecha = partes[4];
				
			}else if(tipo.equalsIgnoreCase("terremoto")) {
				float litros = Float.parseFloat(partes[2]);
				String fecha = partes[3];
			}
			
		}
	}
	private static void leerParticipantes() throws FileNotFoundException {
		int n = 0;
		File txtParticipantes = new File("Participantes.txt");
		scan = new Scanner(txtParticipantes);
		while (scan.hasNextLine()) {
			String linea  = scan.nextLine();
			Participante p = new Participante(linea);
			participantes[n] = p;
			n++;
		}
	}

}




