
public class VerbEntry {

	private String word;
	private String pos;
	private String function;
	private boolean irreg;
	private boolean reg;
	private boolean hortative;
	private boolean imperative;
	private boolean honimperative;
	private boolean honorific;

	public VerbEntry(String wrd, String ps) {
		
		this.word = wrd;
		this.pos = ps;
		this.function = "";
		this.irreg = false;
		this.reg = false;
		this.hortative = true;
		this.imperative = true;
		this.honimperative = true;
		this.honorific = true;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPos() {
		return pos;
	}
	
	public String getFullPos() {
		if (pos.equals("A")) {
			return "Adjective";
		} else if (pos.equals("V")) {
			return "Verb";
		} else {
			return pos;
		}
	}

	public void setPos(String pos) {
		this.pos = pos;
	}
	
	public String getFunction() {
		if (function.equals("adj")) {
			return "A";
		} else if (function.equals("verb")) {
			return "V";
		}
		return "";
	}
	
	public void setFunction(String function) {
		this.function = function;
	}

	public boolean isIrreg() {
		return irreg;
	}

	public void setIrreg(boolean irreg) {
		this.irreg = irreg;
	}
	
	public boolean isReg() {
		return reg;
	}

	public void setReg(boolean reg) {
		this.reg = reg;
	}

	public boolean isHortative() {
		return hortative;
	}

	public void setHortative(boolean hortative) {
		this.hortative = hortative;
	}

	public boolean isImperative() {
		return imperative;
	}

	public void setImperative(boolean imperative) {
		this.imperative = imperative;
	}

	public boolean isHonimperative() {
		return honimperative;
	}

	public void setHonimperative(boolean honimperative) {
		this.honimperative = honimperative;
	}

	public boolean isHonorific() {
		return honorific;
	}

	public void setHonorific(boolean honorific) {
		this.honorific = honorific;
	}
}
