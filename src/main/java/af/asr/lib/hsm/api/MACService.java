package af.asr.lib.hsm.api;

import af.asr.lib.hsm.api.constants.InputFormat;
import af.asr.lib.hsm.api.constants.MACAlgorithm;
import af.asr.lib.hsm.api.constants.MACKeyType;
import af.asr.lib.hsm.api.constants.MACMode;
import af.asr.lib.hsm.api.constants.MACPadding;
import af.asr.lib.hsm.api.constants.MACSize;
import af.asr.lib.hsm.api.model.MACResponse;
import org.util.nanolog.Logger;


public interface MACService {

	public abstract MACResponse calculateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                             MACKeyType macKeyType, String mkey, String iv, byte[] message, Logger logger);
	
	public abstract MACResponse validateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                            MACKeyType macKeyType, String mkey, String iv, byte[] message, String mac, Logger logger);
	
	//00131008
}
