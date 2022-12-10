package cenafilosofos;

public class Test {

	public static void main(String[] args) {
		
		Mesa mesa = new Mesa(5);
		
		for(int i = 1; i <= 5; i++) {
			Filosofo filosofo = new Filosofo(mesa, i);
			filosofo.start();
		}
	}

}
