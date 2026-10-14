package taller2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static int registros = 0;
	static Participante[] participantes = new Participante[200];
	static Choripan[] choripanes = new Choripan[200];
	static Terremoto[] terremotos = new Terremoto[200];
	
	static Scanner scan;
	public static void main(String[] args) throws FileNotFoundException {
		leerParticipantes();
		leerConsumidos();
		menu();
			
	}
	private static void menu() {
		int opcion = 0;
		scan = new Scanner(System.in);
		System.out.println("================================");
		System.out.println("LA FONDA DEL PAPU");
		System.out.println("================================");
		System.out.println("Registros cargados:" + registros);
		System.out.println("----------------------------");
		do {
			System.out.println("[1] Ver registros");
			System.out.println("[2] Actualizar registros");
			System.out.println("============================");
			System.out.print("Seleccione una opcion:");
			opcion = scan.nextInt();
			switch(opcion) {
			case 1:
				int opcion2 = 0;
				System.out.println("========VER REGISTROS=======");
				System.out.println("[1] Choripanes");
				System.out.println("[2] Terremotos");
				System.out.println("[3] Volver al menu");
				System.out.println("==========================");
				System.out.println("Seleccione una opcion: ");
				opcion2 = scan.nextInt();
				scan.nextLine();
				switch(opcion2) {
				case 1:
					int contador = 0;
					System.out.println("======== CHORIPANES =======");
					System.out.printf("%-5s%-15s%-10s%-10s%-15s%-10s%n",
							"N°", "Consumidor", "Largo", "Ancho", "Fecha", "Kcal");

					for (int i = 0; i<choripanes.length;i++) {
						if((choripanes[i]!=null)) {
							System.out.printf("%-5d%-15s%-10d%-10d%-15s%-10.2f%n",
									contador++,
									choripanes[i].getConsumidor(),
									choripanes[i].getLargo(),
									choripanes[i].getAncho(),
									choripanes[i].getFecha(),
									choripanes[i].calcularKcal());

							}
					
					}System.out.println("Total: " + contador+" choripanes registrados");
					System.out.println("===============================");
					System.out.println("Presione ENTER para continuar:");
					scan.nextLine();
				case 2:
					int contador2 = 0;
					float sumador = 0;
					System.out.println("============= TERREMOTOS ==============");
					System.out.printf("%-5s%-15s%-10s%-15s%-10s%n",
							"N°", "Consumidor", "Litros","Fecha", "Kcal");
					
					for (int i=0;i<terremotos.length;i++) {
						if(terremotos[i]!=null) {
							sumador += terremotos[i].getLitros();
							System.out.printf("%-5d%-15s%-10.2f%-15s%-10.2f%n",
									contador2++,
									terremotos[i].getConsumidor(),
									terremotos[i].getLitros(),
									terremotos[i].getFecha(),
									terremotos[i].calcularKcal());

							}
						
						}System.out.println("-------------------------------------------");
						System.out.println("Total: " + contador2 + " terremotos registrados ("+sumador+" L)");
						System.out.println("========================================");
					
				case 3:
					break;
				}
			case 2:
				System.out.println("============== ACTUALIZAR REGISTROS ===============");
				System.out.println("[1] Agregar");
				System.out.println("[2] Editar");
				System.out.println("[3] Eliminar");
				System.out.println("[4] Volver al menu principal");
				System.out.println("==================================");
				System.out.println("Seleccione una opcion: ");
				scan.nextInt();
				break;
			}
		}while(opcion!=4);
		
	}
	private static void leerConsumidos() throws FileNotFoundException {
		File txtConsumidos = new File("Consumido.txt");
		scan = new Scanner(txtConsumidos);
		int cho = 0;
		int terr = 0;
		while(scan.hasNextLine()) {
			String linea = scan.nextLine();
			String[] partes = linea.split(";");
			String tipo = partes[0];
			String consumidor = partes[1];
			if (tipo.equalsIgnoreCase("choripan")) {
				int largo = Integer.parseInt(partes[2]);
				int ancho = Integer.parseInt(partes[3]);
				String fecha = partes[4];
				Choripan c = new Choripan(consumidor,largo,ancho,fecha);
				choripanes[cho] = c;
				cho++;
			}else if(tipo.equalsIgnoreCase("terremoto")) {
				float litros = Float.parseFloat(partes[2]);
				String fecha = partes[3];
				Terremoto t = new Terremoto(consumidor,litros,fecha);
				terremotos[terr] = t;
				terr++;
			}
			registros++;
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




