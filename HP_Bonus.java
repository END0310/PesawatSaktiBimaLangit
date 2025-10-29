import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HP_Bonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HP_Bonus extends Actor
{
       public HP_Bonus () {
        GreenfootImage img = new GreenfootImage("HP_Bonus.png"); 
        img.scale(40,40); // ubah ukuran sesuai kebutuhan
        setImage(img);
    }

    
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
            LATAR world = (LATAR)getWorld();
            world.updatenyawa(1);

            Greenfoot.playSound("bonus.mp3"); // Tambahkan suara jika kamu punya
            getWorld().removeObject(this);
        }
    }
}
