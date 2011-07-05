package net.sonikhak.mc.net.codec;

import net.sonikhak.mc.net.Buffer;

import java.nio.ByteBuffer;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public class HandshakeDecoder implements Decoder {
    @Override
    public int opcode() {
        return 0x02;
    }

    @Override
    public void decode(Buffer out, ByteBuffer in) {

    }
}
