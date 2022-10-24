package practica1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TCPFicheroCliente extends TCPCliente{

	public TCPFicheroCliente(String host, int puerto) {

		super(host, puerto);
		Scanner sc = new Scanner(System.in);
		String numbytesLeidosFich = sc.nextLine();
		File file = new File(numbytesLeidosFich);
		FileInputStream fis = new FileInputStream("ficheroSocket");
		BufferedReader br = new BufferedReader(fis);
		DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
		
		
		startCliente();
	
	}

	@Override
	public void startCliente() {
		File fichero = new File("ficheroSocket");
		byte[] buffer = new byte[256];
		int bytesLeidos = 0;
		do {
			try {
				bytesLeidos = fis.read(buffer);
			}catch(IOException e) {
				System.out.println("Error al leer");
			}
			try {
				dos.write(buffer, 0, bytesLeidos);
			}catch(IOException e) {
				System.err.println("error al escribir");
			}
		}while(bytesLeidos == 256);
		
		try {
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			dos.close();
			System.out.println("fichero enviado");
		}catch (IOException e) {
			
		}
		
		
	}

}
