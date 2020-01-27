package af.asr.lib.hsm.api.constants;


public enum BDKType {
	BDK1("*"),
	BDK2("~");
	
	private String bdkFlag;
	
	private BDKType(String bdkFlag) {
		this.bdkFlag = bdkFlag;
	}
	
	public String toString() {
		return bdkFlag;
	}
}
