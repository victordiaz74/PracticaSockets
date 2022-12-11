package escurreplatos;

public class EscurrePlatos {
	
	boolean estaVacio = true;
	boolean estaLleno = false;
	
	int buffer[];
	int numPlatos = 10;
	int posicion;

	
	public EscurrePlatos(int capacidad) {
		
		buffer = new int[capacidad];
		posicion = 0;
		estaVacio = true;
		estaLleno = false;
	}
	
	public synchronized void meter(int plato) {
		while(estaLleno == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		numPlatos--;
		estaVacio = false;
		buffer[posicion] = plato;
		posicion++;
		
		if(posicion == buffer.length) {
			estaLleno = true;
		}
		
		notifyAll();
		
	}
	
	public synchronized int sacar() {
		
		while(estaVacio == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		numPlatos--;
		estaLleno = false;
		posicion--;
		
		if(posicion == 0) {
			estaVacio = true;
		}
		
		notifyAll();
		return buffer[posicion];
	}

}
