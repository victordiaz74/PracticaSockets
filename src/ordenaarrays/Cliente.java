package ordenaarrays;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 9000;
		
		int [] array1 = new int[10];
		for (int i=0;i<array1.length;i++)
			array1[i] = (int) (Math.random()*10)+1;
		
		
		int [] array2 = new int[10];
		for (int j=0;j<array2.length;j++)
			array2[j] = (int) (Math.random()*10)+1;
		
		
		try {
			//Me conecto al servidor
			Socket cliente = new Socket(servidor, puerto);
			
			System.out.println("Array sin ordenar");
			visualizarArray(array1);
			//Enviar datos al servidor
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			//Creamos un flujo de entrada para leer la fecha que nos pasa el servidor
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			oos.writeObject(array1);
			//Muestra por pantalla el array enviada por el servidor
			System.out.println(ois.readObject());
			//Cierro la conexion
			cliente.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void visualizarArray(int[] array1) {
		for (int i=0;i<array1.length;i++) {
			System.out.println(i);
		}
		
	}
	
}
