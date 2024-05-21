package org.petrzhang.gd;

public class Test {


    static int array[] = new int[100];
    static int counter = 0;
    static int limit = 5;

    public static void main(String[] args){


        array[0] = 1;
        array[1] = 2;

        for(counter = 0; counter < limit; counter++){
            output(counter);
            if(counter == 1) addItem(5, 222);
        }
    }

    static void output(int i){
        System.out.println("Value at: " + i + " | = " + array[i]);
    }

    static void addItem(int i , int value){
        array[i] = value;
        limit ++;
    }

}
