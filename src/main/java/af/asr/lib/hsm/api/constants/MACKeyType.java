package af.asr.lib.hsm.api.constants;

public enum MACKeyType {

	TAC("003"), ZAC("008");

	private String keyType;

	private MACKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String toString() {
		return keyType;
	}
}
