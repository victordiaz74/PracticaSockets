package practica4;

public class Tuberia {

	char [] buffer;
	int primero;
	int fin;
	
	boolean estaLlena;
	boolean estaVacia;
	
	public Tuberia(int tamaño) {
		buffer = new char[tamaño];
		primero = 0;
		fin = tamaño;
		estaLlena = false;
		estaVacia = true;
	}
	
	public synchronized void poner(char caracter) {
		while(estaLlena = true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		buffer[primero] = caracter;
		primero++;
		
		
		if(primero == fin) {
			estaLlena = true;
		}
		estaVacia = false;
		notifyAll();
		
	}
	
	public synchronized char recoger() {
		while(estaVacia == true) {
			try {
				wait();
			}catch(InterruptedException e) {}
			
		}
		fin++;
		
		if(fin == 0) {
			estaVacia = true;
		}
		estaLlena = false;
		notifyAll();
		return buffer[fin];
		
	}

}
