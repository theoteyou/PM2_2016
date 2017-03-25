package aufgabenblatt3;

public class Bahnhof {

	private Zug[] zuege;
	private RangierBahnhof rangierBahnhof;
	
	public Bahnhof(){
		this(10, 10);
	}
	
	public Bahnhof(int zugAnhzal, int gleisen){
		zuege = new Zug[zugAnhzal];
		rangierBahnhof = new RangierBahnhof(gleisen);
	}
	
	public void einfahren(Zug zug, int gleis)
	{
		try{
			rangierBahnhof.einfahren(zug, gleis);
			zuege[gleis]= zug;
		}
		catch(IndexOutOfBoundsException error)
		{
			error.printStackTrace(System.err);
		}
		
		
	}
	
	public void ausfahren( int gleis)
	{
		
		try{
			rangierBahnhof.ausfahren(gleis);
			zuege[gleis]= null;
		}
		catch(IndexOutOfBoundsException error)
		{
			error.printStackTrace(System.err);
		}
	}
	
	
}
