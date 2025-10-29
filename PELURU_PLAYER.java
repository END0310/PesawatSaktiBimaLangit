import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PELURU_PLAYER here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PELURU_PLAYER extends Actor
{
   private int speed = 6;

    public PELURU_PLAYER() {
        GreenfootImage img = new GreenfootImage("PELURU_PLAYER.png");
        img.scale(20, 40);
        setImage(img);
    }

    public void act() {
        if (getWorld() == null) return;

        setLocation(getX(), getY() - speed);

        if (getY() <= 0) {
            getWorld().removeObject(this);
            return;
        }

    Actor enemy = getOneIntersectingObject(ENEMY1.class);
if (enemy == null) enemy = getOneIntersectingObject(ENEMY2.class);

if (enemy != null) {
    if (enemy instanceof ENEMY1) {
        ((ENEMY1)enemy).kenaTembak();
    } else if (enemy instanceof ENEMY2) {
        ((ENEMY2)enemy).kenaTembak();
    }

    if (getWorld() != null) {
        getWorld().removeObject(this); // hapus peluru
        }

}
}
}
