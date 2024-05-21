package org.petrzhang.sora.hardware;

public abstract class HWHandler {

    protected HWHandler() {}

    public abstract void create();
    public abstract void handle();
    public abstract void clean();

}
