import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Replay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Replay extends Actor
{
    /**
     * Act - do whatever the Replay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public Replay() {
        // ✅ tampilkan tombol
        GreenfootImage img = new GreenfootImage("Replay_BTN.png");
        img.scale(60, 60);
        setImage(img);
    }

    public void act() {
        // ✅ deteksi klik
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new LATAR()); // ulang game dari awal
        }
    }
}
