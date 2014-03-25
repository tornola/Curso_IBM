package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

public class MenuNotas {
	
	//fdffffffffffffffffffffffffffffffffffffffffff

	static BufferedReader introduceNotas = new BufferedReader(new InputStreamReader(System.in));
	static String[] menu = {"1. Introduce nota", "2. Nota Media" , "3. Mostrar Extremas", "4. Mostrar todas", "5. Salir"};
	static double[] notas = new double[10];
	//Campo para poder indicar la posicion del array.
	static int posicionNota = 0;
	static DecimalFormat dc = new DecimalFormat("0.##");
	
	public static void main(String[] args) throws IOException{
		boolean b = true;
		
		while(b){
			for(String s: menu){
				System.out.println(s);
			}
			System.out.print("Elige opcion 1-5: ");
			
			String opcion = introduceNotas.readLine();
			
			switch(opcion){
				case "1":
					introduceNota();
					break;
				case "2":
					notaMedia();
					break;
				case "3":
					mostrarExtremas();
					break;
				case "4":
					mostrarTodas();
					break;
				case "5":
					System.out.println("Adios.");
					b = false;
					break;
				default:
					System.err.println("Opcion incorrecta. Debes de pulse entre 1 y 5.");
			}
		}

	}

	//Muestra todas las notas
	public static void mostrarTodas() {
		//El método notasVacias() comprueba si se ha introducido alguna nota
		if(notasVacias()){
			System.out.print("Todas las notas: ");
			for(int i = 0; i < posicionNota; i++){
				System.out.print(dc.format(notas[i]) + " ");
			}
			System.out.println();
		}
	}
	
	//Muestra la nota mayor y menor
	public static void mostrarExtremas() {
		//El método notasVacias() comprueba si se ha introducido alguna nota
		if(notasVacias()){
			System.out.println("La nota mas baja es: " + dc.format(notas[0]));
			System.out.println("La nota mas alta es: " + dc.format(notas[posicionNota-1]));
		}
		
	}

	public static void notaMedia() {
		//El método notasVacias() comprueba si se ha introducido alguna nota
		if(notasVacias()){
			double suma = 0;
			for(int i = 0; i < posicionNota; i++){
				suma += notas[i];
			}
			System.out.println("La nota media es: " + dc.format(suma/(posicionNota))); 
		}
		
	}

	public static void introduceNota() throws IOException {
		//Comprueba si el array está lleno
		if(posicionNota < notas.length){
			System.out.print("Introduce nota: ");
			double nota = Double.parseDouble(introduceNotas.readLine());
			//Comprueba si la nota introducida es correcta
			if(nota >= 0 && nota <= 10){
				notas[posicionNota] = nota;
				posicionNota++;
				//El método sort() de la utility class Arrays ordena el array
				Arrays.sort(notas, 0, posicionNota);
			}
			else{
				System.err.println("Valor de nota incorrecto, debe de estar comprendido entre 0 y 10, y tu has introducido: " + dc.format(nota));
			}
		}
		else{
			System.err.println("No puedes introducir mas notas.");
		}
	}
	
	//Método que comprueba si las notas están vacías
	public static boolean notasVacias() {
		if(posicionNota == 0){
			System.err.println("No hay notas introducidas");
			return false;
		}
		return true;
	}

}
