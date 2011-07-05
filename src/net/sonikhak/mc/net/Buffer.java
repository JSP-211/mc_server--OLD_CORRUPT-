package net.sonikhak.mc.net;

import java.nio.ByteBuffer;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public class Buffer {
    private int opcode;
    private ByteBuffer buffer;

    public Buffer(int opcode) {
        this.opcode = opcode;
        buffer = ByteBuffer.allocate(1000); //Will fix this when i find a more appropriate size!
    }

    public int getOpcode() {
        return opcode;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }
}
