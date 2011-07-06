package net.sonikhak.mc.net.codec;

import net.sonikhak.mc.net.Buffer;

import java.nio.ByteBuffer;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public interface Codec {
    public int opcode();
    public void decode(Buffer out, ByteBuffer in);
}
