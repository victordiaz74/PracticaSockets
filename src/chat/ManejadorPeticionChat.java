package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
	
	public ManejadorPeticionChat(BufferedReader entrada, PrintStream pantalla, PrintWriter salida) {
		this.entrada = entrada;
		this.salida = salida;
		this.pantalla = pantalla;
	}

	public void run() {
		
		try {
			
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida = new PrintWriter(cliente.getOutputStream(), true);

			
			salida.println("Bienvenido \nPara salir teclea: adios");
			salida.println("Introduce tu nombre: ");
			String nombre = entrada.readLine();
			linea = entrada.readLine();
			ServidorChat.difundir(nombre, "Conectado al chat");
			
			while(!linea.equals("adios")) {
				ServidorChat.difundir(nombre, linea);
				linea = entrada.readLine();
				if(linea.equals("adios")) {
					ServidorChat.difundir(nombre, "se ha desconectado");
					ServidorChat.eliminar(cliente);
				}
			}
			
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
