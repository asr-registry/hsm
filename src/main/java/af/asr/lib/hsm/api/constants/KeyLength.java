package af.asr.lib.hsm.api.constants;

public enum KeyLength {

	SINGLE_LENGTH(1), DOUBLE_LENGTH(2), TRIPPLE_LENGTH(3);

	private int length;
	
	private KeyLength(int length) {
		this.length = length;
	}
	
	public final int getLength() {
		return length;
	}
}
