package practica4;

public class Consumidor extends Thread{
	
	private Tuberia tuberia;
	
	public Consumidor(Tuberia tub) {
		tuberia = tub;
	}

    public void run() {
    	for(int i=0; i< 10; i++) {
            // Consume el valor si es posible
            char valor = tuberia.recoger();
            System.out.println("La letra recogida es: " + valor);
            try {
                sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) { 
            	System.err.println("hola");
            }
        }
    }

}
