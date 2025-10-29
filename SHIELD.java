import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SHIELD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SHIELD extends Actor
{
    private GreenfootImage[] frames = new GreenfootImage[4];
    private int frameIndex = 0;
    private int delay = 5;  // Kecepatan animasi
    private int delayCounter = 0;
    
   public SHIELD() {
        for (int i = 0; i < 4; i++) {
            frames[i] = new GreenfootImage("SHIELD(" + (i + 1) + ").png");
            frames[i].scale(100, 100);  // Sesuaikan ukuran jika perlu
        }
        setImage(frames[0]);
    }

    public void act() {
         animasi();
        // Shield selalu mengikuti player
         followPlayer();
    }

    private void followPlayer() {
    if (getWorld() == null) return;

    java.util.List<PLAYER> players = getWorld().getObjects(PLAYER.class);
    if (!players.isEmpty()) {
        PLAYER p = players.get(0);
        setLocation(p.getX(), p.getY());
    }
    }
    
     private void animasi() {
        delayCounter++;
        if (delayCounter >= delay) {
            frameIndex = (frameIndex + 1) % frames.length;
            setImage(frames[frameIndex]);
            delayCounter = 0;
        }
    }
    
    
    
}
