package af.asr.lib.hsm.api.constants;

public enum MACAlgorithm {

	ISO9797MAC_ALG1("1"), ISO9797MAC_ALG3("3");

	private final String algo;

	private MACAlgorithm(final String algo) {
		this.algo = algo;
	}

	public final String toString() {
		return algo;
	}

}
