package af.asr.lib.hsm.service;

import org.util.hsm.api.constants.InputFormat;
import org.util.hsm.api.constants.MACAlgorithm;
import org.util.hsm.api.constants.MACKeyType;
import org.util.hsm.api.constants.MACMode;
import org.util.hsm.api.constants.MACPadding;
import org.util.hsm.api.constants.MACSize;
import org.util.hsm.api.model.MACResponse;
import org.util.nanolog.Logger;


public interface MACService {

	public abstract MACResponse calculateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                             MACKeyType macKeyType, String mkey, String iv, byte[] message, Logger logger);
	
	public abstract MACResponse validateMAC(HSMConfig hsmConfig, MACMode mode, InputFormat format, MACSize size, MACAlgorithm algo, MACPadding padding,
                                            MACKeyType macKeyType, String mkey, String iv, byte[] message, String mac, Logger logger);
	
	//00131008
}
