package af.asr.lib.hsm.safenet;

import af.asr.lib.hsm.service.*;
import af.asr.lib.hsm.service.HSMService;
import af.asr.lib.hsm.service.KeyService;

public final class SafeNetHSMService implements HSMService {

	private final KeyService keyService = new SafenetKeyService();

	@Override
	public String getName() {
		return "SAFENET";
	}

	@Override
	public final TranslationService translator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final CVVService cvv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final KeyService key() {
		return keyService;
	}

	@Override
	public final ThalesService thales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final PVVService pvv() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final IBMService ibm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean shutdown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final MACService mac() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final String getResponseDescription(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
