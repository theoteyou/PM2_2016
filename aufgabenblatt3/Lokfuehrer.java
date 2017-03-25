package aufgabenblatt3;

public class Lokfuehrer extends Thread {
	
	
	private RangierBahnhof hbf;
	private int gleis;
	
	public Lokfuehrer(RangierBahnhof hbf){
		this.hbf = hbf;
	}
	
	public void run(){
		while(!isInterrupted()){
			
			einfahren(gleis);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				interrupt();
			}
			ausfahren(gleis);
		}
	}
	
	public void einfahren(int gleis){
		hbf.einfahren(new Zug(Zug.Typ.METRONOM), gleis);
	}
	
	public void ausfahren(int gleis){
		hbf.ausfahren(gleis);
	}

}
