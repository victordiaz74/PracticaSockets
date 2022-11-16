package chat;

import java.io.IOException;
import java.net.Socket;

public class ClienteTelnet {
	
	static String servidor = "localhost";
	static int puerto = 11100;

	public static void main(String[] args) {
		
		ServidorChat servidorChat = new ServidorChat();
		ManejadorPeticionChat cliente = new ManejadorPeticionChat(null);
		
		conectarseA(servidor, puerto);
		
	}

	private static void conectarseA(String servidor, int puerto) {
		
		try {
			//Creamos el socket TCP
			Socket socketCliente = new Socket(servidor, puerto);
			ManejadorPeticionChat hilo1 = new ManejadorPeticionChat(socketCliente);
			hilo1.start();
			
		}catch (IOException e) {
			
		}
		
		
		
	}
}
