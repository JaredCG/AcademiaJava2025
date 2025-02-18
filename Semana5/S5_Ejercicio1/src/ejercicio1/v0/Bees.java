package ejercicio1.v0;

public class Bees {

	public static void main(String[] args) {
		try {
			new Bees().go();
		} catch (Exception e) {
			System.out.println("thrown to main");
	    }
	}
	
	synchronized void go() throws InterruptedException {
	        Thread t1 = new Thread();
	        t1.start();
	        System.out.print("1 ");
	        t1.wait();//"Pausado" hasta que el hilo sea invocado de nuevo (notify)
	        t1.notify();
	        //Thread.sleep(5000);
	        System.out.print("2 ");
	    }
}

//Con "wait" resulta en "1 thrown to main"