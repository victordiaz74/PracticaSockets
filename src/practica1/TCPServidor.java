package practica1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class TCPServidor {

    ServerSocket socketServidor;
    Socket conexion;
    
	public TCPServidor(int puerto) {
		try {
			socketServidor = new ServerSocket(puerto);
			System.out.println("Servicio escuchando...");
			conexion = socketServidor.accept();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	abstract void startServidor();

}
