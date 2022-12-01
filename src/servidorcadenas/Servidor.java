package servidorcadenas;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class Servidor {

	public static void main(String[] args) {

		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8900);
			System.out.println("Servidor encendido");
			while (true) {
				Socket cliente = s.accept();
				i++;
				System.out.println("Atendiendo peticion del cliente" + i);
				System.out.println("\nPuerto: " + cliente.getPort());
				System.out.println("IP: " + cliente.getInetAddress());
				Thread tarea = new RecibirCadena(cliente);
				tarea.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class RecibirCadena extends Thread {
	
	Socket socket;
	
	public RecibirCadena(Socket i) {
		socket = i;

	}

	public void run() {
		
		String cadena;
		String palabra;
		try {

			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			cadena = (String) ois.readObject();
			palabra = (String) ois.readObject();

			int contador = contarPalabra(palabra, cadena);
			
			oos.writeInt(contador);
			
			oos.close();
			ois.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int contarPalabra(String palabra, String cadena) {
		
		//separo la cadena por palabras
	    String caracter[] = cadena.split(" ");
	 
	    //busco la palabra en la cadena
	    int contador = 0;
	    for (int i = 0; i < caracter.length; i++){
		    //si la encuentra suma
		    if (palabra.equalsIgnoreCase(caracter[i])) {
		    	contador++;
		    }
	    }
	 
	    return contador;
		
	}

	
}