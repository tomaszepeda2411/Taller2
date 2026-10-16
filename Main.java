package taller2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int registros = 0;
	static int opcion = 0;
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
			System.out.println("[3] Calcular metricas");
			System.out.println("[4] Salir");
			System.out.println("============================");
			System.out.print("Seleccione una opcion:");
			opcion = scan.nextInt();
			try {
			switch(opcion) {
			case 1:
				verRegistros();
				break;
			case 2:
				actualizarRegistros();
				break;
			case 3:
				calcularMetricas();
				break;
			case 4:
				System.out.println("Hasta luego...");
				break;
			 default:
				System.out.println("Ingrese una opcion valida");
			}
			}catch(Exception e) {
				System.out.println("Ocurrio un error(" + e +").Volviendo al menu");
			}
		}while(opcion!=4);
		
	}
	private static void calcularMetricas() {
		
	}
	private static void actualizarRegistros() {
		int opcion = 0;
		do {
		System.out.println("============== ACTUALIZAR REGISTROS ===============");
		System.out.println("[1] Agregar");
		System.out.println("[2] Editar");
		System.out.println("[3] Eliminar");
		System.out.println("[4] Volver al menu principal");
		System.out.println("==================================");
		System.out.println("Seleccione una opcion: ");
		opcion = scan.nextInt();
		switch(opcion) {
		case 1:
			menuAgregar();
			
			}
			
		
	}while(opcion!=4);
	}
	
	private static void menuAgregar() {
		int tipo = 0;
		System.out.println();
		System.out.println("Tipo de registro:");
		System.out.println("[1] Choripanes");
		System.out.println("[2] Terremotos");
		System.out.println("[3] Cancelar");
		tipo = scan.nextInt();
		switch(tipo) {
		case 1:
			int aux = 0;
			for(int i = 0; i<participantes.length;i++) {
				if(participantes[i]!=null) {
					System.out.println("["+(i+1) +"] " + participantes[i].getNombre());
				}
			}
				System.out.println("Seleccionar al consumidor: ");
					aux= scan.nextInt();
					scan.nextLine();
					
					if(aux<1 || aux>participantes.length || participantes[aux-1] == null) {
						System.out.println("Consumidor no valido");
						break;
					}
					String nombreNuevo = participantes[aux-1].getNombre();
					
					System.out.print("Largo del choripan (cm): ");
					int largoNuevo = scan.nextInt();
					System.out.print("Ancho del choripan (cm): ");
					int anchoNuevo = scan.nextInt();
					scan.nextLine();
					System.out.print("Fecha (YYYY-MM-DD): ");
					String fechaNueva = scan.nextLine();
					
					int libre = -1;
					
					for (int i = 0; i<choripanes.length;i++) {
						if(choripanes[i]==null) {
							libre = i;
							break;
						}
					}
					if(libre == -1) {
						System.out.println("No hay espacio para mas choripanes");
						break;
					}
					if (!guardarLinea("Choripan;"+ nombreNuevo + ";" + largoNuevo + ";" + anchoNuevo + ";" + fechaNueva)) {
						break;
					}
				
					choripanes[libre] = new Choripan(nombreNuevo,largoNuevo,anchoNuevo,fechaNueva);
					registros++;
					System.out.println("Choripan agregado");
					break;
					
		case 2:
			for (int i = 0;i<participantes.length;i++) {
				if(participantes[i] != null) {
					System.out.println("["+(i+1) + "]" + participantes[i].getNombre());
				}
			}
			System.out.println("Seleccionar al consumidor: ");
			int consu = scan.nextInt();
			scan.nextLine();
			
			if (consu<1 || consu > participantes.length || participantes[consu-1] == null) {
				System.out.println("Consumidor no valido");
				break;
			}
			String nombreT = participantes[consu-1].getNombre();
			
			System.out.println("Litros del terremoto: ");
			float litrosNuevo = scan.nextFloat();
			scan.nextLine();
			System.out.println("Fecha (YYYY-MM-DD): ");
			String fechaT = scan.nextLine();
			
			int libreT =-1;
			for ( int i = 0;i<terremotos.length;i++) {
				if(terremotos[i] == null) {
					libreT = i;
					break;
				}
			}
			if(libreT ==-1) {
				System.out.println("No hay espacio para mas terremotos");
				break;
			}
			if(!guardarLinea("Terremoto;" + nombreT+ ";" + litrosNuevo + ";" + fechaT)) {
			break;
		}
		terremotos[libreT] = new Terremoto( nombreT,litrosNuevo,fechaT);
		registros++;
		System.out.println("Terremoto agregado");
		break;
		}
			}

	
	private static void verRegistros() {
		int opcion = 0;
		do {
		System.out.println("========VER REGISTROS=======");
		System.out.println("[1] Choripanes");
		System.out.println("[2] Terremotos");
		System.out.println("[3] Volver al menu");
		System.out.println("==========================");
		System.out.println("Seleccione una opcion: ");
		opcion = scan.nextInt();
		scan.nextLine();
		switch(opcion) {
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
			break;
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
				System.out.println("Presione ENTER para continuar:");
				scan.nextLine();
				break;
			
		case 3:
			break;
		}
		}while(opcion !=3);
		
	}
	private static void leerConsumidos() throws FileNotFoundException {
		File txtConsumidos = new File("Consumido.txt");
		scan = new Scanner(txtConsumidos);
		int cho = 0;
		int terr = 0;
		while(scan.hasNextLine()) {
			String linea = scan.nextLine().trim();
			if(linea.isEmpty()) {
				continue;
			}
			String[] partes = linea.split(";");
			if(partes.length < 4) {
				System.out.println("Linea ignorada ( formato invalido): " + linea);
				continue;
			}
			String tipo = partes[0];
			String consumidor = partes[1];
			if (tipo.equalsIgnoreCase("choripan") && partes.length >=5) {
				int largo = Integer.parseInt(partes[2]);
				int ancho = Integer.parseInt(partes[3]);
				String fecha = partes[4];
				Choripan c = new Choripan(consumidor,largo,ancho,fecha);
				choripanes[cho] = c;
				cho++;
				registros++;
			}else if(tipo.equalsIgnoreCase("terremoto")) {
				float litros = Float.parseFloat(partes[2]);
				String fecha = partes[3];
				Terremoto t = new Terremoto(consumidor,litros,fecha);
				terremotos[terr] = t;
				terr++;
				registros++;
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

	
	private static boolean guardarLinea(String linea) {
		try ( BufferedWriter bw = new BufferedWriter(new FileWriter("Consumido.txt"))){
			bw.write(linea);
			bw.newLine();
			return true;
		} catch (IOException e) {
			System.out.println("Error al guardar archivo");
			return false;
		}
	}
}




