package org.petrzhang.sora.system.signal;

import org.petrzhang.sora.system.packets.Packet;

public abstract class Signal {

    private static long signalIDCount = 0;
    protected final long signalID;

    public Signal(){
        signalID = signalIDCount ++;
    }

    public abstract <T extends Packet> void handle(T packet);

    // ---------------------------- //

}
