package net.sonikhak.mc.net.codec;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public class CodecStore {
    public static Map<String, Decoder> decoderMap = new HashMap<String, Decoder>();

    static {
        decoderMap.put("handshake", new HandshakeDecoder());
    }
}
