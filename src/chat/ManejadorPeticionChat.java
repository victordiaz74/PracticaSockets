package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ManejadorPeticionChat extends Thread {
	
	Socket cliente;
	BufferedReader entrada;
	PrintWriter salida;
	PrintStream pantalla;
	String linea;
	
	public ManejadorPeticionChat(Socket cliente) {
		this.cliente = cliente;
		
	}
	
	public void run() {
		
		try {
			
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida = new PrintWriter(cliente.getOutputStream());
			pantalla = new PrintStream(cliente.getOutputStream());
			
			salida.println("Bienvenido \nPara salir teclea: adios");
			salida.println("Introduce tu nombre: ");
			String nombre = entrada.readLine();
			
			try {
                sleep(100);
            } catch (InterruptedException e) {
            	System.err.println("Error espera:" + e.getMessage());
            }	
			
		}catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
			
		
		
	}
} 
