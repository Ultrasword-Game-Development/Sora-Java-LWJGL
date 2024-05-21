package org.petrzhang.sora.system.packets;

import org.petrzhang.sora.system.signal.Signal;

public class SignalPacketPair {

    private Packet packet;
    private Signal signal;

    public SignalPacketPair(Signal s, Packet p){
        this.packet = p;
        this.signal = s;
    }

    public Packet getPacket() {
        return packet;
    }

    public Signal getSignal() {
        return signal;
    }
}
