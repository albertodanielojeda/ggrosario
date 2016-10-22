package com.herokuapp.ggrosario.background.tomcat;

import java.util.Date;

/**
 *
 * @author Ojeda Alberto Daniel
 */
public class EverySecond implements Runnable {

    @Override
    public void run() {
        System.out.println("Testing background task on Tomcat at " + new Date().toString());
    }

}
