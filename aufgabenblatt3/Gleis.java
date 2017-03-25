package aufgabenblatt3;


public class Gleis {
	private Zug zug;
	private int gleisNummer;

	public Gleis(){
		this(null);
	}
	
	public Gleis(Zug zug){
		this.setZug(zug);
	}

	public boolean isGleisLeer()
	{
		return zug == null;
	}
	public Zug getZug() {
		return zug;
	}

	public void setZug(Zug zug) {
		this.zug = zug;
	}

	public int getGleisNummer() {
		return gleisNummer;
	}

	public void setGleisNummer(int gleisNummer) {
		this.gleisNummer = gleisNummer;
	}
	
}
