import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TOMBOL_KEMBALI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TOMBOL_KEMBALI extends Actor
{
     public TOMBOL_KEMBALI() {
        GreenfootImage img = new GreenfootImage("KEMBALI.png");
        img.scale(60, 60);
        setImage(img);
    }
    
    
    public void act()
    {
        
        
    
        if(Greenfoot.mousePressed(this)) {
            getImage().scale((int)Math.round(getImage().getWidth()*0.9),
                             (int)Math.round(getImage().getHeight()*0.9));
            Greenfoot.delay(5);
            Greenfoot.setWorld(new MENU_UTAMA());
        }
    }
}
