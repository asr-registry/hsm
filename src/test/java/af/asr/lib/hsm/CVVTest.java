package af.asr.lib.hsm;

import af.asr.lib.hsm.api.HSMConfig;
import af.asr.lib.hsm.api.HSMService;
import af.asr.lib.hsm.thales.ThalesHSMService;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;


public class CVVTest {

	public static HSMConfig  hsmConfig  = new HSMConfig("127.0.0.1", 6046);
	public static HSMService hsmService = new ThalesHSMService();


	public static void main(String[] args) {
		hsmService.cvv().calculateCVV(hsmConfig, "6077990020000011", "000", "2005", "150D8C0DF3348295", "B75E6BCE8B0A1D07",  LoggerFactory.getLogger("HSM"));
		hsmService.cvv().calculateCVV(hsmConfig, "6077990020000011", "620", "2005", "150D8C0DF3348295", "B75E6BCE8B0A1D07",  LoggerFactory.getLogger("HSM"));
		hsmService.cvv().calculateCVV(hsmConfig, "6077990020000011", "999", "2005", "150D8C0DF3348295", "B75E6BCE8B0A1D07",  LoggerFactory.getLogger("HSM"));
		
		hsmService.cvv().calculateCVV(hsmConfig, "6071029990433864", "000", "2401", "150D8C0DF3348295", "B75E6BCE8B0A1D07",  LoggerFactory.getLogger("HSM"));
		hsmService.cvv().calculateCVV(hsmConfig, "6071029990433864", "620", "2401", "150D8C0DF3348295", "B75E6BCE8B0A1D07",  LoggerFactory.getLogger("HSM"));
		hsmService.cvv().calculateCVV(hsmConfig, "6071029990433864", "999", "2401", "150D8C0DF3348295", "B75E6BCE8B0A1D07",  LoggerFactory.getLogger("HSM"));
	}
}
