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
		
		
		
		
	}
}
