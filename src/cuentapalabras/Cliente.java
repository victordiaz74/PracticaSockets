package cuentapalabras;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto =9999;
		Scanner sc = new Scanner(System.in);
		
		try {
			Socket cliente = new Socket(servidor, puerto);
			
			System.out.println("Introduce la cadena: ");;
			String cadena = sc.nextLine();
			
			System.out.println("Introduce la palabra a buscar en la cadena: ");
			String palabra = sc.nextLine();
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject(cadena);
			oos.writeObject(palabra);
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			int numRepes = ois.readInt();
			System.out.println("Numero de veces que aparece la palabra " + palabra + "en la frase: " + numRepes);
			
			cliente.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
