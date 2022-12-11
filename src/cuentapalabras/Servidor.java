package cuentapalabras;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String [] args) {
		
		try {
			int contCliente = 1;
			ServerSocket server = new ServerSocket(9999);
			System.out.println("Servidor encendido");
			while(true) {
				Socket servidor = server.accept();
				contCliente++;
				System.out.println("Atendiendo al cliente" + contCliente);
				Thread hilo = new Manejador(servidor);
				hilo.start();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}


class Manejador extends Thread{
	
	Socket socket;
	
	public Manejador(Socket s) {
		this.socket = s;
		
		
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
		
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public int contarPalabra(String palabra, String cadena) {

		String caracter[] = cadena.split(" ");
		
		int contador = 0;
		
		for(int i = 0; i < caracter.length; i++) {
			if(palabra.equalsIgnoreCase(caracter[i])) {
				contador++;
			}
		}
		
		
		return contador;
	}
	
}