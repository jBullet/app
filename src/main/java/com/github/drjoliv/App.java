package com.github.drjoliv;

/**
 * jBullet Application entry point.
 */
public class App {
    public static void main( String[] args ) {
      JBullet jb = JBullet.instance();
      jb.dispatch(args);
    }
}
