package org.petrzhang.sora.hardware.utils;

import org.petrzhang.sora.system.signal.Signal;
import org.petrzhang.sora.system.signal.SignalHandler;

public class KeyBind {

    private int scanKey;
    private Signal toggleSignal;

    public KeyBind(int scanKey, Signal toggleSignal){
        this.scanKey = scanKey;
        this.toggleSignal = toggleSignal;
    }

    public void activateKeyBind(){
        // actiavte the keybind
//        SignalHandler.emitSignal(this.toggleSignal, new KeyBindPacket(this));
        System.out.println("Not Implemented YET: KeyBinds");
    }

    public int getScanKey() {
        return scanKey;
    }

    public Signal getToggleSignal() {
        return toggleSignal;
    }
}
