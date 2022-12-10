package practica2;

public class Ejemplo1 {

	public static void main(String[] args) {
		int array1[] = new int[1000];
		int array2[] = new int[1000];
		long tiempoInicial;
		
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) (Math.random() * 10000);
		}
		
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * 10000);
		}
		
		tiempoInicial = System.currentTimeMillis();
		burbuja(array1);
		burbuja(array2);
		
		System.out.println("Tiempo de ejecucion: " + (System.currentTimeMillis()- tiempoInicial) + " ms");
	}

	private static void burbuja(int[] array) {
		
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
