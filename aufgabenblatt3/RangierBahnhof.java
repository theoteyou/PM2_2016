package aufgabenblatt3;


public class RangierBahnhof  {

	private Gleis[] gleisen;

	
	public RangierBahnhof(){
		this(10);
	}
	public RangierBahnhof(int gleisAnzahl)
	{
		gleisen = new Gleis[gleisAnzahl];
		for(int i = 0; i < gleisAnzahl; i++){
			gleisen[i] = new Gleis();
			gleisen[i].setGleisNummer(i);
		}

	}

	public Gleis getGleis(int gleis) throws IndexOutOfBoundsException{
		if(gleis < 0 || gleis >= gleisen.length){
			throw new IndexOutOfBoundsException("gleis : " + gleis + " when Gleisen length is : " + gleisen.length);
		}
		return gleisen[gleis];
	}
	public int getGleisAnzahl(){
		return gleisen.length;
	}
	public boolean isGleisLeer(int gleis) throws IndexOutOfBoundsException
	{
		if(gleis < 0 || gleis >= gleisen.length){
			throw new IndexOutOfBoundsException("gleis : " + gleis + " when Gleisen length is : " + gleisen.length);
		}
		return gleisen[gleis].isGleisLeer();
	}
	public synchronized void einfahren(Zug zug, int gleis) throws IndexOutOfBoundsException
	{
		
		if(isGleisLeer(gleis))
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
			gleisen[gleis].setZug(zug);
			this.notifyAll();
			
		}
		
		
	}

	public synchronized void ausfahren( int gleis) throws IndexOutOfBoundsException
	{
		if(!isGleisLeer(gleis))
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
			gleisen[gleis].setZug(null);
			this.notifyAll();
			
		}
		
	}

	public void clear()
	{
		for(int i = 0; i < gleisen.length; i++){
			gleisen[i].setZug(null);
		}
	}

	public boolean isFull()
	{
		for(int i = 0; i < gleisen.length; i++){
			if(gleisen[i].isGleisLeer()){
				return false;
			}
		}
		return true;
	}
}
