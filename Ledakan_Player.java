import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PLAYER_MATI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Ledakan_Player extends Actor {
    private GreenfootImage[] frames;
    private int frameIndex = 0;
    private int delay = 4;
    private int counter = 0;

    public Ledakan_Player() {
        frames = new GreenfootImage[3];
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new GreenfootImage("PLAYER_MATI" + (i + 1) + ".png");
            frames[i].scale(80, 80);
        }
        setImage(frames[0]);
    }

    public void act() {
        counter++;
        if (counter % delay == 0) {
            frameIndex++;
            if (frameIndex < frames.length) {
                setImage(frames[frameIndex]);
            } else {
                getWorld().removeObject(this);
            }
        }
    }
}
