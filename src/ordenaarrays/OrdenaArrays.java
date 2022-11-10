package ordenaarrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;

public class OrdenaArrays {

	public static void main(String[] args) {

		int i = 1;
		ServerSocket serverSocket = new ServerSocket(9000);
		System.out.println("Peticion del cliente: " + i);
		while(true) {
			Socket cliente = serverSocket.accept();
			Cliente hCliente = new Cliente(cliente);
			hCliente.start();
			i++;
		}
		

	}

	public static void ordenaBurbuja(int array[]) {
		/*Recorremos el array, comparamos elementos adyacentes
		 * y si no están bien ordenados los intercambiamos
		 */
		boolean hayIntercambio;
		do {
			hayIntercambio = false;
			//array.length - 1 para que no se pase leyendo
			for(int i = 0; i < array.length - 1; i++) {
				
				if(array[i] > (array[i + 1])) {
					//los intercambiamos
					int aux = array[i];
					array[i] = array[i + 1];
					array[i+1] = aux;
					hayIntercambio = true;
				}
			}
		}while(hayIntercambio);
		
	}

	
	public void run() {
		
		try {
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
								
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			int [] array = ois.readObject();
			
			ordenarBurbuja.writeObject(array);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
}
