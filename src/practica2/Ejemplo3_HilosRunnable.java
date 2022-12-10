package practica2;

public class Ejemplo3_HilosRunnable{
	
	public static void main(String []args) {
		int array1[] = new int[10000];
		int array2[] = new int[10000];
		long tiempoActual;
		
		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) (Math.random() * 10000);
		}
		
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * 10000);
		}
		
		HebraRunnable hebra1 = new HebraRunnable(array1);
		HebraRunnable hebra2 = new HebraRunnable (array2);
		
		Thread array11=new Thread(hebra1);
		Thread array21=new Thread(hebra2);
		
		tiempoActual = System.currentTimeMillis();
		
		array11.start();
		array21.start();

		for (int i=0; i<array1.length; i++) {
			System.out.print(array1[i] + "\t");
		}
		System.out.println();
		for (int i=0; i<array2.length; i++) {
			System.out.print(array2[i] + "\t");
		}
		System.out.println();

		System.out.println("Tiempo de ejecución: " + (System.currentTimeMillis() - tiempoActual) + " ms");
	}
	
	

}
