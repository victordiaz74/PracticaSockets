package practica2;

public class HebraRunnable implements Runnable {

	int [] array;
	
	public HebraRunnable(int []array) {
		super();
		this.array = array;
	}

	public void run() {
		burbuja(array);		
	}

	public static void burbuja(int[] array) {
		
		boolean intercambio = false;
		
		do {
			intercambio = false;
			for(int i = 0; i < array.length -1; i++) {
				if(array[i] > array[i + 1]) {
					//los intercambiamos
					int aux = array[i];
					array[i] = array[i + 1];
					array[i+1] = aux;
					intercambio = true;
				}
			}
		}while(intercambio);
	}
}
