package concurrenteFecha;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {


	public static void main(String[] args) {
		
		try {
		
			int contClientes = 0;
			ServerSocket server = new ServerSocket(9550);
			System.out.println("Servidor encendido");
			
			while(true) {
				Socket cliente = server.accept();
				contClientes++;			
				System.out.println("Atendiendo peticion cliente: " + contClientes);
				Thread hilo = new HiloEnviarFecha(cliente);
				hilo.start();		
								
			}
						
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}

class HiloEnviarFecha extends Thread{
	
	private Socket socket;
	
	public HiloEnviarFecha(Socket s) {
		this.socket = s;
		
	}
	
	public void run() {
		Date fecha = new Date();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(fecha);
			socket.close();
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}