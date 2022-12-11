package ordenararrays;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(9556);
			System.out.println("Servidor encendido");
			while(true) {
				Socket servidor = server.accept();
				Thread hilo = new Manejador(servidor);
				hilo.start();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}


class Manejador extends Thread {
	
	Socket socket;
	
	public Manejador(Socket s) {
		socket = s;
		
	}
	
	public static void ordenaBurbuja(int array[]) {
		
		boolean hayIntercambio;
		do {
			hayIntercambio = false;
			
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i] > (array[i+1])) {
					int aux = array[i];
					array[i] = array[i + 1];
					array[i + 1] = aux;
					hayIntercambio = true;
				}
			}
			
		}while(hayIntercambio);
		
	}
	
	public void run() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			int [] arrayCliente = (int[]) ois.readObject();
			
			ordenaBurbuja(arrayCliente);
			
			oos.writeObject(arrayCliente);
			
			oos.close();
			ois.close();
			
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}