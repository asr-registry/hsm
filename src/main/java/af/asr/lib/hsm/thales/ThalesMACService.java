package af.asr.lib.hsm.thales;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import af.asr.lib.hsm.api.HSMConfig;
import af.asr.lib.hsm.api.ThalesHSMConnect;
import af.asr.lib.hsm.api.HSMService;
import af.asr.lib.hsm.api.MACService;
import af.asr.lib.hsm.api.constants.InputFormat;
import af.asr.lib.hsm.api.constants.MACAlgorithm;
import af.asr.lib.hsm.api.constants.MACKeyType;
import af.asr.lib.hsm.api.constants.MACMode;
import af.asr.lib.hsm.api.constants.MACPadding;
import af.asr.lib.hsm.api.constants.MACSize;
import af.asr.lib.hsm.api.model.MACResponse;
import org.util.nanolog.Logger;

public final class ThalesMACService implements MACService {

	//@formatter:off
	@Override
	public final MACResponse calculateMAC(final HSMConfig hsmConfig, final MACMode mode, final InputFormat format, final MACSize size, final MACAlgorithm algo,
			final MACPadding padding, final MACKeyType macKeyType, final String mkey, final String iv, final byte[] message, final Logger logger) {
		try {
			final ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bos.write(new byte[2]);
			bos.write(toByteArray("0000M6"));
			bos.write(toByteArray(mode));
			bos.write(toByteArray(format));
			bos.write(toByteArray(size));
			bos.write(toByteArray(algo));
			bos.write(toByteArray(padding));
			bos.write(toByteArray(macKeyType));
			bos.write(toByteArray(mkey));
			if(mode == MACMode.FINAL_BLOCK_OF_MULTI_BLOCK_MESSAGE || mode == MACMode.MIDDLE_BLOCK_OF_MULTI_BLOCK_MESSAGE) bos.write(toByteArray(iv));
			bos.write(toByteArray(String.format("%04X", message.length)));
			bos.write(message);
			final byte[]      response    = ThalesHSMConnect.send(hsmConfig, bos.toByteArray(), logger);
			final MACResponse hsmResponse = new MACResponse(new String(new byte[] {response[6], response[7]}, StandardCharsets.US_ASCII));
			if (hsmResponse.isSuccess) { 
				if(mode == MACMode.FIRST_BLOCK_OF_MULTI_BLOCK_MESSAGE || mode == MACMode.MIDDLE_BLOCK_OF_MULTI_BLOCK_MESSAGE) {
					hsmResponse.iv 	= new String(Arrays.copyOfRange(response, 8, 24), StandardCharsets.US_ASCII); 
					hsmResponse.mac = new String(Arrays.copyOfRange(response, 24, response.length), StandardCharsets.US_ASCII); 
				}
				hsmResponse.mac = new String(Arrays.copyOfRange(response, 8, response.length), StandardCharsets.US_ASCII); 
			}
			return hsmResponse;
		} catch (Exception e) {logger.error(e);}
		return MACResponse.IO;
	}
	
	@Override
	public MACResponse validateMAC(final HSMConfig hsmConfig, final MACMode mode, final InputFormat format, final MACSize size, final MACAlgorithm algo,
			final MACPadding padding, final MACKeyType macKeyType, final String mkey, final String iv, final byte[] message, final String mac, final Logger logger) {
		try {
			final ByteArrayOutputStream bos = new ByteArrayOutputStream();
			bos.write(new byte[2]);
			bos.write(toByteArray("0000M8"));
			bos.write(toByteArray(mode));
			bos.write(toByteArray(format));
			bos.write(toByteArray(size));
			bos.write(toByteArray(algo));
			bos.write(toByteArray(padding));
			bos.write(toByteArray(macKeyType));
			bos.write(toByteArray(mkey));
			if((mode == MACMode.FINAL_BLOCK_OF_MULTI_BLOCK_MESSAGE || mode == MACMode.MIDDLE_BLOCK_OF_MULTI_BLOCK_MESSAGE) && iv != null) bos.write(toByteArray(iv));
			bos.write(toByteArray(String.format("%04X", message.length)));
			bos.write(message);
			bos.write(toByteArray(mac));
			final byte[] response = ThalesHSMConnect.send(hsmConfig, bos.toByteArray(), logger);
			final MACResponse hsmResponse = new MACResponse(new String(new byte[] {response[6], response[7]}, StandardCharsets.US_ASCII));
			if (hsmResponse.isSuccess) { 
				if(mode == MACMode.FIRST_BLOCK_OF_MULTI_BLOCK_MESSAGE || mode == MACMode.MIDDLE_BLOCK_OF_MULTI_BLOCK_MESSAGE) {
					hsmResponse.iv 	= new String(Arrays.copyOfRange(response, 8, response.length), StandardCharsets.US_ASCII); 
				}
			}
			return hsmResponse;
		}  catch (Exception e) {logger.error(e);}
		return MACResponse.IO;
	}

	private static final byte[] toByteArray(final Object enumz) {
		if (enumz == null) return new byte[0];
		return enumz.toString().getBytes(StandardCharsets.US_ASCII);
	}

	public static final String generateMAC(final HSMConfig hsmConfig, String MAB) {
		try {
			StringBuilder sb = new StringBuilder().append("0000M600131008").append("U618CB48CB618CE08AE03CF28E2872907");
			String length = String.format("%04X", MAB.length());
			sb.append(length).append(MAB);
			String response = ThalesHSMConnect.send(hsmConfig, sb.toString(), Logger.CONSOLE);
			return response.substring(8);
		} catch (Exception e) {e.printStackTrace();}
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		HSMService service = HSMService.getService("THALES");
		HSMConfig hsmConfig = HSMConfig.newBuilder("10.100.5.21", 6046).build();
		generateMAC(hsmConfig, "ABCD");
		MACResponse response = service.mac().calculateMAC(hsmConfig, MACMode.ONLY_BLOCK_OF_SINGLE_BLOCK_MESSAGE, InputFormat.BINARY, MACSize.SIXTEEN_HEX_DIGITS, 
				MACAlgorithm.ISO9797MAC_ALG3, MACPadding.ISO9797_PADDING1, MACKeyType.ZAC, "U618CB48CB618CE08AE03CF28E2872907", null, "ABCD".getBytes(), Logger.CONSOLE);
		System.out.println(response);
		
		response = service.mac().validateMAC(hsmConfig, MACMode.ONLY_BLOCK_OF_SINGLE_BLOCK_MESSAGE, InputFormat.BINARY, MACSize.SIXTEEN_HEX_DIGITS, 
				MACAlgorithm.ISO9797MAC_ALG3, MACPadding.ISO9797_PADDING1, MACKeyType.ZAC, "U618CB48CB618CE08AE03CF28E2872907", null, "ABCD".getBytes(), "DD7D1402442073F7",  Logger.CONSOLE);
		System.out.println(response);
	}
}
