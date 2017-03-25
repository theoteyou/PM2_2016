package aufgabenblatt3;

import java.util.Observable;


public class Simulation extends Observable implements Runnable {

	private RangierBahnhof hbf;
	private boolean isInterrupted;

	private int gleis;

	public Simulation() {
		hbf = new RangierBahnhof();
		isInterrupted = false;
	}

	public Gleis getGleis(int gleis){
		try{
			return hbf.getGleis(gleis);
		}
		catch(IndexOutOfBoundsException error){
			error.printStackTrace();
			return null;
		}
	}
	public int getGleisenAnzahl(){
		return hbf.getGleisAnzahl();
	}
	@Override
	public void run() {
		while (!isInterrupted) {

			Lokfuehrer lokfuehrer = new Lokfuehrer(hbf);
			gleis = (int) (Math.random() * hbf.getGleisAnzahl());
			if (((int) (Math.random() * 10)) % 2 == 0) {
				if (hbf.isGleisLeer(gleis)) {
					lokfuehrer.einfahren(gleis);
					setChanged();
					//hasChanged();
					System.err.println("Zug ist eingefahren");
				} else {
					System.err.println("Zug kann nicht einfahren");
				}
			} else {
				if (!hbf.isGleisLeer(gleis)) {
					lokfuehrer.ausfahren(gleis);
					setChanged();
					//hasChanged();
					System.err.println("Zug ist ausgefahren");
				}
				else{
					System.err.println("Zug kann nicht ausfahren, der Gleis ist leer");
				}

			}
			notifyObservers(getGleis(gleis));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
				isInterrupted = true;
			}
		}
	}

}
