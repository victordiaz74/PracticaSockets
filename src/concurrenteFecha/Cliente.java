package concurrenteFecha;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		String servidor = "localhost";
		int puerto = 9550;
		Scanner sc = new Scanner(System.in);
	
		try {
			Socket cliente = new Socket(servidor, puerto);
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			System.out.println(ois.readObject());
			
			cliente.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
	
	}

}
