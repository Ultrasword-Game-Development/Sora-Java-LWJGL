package org.petrzhang.gd;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;
import org.petrzhang.sora.sora;
import org.petrzhang.sora.graphics.Window;
import org.petrzhang.sora.graphics.utils.WindowAttrib;

import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Main().run();
    }

    public Window window;

    public void run() throws InterruptedException {
        // output the version
        System.out.println("Hello LWJGL: " + Version.getVersion() + "!");

        // start game loop
        init();
        loop();

        // end game loop + close instance
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    private void loop() throws InterruptedException {
        // this line is essential to opengl to manage anything
        GL.createCapabilities();

        Window.setClearColor(1.0f, .0f, .0f, 1.0f);

        // run rendering loop until user attempts to close
        while(!glfwWindowShouldClose(window.getWindowID())) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // clear framebuffer
            // update delta time
            sora.updateDelta();
            sora.syncFrames();

            // ======== GAME LOGIC =========== //

//            System.out.println(sora.DELTA);



            // ======= RENDER LOGIC ============ //




            // ================================= //

            glfwSwapBuffers(window.getWindowID()); // swap color buffers - new frame
            // poll for window events
            glfwPollEvents();
        }

    }

    private void init() {
        sora.start();

        window = new Window(300, 300, "OpenGL Window", 0, 0);
        window.addWindowAttrib(new WindowAttrib(GLFW_VISIBLE, GLFW_FALSE));
        window.addWindowAttrib(new WindowAttrib(GLFW_RESIZABLE, GLFW_TRUE));
        // opengl version - use version 3.3 - #version 330
        window.addWindowAttrib(new WindowAttrib(GLFW_CONTEXT_VERSION_MAJOR, 3));
        window.addWindowAttrib(new WindowAttrib(GLFW_CONTEXT_VERSION_MINOR, 3));
//        window.addWindowAttrib(new WindowAttrib(GLFW_OPENGL_DEBUG_CONTEXT, GLFW_TRUE));
        window.addWindowAttrib(new WindowAttrib(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE));


        // create the window
        window.create();

        // create key callback - lets us manage keyboard
        glfwSetKeyCallback(window.getWindowID(), (w, key, scancode, action, mods) -> {
            // lambda expression
            if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE)
                glfwSetWindowShouldClose(w, true); // we will detect this in the rendering loop
        });

        // get the thread stack + push a new frame
        try (MemoryStack stack = MemoryStack.stackPush()){
            // allocate 2 integers to the memory
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            // get the window size + pass to glfwCreateWindow -- using array instead of pointer cuz java
            glfwGetWindowSize(window.getWindowID(), pWidth, pHeight);

            // get the resolution of the primary monitor
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

            // center window
            glfwSetWindowPos(window.getWindowID(), (vidmode.width() /2 - pWidth.get(0) / 2), (vidmode.height() / 2 - pHeight.get(0) / 2));
        } // stack is popped automatically

        // make opengl context current
        glfwMakeContextCurrent(window.getWindowID());
        // enable v-sync
//        glfwSwapInterval(1);

        // show window
        glfwShowWindow(window.getWindowID());

        // end -- created settings for window, hid window, placed window in center of screen, finalized, showed window
    }


}