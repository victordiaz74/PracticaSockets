package escurreplatos;


public class Main {

	public static void main(String[] args) {
		EscurrePlatos escurridor = new EscurrePlatos(6);
		Lava lavador = new Lava(escurridor);
		//lavador.setPriority(Thread.MIN_PRIORITY);
		Seca secador = new Seca(escurridor);
		//secador.setPriority(Thread.MAX_PRIORITY);
		lavador.start();
		secador.start();

	}

}
