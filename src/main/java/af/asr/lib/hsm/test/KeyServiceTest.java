package af.asr.lib.hsm.test;

import af.asr.lib.hsm.api.HSMConfig;
import af.asr.lib.hsm.api.HSMService;
import af.asr.lib.hsm.api.constants.BDKType;
import af.asr.lib.hsm.api.constants.KeyScheme;
import af.asr.lib.hsm.api.constants.KeyScheme.ANSI;
import af.asr.lib.hsm.api.constants.KeyScheme.VARIANT;
import af.asr.lib.hsm.api.constants.KeyType;
import af.asr.lib.hsm.api.constants.MasterKeyType;
import af.asr.lib.hsm.api.model.GenKeyResponse;
import af.asr.lib.hsm.thales.ThalesHSMService;
import af.asr.lib.hsm.thales.ThalesHSMService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;

@Log4j2
public class KeyServiceTest {

	public static HSMConfig  hsmConfig  = new HSMConfig("10.100.5.21", 6046);
	public static HSMService hsmService = new ThalesHSMService();

	public static GenKeyResponse generateKeyTest() {
		return hsmService.key().generateKey(hsmConfig, KeyType.ZPK, KeyScheme.VARIANT.SINGLE_LEN, log);
	}

	public static GenKeyResponse generateExportKey() {
		return hsmService.key().generateExportKey(hsmConfig, KeyType.ZPK, VARIANT.TRIPPLE_LEN, ANSI.TRIPPLE_LEN, MasterKeyType.ZMK,
				"U7BCEFD84EB855C60CB45F036F2FA63F1",  LoggerFactory.getLogger("HSM"));
	}

	public static GenKeyResponse deriveIPEKTest() {
		return hsmService.key().deriveIPEK(hsmConfig, "110000F15CAD88F", BDKType.BDK1, "UB387DC23B416D398F17E431C3CB72B93",  LoggerFactory.getLogger("HSM"));
	}

	public static GenKeyResponse deriveExportIPEKTest() {
		return hsmService.key().deriveExportIPEK(hsmConfig, "110000F15CAD880", BDKType.BDK1, "UB387DC23B416D398F17E431C3CB72B93", MasterKeyType.ZMK,
				"U7BCEFD84EB855C60CB45F036F2FA63F1",  LoggerFactory.getLogger("HSM"));
	}

	public static GenKeyResponse importKeyTest() {
		return hsmService.key().importKey(hsmConfig, KeyType.ZPK, VARIANT.DOUBLE_LEN, "X116A0DBF3E7521D9E392D698AEB20AC6", "U869393350325267BA5CE86B9283A4291",
				 LoggerFactory.getLogger("HSM"));

	}

	public static GenKeyResponse exportKeyTest() {
		return hsmService.key().exportKey(hsmConfig, KeyType.MK_AC, "U6C58184333A1628A1EF4F0C3B9C41D37", ANSI.DOUBLE_LEN, MasterKeyType.ZMK,
				"U869393350325267BA5CE86B9283A4291",  LoggerFactory.getLogger("HSM"));

	}

	public static void main(String[] args) {
		generateKeyTest();
		generateExportKey();
		deriveIPEKTest();
		deriveExportIPEKTest();
		importKeyTest();
		exportKeyTest();
	}
}
