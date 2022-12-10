package productorconsumidorabc;

public class Buffer {
	
	private char buffer[];
	private int siguiente;
	
	private boolean estaVacia;
	private boolean estaLlena;
	
	public Buffer(int tamanio) {
		
		buffer = new char[tamanio];
		siguiente = 0;
		estaVacia = true;
		estaLlena = false;
		
	}
	
	public synchronized char consume() {
		
		while(estaVacia == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		siguiente--;
		estaLlena = false;
		
		if(siguiente == 0) {
			estaVacia = true;
		}
		notifyAll();
		return buffer[siguiente];
		
	}
	
	public synchronized void produce(char c) {
		
		while(estaLlena == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		buffer[siguiente] = c;
		estaVacia = false;
		siguiente++;
		
		if(siguiente == buffer.length) {
			estaLlena = true;
		}
		
		notifyAll();
	}

}
