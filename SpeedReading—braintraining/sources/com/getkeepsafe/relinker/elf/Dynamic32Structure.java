package com.getkeepsafe.relinker.elf;

import com.getkeepsafe.relinker.elf.Elf;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Dynamic32Structure extends Elf.DynamicStructure {
    public Dynamic32Structure(ElfParser parser, Elf.Header header, long baseOffset, int index) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(header.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long baseOffset2 = baseOffset + ((long) (index * 8));
        this.tag = parser.readWord(buffer, baseOffset2);
        this.val = parser.readWord(buffer, 4 + baseOffset2);
    }
}
