package af.asr.lib.hsm.service;

import org.util.hsm.api.constants.KSNDescriptor;
import org.util.hsm.api.constants.PinBlockFormat;
import org.util.hsm.api.constants.PinKeyType;
import org.util.hsm.api.model.HSMResponse;
import org.util.nanolog.Logger;

public interface IBMService {

	public abstract HSMResponse calculateOffsetUsingPin(final HSMConfig hsmConfig, final String pan12, final String pin, final String valdata, final String pvk,
                                                        final Logger logger);

	public abstract HSMResponse calculateOffsetUsingPinLMK(final HSMConfig hsmConfig, final String pan12, final String pinlmk, final String valdata,
                                                           final String pvk, final Logger logger);

	public abstract HSMResponse calculateOffsetUsingPinBlock(final HSMConfig hsmConfig, final String pan12, final String valdata, final String pinblock,
                                                             final PinBlockFormat format, final PinKeyType pinKeyType, final String pinKey, final String pvk, final Logger logger);

	public abstract HSMResponse changePinOffset(final HSMConfig hsmConfig, final String pan12, final String valdata, final String pinblock,
                                                final PinBlockFormat format, final String offset, final PinKeyType pinKeyType, final String pinKey, final String newPinblock, final String pvk,
                                                final Logger logger);

	public abstract HSMResponse validateTerminalPin(final HSMConfig hsmConfig, final String pan12, final String valdata, final String pinblock,
                                                    final PinBlockFormat format, final String offset, final String pvk, final String tpk, final Logger logger);

	public abstract HSMResponse validateInterchangePin(final HSMConfig hsmConfig, final String pan12, final String valdata, final String pinblock,
                                                       final PinBlockFormat format, final String offset, final String pvk, final String zpk, final Logger logger);

	public abstract HSMResponse validateDUKPTPin(final HSMConfig hsmConfig, final String pan12, final String valdata, final String pinblock,
                                                 final PinBlockFormat format, final String offset, final String ksn, final KSNDescriptor descriptor, final String pvk, final String bdk,
                                                 final Logger logger);

}
