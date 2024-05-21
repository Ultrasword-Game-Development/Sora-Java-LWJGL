package org.petrzhang.sora;

import org.lwjgl.glfw.GLFWErrorCallback;

import static org.lwjgl.glfw.GLFW.glfwInit;

public class sora {

    private sora() {}

    // ---------------------------- //

    private static java.io.PrintStream errorCallbackChannel = System.err;

    public static void start(){
        // init GLFW error callback
        GLFWErrorCallback.createPrint(errorCallbackChannel).set();

        // initialize glfw
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // start clock
        START = getTimeMilliseconds();
    }



    // ---------------------------- //
    // time related things

    public static int FPS = 60;
    public static float DELTA = 0.1f;
    public static long START = 0;
    public static float desiredDelta = 1.0f / (float)FPS;

    public static long getTimeMilliseconds(){
        return System.currentTimeMillis();
    }

    public static void updateDelta(){
        DELTA = (float)(getTimeMilliseconds() - START) / 1000.0f;
        START = getTimeMilliseconds();
    }

    public static void syncFrames() throws InterruptedException {
        if(DELTA < desiredDelta) {
            Thread.sleep((long) ((desiredDelta - DELTA) * 1000));
            DELTA = desiredDelta;
        }
    }

    public static void setFPS(int fps){
        FPS = fps;
        desiredDelta = 1.0f / (float)FPS;
    }


    // ---------------------------- //




    // ---------------------------- //




    // ---------------------------- //

}
