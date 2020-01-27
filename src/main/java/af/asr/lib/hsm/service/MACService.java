package af.asr.lib.hsm.service;

import af.asr.lib.hsm.constants.*;
import af.asr.lib.hsm.model.HSMResponse;
import af.asr.lib.hsm.model.MACResponse;

import java.util.logging.Logger;



public interface MACService {

	public abstract MACResponse calculateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
											 MACKeyType macKeyType, String mkey, String iv, byte[] message, Logger logger);
	
	public abstract MACResponse validateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                            MACKeyType macKeyType, String mkey, String iv, byte[] message, String mac, Logger logger);
	
	//00131008
}
