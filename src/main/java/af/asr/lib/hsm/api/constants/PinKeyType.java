package af.asr.lib.hsm.api.constants;

public enum PinKeyType {
	ZPK("001"), TPK("002");

	private String keyType;

	private PinKeyType(String keyType) {
		this.keyType = keyType;
	}

	public String toString() {
		return keyType;
	}
}
