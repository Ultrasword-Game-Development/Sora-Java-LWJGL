package org.petrzhang.sora.hardware;

import org.petrzhang.sora.graphics.Window;
import org.petrzhang.sora.hardware.utils.KeyBind;

import java.util.HashMap;

import static org.lwjgl.glfw.GLFW.*;

public class InputHandler extends HWHandler {

    private Window window;
    private boolean keyInputs[];

    // key binds section
    private HashMap<Integer, KeyBind> keyBinds;

    public InputHandler(Window window){
        this.window = window;
        this.keyBinds = new HashMap<>();
        this.keyInputs = new boolean[65545];

        create();
    }

    private void keyCallback(long wID, int key, int scancode, int action, int mods){
        // add the key press to the key press buffer
        if (action == GLFW_PRESS){
            keyInputs[key] = true;
        }else if(action == GLFW_RELEASE) {
            keyInputs[key] = false;
        }

        // add in key binds
        if (keyBinds.containsKey(key)){
            keyBinds.get(key).activateKeyBind();
        }
    }

    public void addKeyBind(KeyBind keyBind){
        this.keyBinds.put(keyBind.getScanKey(), keyBind);
    }

    // ---------------------------- //

    @Override
    public void create() {
        // set the key callback
        glfwSetKeyCallback(this.window.getWindowID(), this::keyCallback);

    }

    @Override
    public void handle() {

    }

    @Override
    public void clean() {

    }
}
