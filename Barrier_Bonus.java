import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier_Bonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier_Bonus extends Actor
{
       public Barrier_Bonus () {
        GreenfootImage img = new GreenfootImage("Barrier_Bonus.png"); 
        img.scale(40,40); // ubah ukuran sesuai kebutuhan
        setImage(img);
    }

    
    /**
     * Act - do whatever the Barrier_Bonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() {
        setLocation(getX(), getY() + 2);

        if (getY() >= 590) {
            getWorld().removeObject(this);
            return;}

        cekTabrakPlayer();
    }

    private void cekTabrakPlayer() {
     Actor player = getOneIntersectingObject(PLAYER.class);

    if (player != null) {
        PLAYER p = (PLAYER) player;

        // Aktifkan shield di player
        p.setShieldActive();

        // Tampilkan objek shield visual
        getWorld().addObject(new SHIELD(), p.getX(), p.getY());

        
        Greenfoot.playSound("bonus.mp3");
        // Hapus bonus ini
        getWorld().removeObject(this);
        }   
    }
}
