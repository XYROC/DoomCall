package xiroc.doomcall.lib;

public enum Energy {
	
	QE("Energy", "QE");
	
	private String name;
	private String symbol;
	
	Energy(String name, String symbol){
		this.name = name;
		this.symbol = symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public String getPlural(){
		return name + "s";
	}

}
