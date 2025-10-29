import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TOMBOL_BANTUAN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TOMBOL_BANTUAN extends Actor
{
    public TOMBOL_BANTUAN() {
        GreenfootImage img = new GreenfootImage("Info_BTN.png");
        img.scale(60, 60);
        setImage(img);
    }
    
    
       public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            // Hentikan musik menu
            MENU menu = (MENU) getWorld();
            menu.stopBacksound();

            // Ganti dunia ke LATAR (game utama)
            Greenfoot.setWorld(new MENU_BANTUAN());
        }
    }
}
