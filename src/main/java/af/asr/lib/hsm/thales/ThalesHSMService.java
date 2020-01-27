package af.asr.lib.hsm.thales;

import org.util.hsm.api.CVVService;
import org.util.hsm.api.HSMService;
import org.util.hsm.api.IBMService;
import org.util.hsm.api.KeyService;
import org.util.hsm.api.MACService;
import org.util.hsm.api.PVVService;
import org.util.hsm.api.ThalesService;
import org.util.hsm.api.TranslationService;

public final class ThalesHSMService implements HSMService {

	private final CVVService         cvvService         = new ThalesCVVService();
	private final IBMService         ibmService         = new ThalesIBMService(this);
	private final ThalesService      thalesService      = new ThalesServiceImpl();
	private final KeyService         keyService         = new ThalesKeyService();
	private final PVVService         pvvService         = new ThalesPVVService(this);
	private final TranslationService translationService = new ThalesTranslationService();
	private final MACService         macService         = new ThalesMACService();

	@Override
	public final String getName() {
		return "THALES";
	}

	@Override
	public final TranslationService translator() {
		return translationService;
	}

	@Override
	public final CVVService cvv() {
		return cvvService;
	}

	@Override
	public final KeyService key() {
		return keyService;
	}

	@Override
	public final ThalesService thales() {
		return thalesService;
	}

	@Override
	public final PVVService pvv() {
		return pvvService;
	}

	@Override
	public final IBMService ibm() {
		return ibmService;
	}

	@Override
	public final boolean shutdown() {
		return true;
	}

	@Override
	public final MACService mac() {
		return macService;
	}

	@Override
	public final String getResponseDescription(String code) {
		return ThalesResponseDescription.codemap.get(code);
	}

}
