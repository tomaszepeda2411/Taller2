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
		System.out.print("Seleccione una opcion: ");
		opcion = scan.nextInt();
		switch(opcion) {
		case 1:
			menuAgregar();
			break;
		case 2:
			menuEditar();
			break;
		case 3: 
			menuEliminar();
			break;
			}
			
		
	}while(opcion!=4);
	}
	private static void menuEliminar() {
		scan.nextLine();
		int tipo = 0;
		do {
		System.out.println("Tipo de registro a eliminar:");
		System.out.println("  [1] Choripan");
		System.out.println("  [2] Terremoto");
		System.out.println("  [3] Salir");
		System.out.print("Seleccione una opcion: ");
		tipo = scan.nextInt();
		System.out.println("");
		switch(tipo) {
		case 1:
			System.out.println("======== CHORIPANES =======");
			System.out.printf("%-5s%-15s%-10s%-10s%-15s%-10s%n",
					"N°", "Consumidor", "Largo", "Ancho", "Fecha", "Kcal");
			int contador = 0;
			for (int i = 0; i<choripanes.length;i++) {
				if((choripanes[i]!=null)) {
					contador++;
					System.out.printf("%-5d%-15s%-10d%-10d%-15s%-10.2f%n",
							contador,
							choripanes[i].getConsumidor(),
							choripanes[i].getLargo(),
							choripanes[i].getAncho(),
							choripanes[i].getFecha(),
							choripanes[i].calcularKcal());
						}

					}
			if(contador ==0) {
				System.out.println("No hay Choripanes registrados");
				break;
			}
			System.out.print("Seleccion el registro a editar(0 para cancelar): ");
			int registroEditar = scan.nextInt();
			scan.nextLine();
			if(registroEditar == 0) {
				break;
			}
			
			if(registroEditar <1 || registroEditar > contador) {
				System.out.println("Numero no valido");
				break;
			}
			
			Choripan actual = choripanes[registroEditar-1];
			String desicion = "";
			
			System.out.println("Confirma la eliminacion de -> Choripan | " + actual.getConsumidor() + " | " + actual.getLargo()
					+ " x " + actual.getAncho() + "cm | " + actual.getFecha() +" (s/n): ");
			desicion = scan.nextLine();
			
			if(desicion.equalsIgnoreCase("N")) {
				break;
			}else if (desicion.equalsIgnoreCase("S")){
				
			}else {
				System.out.println("Ingrese una opcion valida");
				break;
			}
			break;
		
		}
		}while(tipo!=3);
	}
	// metodo para editar los consumidos 
	private static void menuEditar() {
		scan.nextLine();
		int tipo = 0;
		do {
		System.out.println("Tipo de registro a editar:");
		System.out.println("  [1] Choripan");
		System.out.println("  [2] Terremoto");
		System.out.println("  [3] Salir");
		System.out.print("Seleccione una opcion: ");
		tipo = scan.nextInt();
		System.out.println("");
		switch(tipo) {
		case 1:
			System.out.println("======== CHORIPANES =======");
			System.out.printf("%-5s%-15s%-10s%-10s%-15s%-10s%n",
					"N°", "Consumidor", "Largo", "Ancho", "Fecha", "Kcal");
			int contador = 0;
			for (int i = 0; i<choripanes.length;i++) {
				if((choripanes[i]!=null)) {
					contador++;
					System.out.printf("%-5d%-15s%-10d%-10d%-15s%-10.2f%n",
							contador,
							choripanes[i].getConsumidor(),
							choripanes[i].getLargo(),
							choripanes[i].getAncho(),
							choripanes[i].getFecha(),
							choripanes[i].calcularKcal());
						}

					}
			if(contador ==0) {
				System.out.println("No hay Choripanes registrados");
				break;
			}
			System.out.print("Seleccion el registro a editar(0 para cancelar): ");
			int registroEditar = scan.nextInt();
			scan.nextLine();
			if(registroEditar == 0) {
				break;
			}
			
			if(registroEditar <1 || registroEditar > contador) {
				System.out.println("Numero no valido");
				break;
			}
			
			Choripan actual = choripanes[registroEditar-1];
			
			System.out.println("Registro actual -> Choripan | " + actual.getConsumidor() + " | " + actual.getLargo()
					+ " x " + actual.getAncho() + "cm | " + actual.getFecha());
			System.out.println("Deje el campo en blanco si lo quiere mantener");
			System.out.println();
			
			boolean consumidorValido = false;
			while(!consumidorValido) {
				System.out.print("Consumidor [" + choripanes[registroEditar-1].getConsumidor() + "]:");
				String nuevoConsumidor = scan.nextLine().trim();
				if(nuevoConsumidor.isEmpty()) {
					consumidorValido = true;
			}else {
				for(int i = 0; i<participantes.length;i++) {
					if((participantes[i] != null) && participantes[i].getNombre().equalsIgnoreCase(nuevoConsumidor)) {
						actual.setConsumidor(participantes[i].getNombre());
						consumidorValido = true;
			
					}
				}
				if(!consumidorValido) {
					System.out.println("Participante no encontrado en Participante.txt");
				}
			}
		}
		boolean largoValido = false;
		while(!largoValido) {
			System.out.print("Largo [" + actual.getLargo() + "cm]:");
			String largoNuevo = scan.nextLine().trim();
			if(largoNuevo.isEmpty()) {
				largoValido = true;
			}else {
				try {
					int valor = Integer.parseInt(largoNuevo);
					if(valor <= 0) {
						System.out.println("La medida debe ser mayor a 0");
					}else {
						actual.setLargo(valor);
						largoValido=true;
					}
				}catch(NumberFormatException e) {
					System.out.println("Ingrese un numero valido");
				}
			}
		}
		boolean anchoValido = false;
		while(!anchoValido) {
			System.out.print("Ancho[" + actual.getAncho()+ "cm]:");
			String anchoNuevo = scan.nextLine().trim();
			if(anchoNuevo.isEmpty()) {
				anchoValido = true;
			}else {
				try {
					int valor = Integer.parseInt(anchoNuevo);
					if(valor <= 0) {
						System.out.println("La medida debe ser mayor a 0");
					}else {
						actual.setAncho(valor);
						anchoValido = true;
					}
				}catch(NumberFormatException e) {
					System.out.println("Ingrese un numero valido");
				}
			}
		}
		System.out.print("Fecha [" + actual.getFecha() + "]: ");
		String nuevaFecha = scan.nextLine().trim();
		if(!nuevaFecha.isEmpty()) {
			actual.setFecha(nuevaFecha);
		}
		
		if(guardarTodo()) {
			System.out.println("Choripan actualizado");
		}
			break; 	
		
		case 2:
			System.out.println("============= TERREMOTOS ==============");
			System.out.printf("%-5s%-15s%-10s%-15s%-10s%n",
					"N°", "Consumidor", "Litros","Fecha", "Kcal");
			int contador2 = 0;
			for (int i=0;i<terremotos.length;i++) {
				if(terremotos[i]!=null) {
					contador2++;
					System.out.printf("%-5d%-15s%-10.2f%-15s%-10.2f%n",
							contador2,
							terremotos[i].getConsumidor(),
							terremotos[i].getLitros(),
							terremotos[i].getFecha(),
							terremotos[i].calcularKcal());

					}
			}
			if(contador2 ==0) {
				System.out.println("No hay terremotos registrados");
				break;
			}
			
			System.out.print("Seleccione el registro a editar( 0 para cancelar):");
			int numeroEditar = scan.nextInt();
			scan.nextLine();
			if(numeroEditar == 0) {
				break;
			}
			if(numeroEditar<1 || numeroEditar>contador2) {
				System.out.println("Numero ingresado no valido");
				break;
			}
			Terremoto actualT = terremotos[numeroEditar-1];
			
			System.out.println("Registro actual -> Terremoto | "+ actualT.getConsumidor() + " | " + actualT.getLitros() + " L | " + actualT.getFecha());
			System.out.println("Deje el campo vacio para mantener el valor actual.");
			System.out.println();
			
			boolean consumidorTValido = false;
			while(!consumidorTValido) {
				System.out.print("Consumidor [" + terremotos[numeroEditar-1].getConsumidor() + "]:");
				String nuevoConsumidor = scan.nextLine().trim();
				if(nuevoConsumidor.isEmpty()) {
					consumidorTValido = true;
			}else {
				for(int i = 0; i<participantes.length;i++) {
					if((participantes[i] != null) && participantes[i].getNombre().equalsIgnoreCase(nuevoConsumidor)) {
						actualT.setConsumidor(participantes[i].getNombre());
						consumidorTValido = true;
			
					}
				}
				if(!consumidorTValido) {
					System.out.println("Participante no encontrado en Participante.txt");
				}
			}
		}
			boolean litrosValido = false;
			while(!litrosValido) {
				System.out.print("Litros[" + actualT.getLitros()+ "L]:");
				String litrosNuevo = scan.nextLine().trim();
				if(litrosNuevo.isEmpty()) {
					litrosValido = true;
				}else {
					try {
						float valor = Float.parseFloat(litrosNuevo);
						if(valor <= 0) {
							System.out.println("La medida debe ser mayor a 0");
						}else {
							actualT.setLitros(valor);
							litrosValido = true;
						}
					}catch(NumberFormatException e) {
						System.out.println("Ingrese un numero valido");
					}
				}
			}
			System.out.print("Fecha [" + actualT.getFecha() + "]: ");
			String nuevaFechaT = scan.nextLine().trim();
			if(!nuevaFechaT.isEmpty()) {
				actualT.setFecha(nuevaFechaT);
			}
			
			if(guardarTodo()) {
				System.out.println("Terremoto actualizado");
			}
			break;
			
		case 3:
			break;
		}
		}while(tipo!=3);
	}
	
	// metodo para el menu de la opcion agregar y para su uso
	private static void menuAgregar() {
		int tipo = 0;
		do {
		System.out.println();
		System.out.println("Tipo de registro:");
		System.out.println("[1] Choripanes");
		System.out.println("[2] Terremotos");
		System.out.println("[3] Cancelar");
		System.out.print("Ingrese el numero de lo que quiera Agregar: ");
		tipo = scan.nextInt();
		switch(tipo) {
		case 1:
			int aux = 0;
			for(int i = 0; i<participantes.length;i++) {
				if(participantes[i]!=null) {
					System.out.println("["+(i+1) +"] " + participantes[i].getNombre());
				}
			}
				System.out.print("Seleccionar al consumidor: ");
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
					choripanes[libre] = new Choripan(nombreNuevo,largoNuevo,anchoNuevo,fechaNueva);
					if (!guardarTodo()) {
						choripanes[libre] = null;
						break;
					}
					registros++;
					System.out.println("Choripan agregado y guardado en Cosumido.txt");
					System.out.println("Choripan | " + nombreNuevo + " | " + largoNuevo + " x " + anchoNuevo 
							+ " cm | " + fechaNueva + " | " + choripanes[libre].calcularKcal() + " kcal");
					break;
					
		case 2:
			for (int i = 0;i<participantes.length;i++) {
				if(participantes[i] != null) {
					System.out.println("["+(i+1) + "]" + participantes[i].getNombre());
				}
			}
			System.out.print("Seleccionar al consumidor: ");
			int consu = scan.nextInt();
			scan.nextLine();
			
			if (consu<1 || consu > participantes.length || participantes[consu-1] == null) {
				System.out.println("Consumidor no valido");
				break;
			}
			String nombreT = participantes[consu-1].getNombre();
			
			System.out.print("Litros del terremoto: ");
			float litrosNuevo = scan.nextFloat();
			scan.nextLine();
			System.out.print("Fecha (YYYY-MM-DD): ");
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
			}terremotos[libreT] = new Terremoto( nombreT,litrosNuevo,fechaT);
			if(!guardarTodo()) {
				terremotos[libreT] = null;
				break;
		}
		registros++;
		System.out.println("Terremoto agregado y guardado en Consumidos.txt");
		System.out.println("Terremoto | " + nombreT + " | " + litrosNuevo + " L | " + fechaT + " | " + terremotos[libreT].calcularKcal() + " kcal");
		break;
		case 3:
			break;
		default:
			System.out.println("Ingrese una opcion valida");
			break;
		}
		}while(tipo!=3);
			}

	/// Primer menu que lleva los registros encontrados en los txt
	private static void verRegistros() {
		int opcion = 0;
		do {
		System.out.println("========VER REGISTROS=======");
		System.out.println("[1] Choripanes");
		System.out.println("[2] Terremotos");
		System.out.println("[3] Volver al menu");
		System.out.println("==========================");
		System.out.print("Seleccione una opcion: ");
		opcion = scan.nextInt();
		scan.nextLine();
		switch(opcion) {
		case 1:
			int contador = 1;
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
			System.out.print("Presione ENTER para continuar:");
			scan.nextLine();
			
			break;
		case 2:
			int contador2 = 1;
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
				System.out.print("Presione ENTER para continuar:");
				scan.nextLine();
				break;
			
		case 3:
			break;
		}
		}while(opcion !=3);
		
	}
	// lee el archivo Consumidos.txt separandolos por choripan y terremoto 
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
	
	// lee los participantes
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

	

	// este metodo crea nuevamente Consumido.txt con las cosas que quieras agregarle y lo ordena
	private static boolean guardarTodo() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Consumido.txt"))){
			for(int i = 0;i<choripanes.length;i++) {
				if(choripanes[i] != null) {
					bw.write("Choripan;" + choripanes[i].getConsumidor() + ";"
							+ choripanes[i].getLargo() + ";" + choripanes[i].getAncho() + ";" + choripanes[i].getFecha());
					bw.newLine();
				}
			}
			for(int i = 0;i<terremotos.length;i++) {
				if(terremotos[i] != null) {
					bw.write("Terremoto;" + terremotos[i].getConsumidor() + ";"+ terremotos[i].getLitros() +  ";" + terremotos[i].getFecha());
					bw.newLine();
				}
			}
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	private static String buscarParticipante(String nombre) {
		for(int i = 0; i <participantes.length;i++) {
			if(participantes[i] != null && participantes[i].getNombre().equalsIgnoreCase(nombre)) {
				return participantes[i].getNombre();
			}
		}
		return null;
	}
}




