package org.petrzhang.sora.graphics;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.petrzhang.sora.graphics.utils.WindowAttrib;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    // ---------------------------- //
    // core functions

    private long windowID;
    private int width;
    private int height;
    private String title;
    private long monitor;
    private long share;

    List<WindowAttrib> windowAttribList;

    public Window(int width, int height, String title, long monitor, long share){
        this.width = width;
        this.height = height;
        this.title = title;
        this.monitor = monitor;
        this.share = share;

        this.windowAttribList = new ArrayList<>();
    }

    // add custom window attributes
    public void addWindowAttrib(WindowAttrib attrib){
        this.windowAttribList.add(attrib);
    }



    // create the window
    public void create(){
        // set window creation hints (glfw should already be active
        glfwDefaultWindowHints();
        for(WindowAttrib wa : this.windowAttribList){
            glfwWindowHint(wa.getKey(), wa.getValue());
        }

        // create the window
        windowID = glfwCreateWindow(this.width, this.height, this.title, this.monitor, this.share);
        if (windowID == 0){
            throw new RuntimeException("Failed to create the GLFW Window!");
        }
    }

    // close the window
    public void close(){
        GLFW.glfwWindowShouldClose(this.windowID);
    }

    // ---------------------------- //
    // util functions

    public long getWindowID(){
        return this.windowID;
    }

    // ---------------------------- //
    // static functions

    private static float clearColor[] = {.0f, .0f, .0f, .0f};

    // change clear color
    public static void setClearColor(float r, float g, float b, float a){
        clearColor[0] = r;
        clearColor[1] = g;
        clearColor[2] = b;
        clearColor[3] = a;
        GL11.glClearColor(clearColor[0], clearColor[1], clearColor[2], clearColor[3]);
    }


}
