package af.asr.lib.hsm.service;

import af.asr.lib.hsm.constants.InputFormat;
import af.asr.lib.hsm.constants.MACAlgorithm;
import af.asr.lib.hsm.constants.MACKeyType;
import af.asr.lib.hsm.constants.MACMode;
import af.asr.lib.hsm.constants.MACPadding;
import af.asr.lib.hsm.constants.MACSize;
import af.asr.lib.hsm.model.MACResponse;
import org.slf4j.Logger;


public interface MACService {

	public abstract MACResponse calculateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                             MACKeyType macKeyType, String mkey, String iv, byte[] message, Logger logger);
	
	public abstract MACResponse validateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                            MACKeyType macKeyType, String mkey, String iv, byte[] message, String mac, Logger logger);
	
	//00131008
}
