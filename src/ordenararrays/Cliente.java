package ordenararrays;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {

		String servidor = "localhost";
		int puerto = 9556;
		
		try {
			Socket cliente = new Socket(servidor, puerto);
			
			int [] array = {45, 26, 98, 12, 21, 4, 7};
			
			System.out.println("Array sin ordenar: ");
			visualizarArray(array);
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			oos.writeObject(array);
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			array = (int[]) ois.readObject();
			
			System.out.println("Array ya ordenado: ");
			visualizarArray(array);
			
			cliente.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void visualizarArray(int [] array) {
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
	}

}
