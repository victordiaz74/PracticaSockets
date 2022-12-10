package practica2;

public class Hebra extends Thread{

	int [] array;
	
	public Hebra(int []array) {
		this.array = array;
	}
	
	public void run()
	{
		int i;
		int j;
		int aux;
		
        for(i = 0; i < array.length -1; i++)
             for(j = 0; j < array.length -i -1; j++)
                  if(array[j+1] < array[j]){
                     aux = array[j+1];
                     array[j+1] = array[j];
                     array[j] = aux;
                  }
	}
}
