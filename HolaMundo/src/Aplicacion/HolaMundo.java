package Aplicacion;


class Programa implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Estoy ejecutandome en segundo plano desde el hilo: "+ Thread.currentThread().getName());
		
	}
	
}


public class HolaMundo {

	public static void main(String[] args) {
		
		System.out.println("Hola Mundo!!! Desde el hilo: "+ Thread.currentThread().getName());
		
		Programa programa1 = new Programa();
		Thread ejecucion1 = new Thread(programa1);
		//System.out.println(ejecucion1.getName());
		ejecucion1.start();
		
		Programa programa2 = new Programa();
		Thread ejecucion2 = new Thread(programa2);
		//System.out.println(ejecucion2.getName());
		ejecucion2.start();
		
		
		/*lambda
		 * public Thread(Runnable target)
		 * */
		Thread ejecucion3 = new Thread(  () -> System.out.println("Hola con lambda desde el hilo: "+ Thread.currentThread().getName())  );
		ejecucion3.start();
		
		
		/*función anónima*/
		/*Runnable programa4 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Buenos días con función anónima desde el hilo: "+Thread.currentThread().getName());
				
			}
		};*/
		
		Thread ejecucion4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Buenos días con función anónima desde el hilo: "+Thread.currentThread().getName());
				
			}
		});
		ejecucion4.start();
		
	}

}
