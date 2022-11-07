package practicaservidorconcurrente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ServidorFecha {

	public static void main(String[] args) {

		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8900);
			System.out.println("Servidor encendido");
			while (true) {
				Socket socket = s.accept();
				i++;
				System.out.println("Atendiendo peticion del cliente" + i);
				System.out.println("\nPuerto: " + socket.getPort());
				System.out.println("IP: " + socket.getInetAddress());
				Thread tarea = new EnviarFecha(socket);
				tarea.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


class EnviarFecha extends Thread {
	private Socket socket;
	/**
	 * Constructs a handler.
	 * 
	 * @param i the incoming socket
	 * @param c the counter for the handlers (used in prompts)
	 */
	public EnviarFecha(Socket i) {
		socket = i;

	}

	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true /* autoFlush */);

			salida.println("Hola! Introduce salir para salir.");

			Date fecha = new Date();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeObject(fecha);
			
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}