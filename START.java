import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class START here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class START extends Actor
{
    public START() {
        GreenfootImage img = new GreenfootImage("Start_BTN.png");
        img.scale(150, 60);
        setImage(img);
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            // Hentikan musik menu
            MENU menu = (MENU) getWorld();
            menu.stopBacksound();

            // Ganti dunia ke LATAR (game utama)
            Greenfoot.setWorld(new LATAR());
        }
    }
    }
