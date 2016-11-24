package com.nd.cashc.Utils;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * Created by ND on 11/24/2016.
 */

public class UniqueIdGenerator {

    public Long GenerateId() {

        long val = -1;

        do
        {
            UUID uuid = UUID.randomUUID();
            ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
            bb.putLong(uuid.getLeastSignificantBits());
            bb.putLong(uuid.getMostSignificantBits());

            BigInteger bi = new BigInteger(bb.array());
            val = bi.longValue();

        } while (val<0);

        return val;
    }



}
