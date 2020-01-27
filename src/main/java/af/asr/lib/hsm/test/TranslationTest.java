package af.asr.lib.hsm.test;

import java.io.IOException;
import java.net.UnknownHostException;

import af.asr.lib.hsm.api.HSMConfig;
import af.asr.lib.hsm.api.HSMService;
import af.asr.lib.hsm.api.constants.PinBlockFormat;
import af.asr.lib.hsm.thales.ThalesHSMService;
import org.slf4j.Logger;

public class TranslationTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		HSMConfig  hsmConfig  = new HSMConfig("10.100.5.21", 6046);
		HSMService hsmService = new ThalesHSMService();
		hsmService.translator().fromZPKToZPK(hsmConfig, "368320008173", "B58ADECA2C972098", PinBlockFormat.ISOFORMAT0, "UB27EC3FAB16D5D4D0DFCC5C3246776E3",
				PinBlockFormat.ISOFORMAT0, "U401770057601955CD7797A450474C4E1",  LoggerFactory.getLogger("HSM"));
	}
}
