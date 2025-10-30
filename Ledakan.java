import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PLAYER_MATI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Ledakan extends Actor {
     private static GreenfootImage[] frames; // static = hanya satu copy untuk semua ledakan
    private int currentFrame = 0;
    private int counter = 0;
    private int delay = 5;

    public Ledakan() {
        // Hanya load sekali
        if (frames == null) {
            int nFrames = 3;
            frames = new GreenfootImage[nFrames];
            for (int i = 0; i < nFrames; i++) {
                GreenfootImage img;
                try {
                    img = new GreenfootImage("ENEMY_MATI(" + (i+1) + ").png");
                } catch (IllegalArgumentException e1) {
                    img = new GreenfootImage("ENEMY_MATI" + (i+1) + ".png");
                }
                img.scale(40, 70);
                frames[i] = img;
            }
        }
        setImage(frames[0]);
    }

    public void act() {
        counter++;
        if (counter % delay == 0) {
            currentFrame++;
            if (currentFrame < frames.length) {
                setImage(frames[currentFrame]);
            } else {
                getWorld().removeObject(this);
            }
 }

}
}


