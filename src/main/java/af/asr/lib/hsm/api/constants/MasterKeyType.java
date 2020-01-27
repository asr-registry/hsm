package af.asr.lib.hsm.api.constants;


public enum MasterKeyType {
	ZMK("000"),
	TMK("002");
	
	private String keyVariantType;
	
	MasterKeyType(String keyVariantType) {
		this.keyVariantType = keyVariantType;
	}
	
	public String toString() {
		return keyVariantType;
	}
}
