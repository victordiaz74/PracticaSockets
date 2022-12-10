package practica3;

public class Tuberia {

	final int TAM_MAX = 6;
	char [] buffer;
	int siguiente;
	
	boolean estaLlena;
	boolean estaVacia;
	
	public Tuberia() {
		buffer = new char[TAM_MAX];
		siguiente = 0;
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
		buffer[siguiente] = caracter;
		siguiente++;
		
		
		if(siguiente == buffer.length) {
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
			
			siguiente--;
			
		}
		if(siguiente == 0) {
			estaVacia = true;
		}
		estaLlena = false;
		notifyAll();
		return buffer[siguiente];
		
	}

}
