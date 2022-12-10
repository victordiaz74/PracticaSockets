package practica2;

public class Ejemplo2_HilosThread {

	public static void main(String args[]) {
		
		int array1[] = new int[10000];
		int array2[] = new int[10000];
		long tiempoActual;
		
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) (Math.random() * 10000);
		}
		
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * 10000);
		}
		
		Hebra hebra1 = new Hebra(array1);
		Hebra hebra2 = new Hebra(array2);
		
		hebra1.start();
		hebra2.start();
		
		tiempoActual = System.currentTimeMillis();
		System.out.println("tiempo de ejecucion " + (System.currentTimeMillis()
		- tiempoActual) + "ms");
	}
	
}
