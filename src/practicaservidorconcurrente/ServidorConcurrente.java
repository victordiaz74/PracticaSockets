package practicaservidorconcurrente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


public class ServidorConcurrente {

	public static void main(String[] args) {

		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8900);
			System.out.println("Servidor encendido");
			while (true) {
				Socket socket = s.accept();
				System.out.println("Atendiendo peticion");
				Thread tarea = new EnviarFecha(socket, i);
				tarea.start();
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}


class EnviarFecha extends Thread {
	private Socket socket;
	private int contador;
	/**
	 * Constructs a handler.
	 * 
	 * @param i the incoming socket
	 * @param c the counter for the handlers (used in prompts)
	 */
	public EnviarFecha(Socket i, int c) {
		socket = i;
		contador = c;
	}

	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true /* autoFlush */);

			salida.println("Hola! Introduce salir para salir.");

			Date fecha = new Date(2022,11,07,19,31);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			oos.writeObject(fecha);
			
			boolean done = false;
			while (!done) {
				String linea = entrada.readLine();
				if (linea == null)
					done = true;
				else {
					salida.println("Echo " + contador + ": " + linea);

					if (linea.trim().equals("salir"))
						done = true;
				}
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}