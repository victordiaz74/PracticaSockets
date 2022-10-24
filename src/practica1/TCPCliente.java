package practica1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public abstract class TCPCliente {

	Socket socketCliente;
	
	public TCPCliente(String host, int puerto) {
		try {
			socketCliente = new Socket(host, puerto);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public abstract void startCliente();
	
	
}
