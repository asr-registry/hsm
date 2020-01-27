package af.asr.lib.hsm.test;

import af.asr.lib.hsm.api.HSMConfig;
import af.asr.lib.hsm.api.HSMService;
import org.util.hsm.thales.ThalesHSMService;
import org.util.nanolog.Logger;

public class CVVTest {

	public static HSMConfig  hsmConfig  = new HSMConfig("10.100.5.21", 6046);
	public static HSMService hsmService = new ThalesHSMService();

	public static void main(String[] args) {
		hsmService.cvv().calculateCVV(hsmConfig, "6077990020000011", "000", "2005", "150D8C0DF3348295", "B75E6BCE8B0A1D07", Logger.CONSOLE);
		hsmService.cvv().calculateCVV(hsmConfig, "6077990020000011", "620", "2005", "150D8C0DF3348295", "B75E6BCE8B0A1D07", Logger.CONSOLE);
		hsmService.cvv().calculateCVV(hsmConfig, "6077990020000011", "999", "2005", "150D8C0DF3348295", "B75E6BCE8B0A1D07", Logger.CONSOLE);
		
		hsmService.cvv().calculateCVV(hsmConfig, "6071029990433864", "000", "2401", "150D8C0DF3348295", "B75E6BCE8B0A1D07", Logger.CONSOLE);
		hsmService.cvv().calculateCVV(hsmConfig, "6071029990433864", "620", "2401", "150D8C0DF3348295", "B75E6BCE8B0A1D07", Logger.CONSOLE);
		hsmService.cvv().calculateCVV(hsmConfig, "6071029990433864", "999", "2401", "150D8C0DF3348295", "B75E6BCE8B0A1D07", Logger.CONSOLE);
	}
}
