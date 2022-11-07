package practicaservidorconcurrente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;


public class ClienteFecha {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 8900;
		
		try {
			Socket cliente = new Socket(servidor, puerto);
			ObjectInputStream entradaObjeto = new ObjectInputStream(cliente.getInputStream());
			System.out.println(entradaObjeto.readObject());
			cliente.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
}
