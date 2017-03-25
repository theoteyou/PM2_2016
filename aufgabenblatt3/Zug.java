package aufgabenblatt3;

public class Zug{
	
	public enum Typ {
		 ICE, SBAHN, METRONOM
		}
	private Typ typ;
	
	public Zug(){
		this(Typ.SBAHN);
	}
	public Zug(Typ typ){
		this.setTyp(typ);
	}
	public Typ getTyp() {
		return typ;
	}
	public void setTyp(Typ typ) {
		this.typ = typ;
	}
}


