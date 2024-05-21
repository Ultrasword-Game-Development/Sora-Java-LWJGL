package org.petrzhang.sora.system.signal;

import org.petrzhang.sora.system.packets.Packet;
import org.petrzhang.sora.system.packets.SignalPacketPair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class SignalHandler {

    private SignalHandler() {}

    // ---------------------------- //

    public static final int bufferSize = 100;
    public static int bufferCounter = 0;

    public static SignalPacketPair signalBuffer[] = new SignalPacketPair[bufferSize];

    public static HashMap<Long, Signal> signalMap = new HashMap<>();

    // ---------------------------- //

    public static void registerSignal(){

        // iterate through buffer objects
        SignalPacketPair pair;
        for (int i = 0; i < bufferCounter; i++){
            pair = signalBuffer[i];
            // set the emit signal
            pair.getSignal().handle(pair.getPacket());
        }
        bufferCounter = 0;
    }

    public static <T extends Packet> void emitSignal(Signal signal, T packet){
        signalBuffer[bufferCounter] = new SignalPacketPair(signal, packet);
        bufferCounter++;
    }

    // ---------------------------- //

    public static void clearBuffer(){
        Arrays.fill(signalBuffer, null);

    }



}
