package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Hilo extends Thread{
	

	BufferedReader br;
	PrintWriter pw;
	
	public Hilo(InputStream entrada, OutputStream salida) {

			br = new BufferedReader(new InputStreamReader(entrada));
			pw = new PrintWriter(salida, true);

	}
	
	public void run() {

		String mensaje;
		try {
			mensaje = br.readLine();
		
		while(mensaje != null){
			pw.println(mensaje);
			mensaje = br.readLine();
		}
		pw.println(mensaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
