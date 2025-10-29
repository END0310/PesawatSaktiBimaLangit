import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ENEMY1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ENEMY1 extends Actor implements MUSUH,GERAK {
    private int speedX = 1;  
    private int speedY = 1;

    private GreenfootImage[] frames = new GreenfootImage[3];
    private int currentFrame = 0;
    private int counter = 0;

    public ENEMY1() {
        // Load 3 frame animasi
        for (int i = 0; i < 3; i++) {
            frames[i] = new GreenfootImage("ENEMY1(" + (i+1) + ").png");
            frames[i].scale(50, 80);
        }
        setImage(frames[0]);
    }

    public void act() {
         if (getWorld() == null) return; 
        
        animate();   // ganti frame
        gerak();     // zigzag
        setLocation(getX(), getY() + 1); // turun

        if (getY() >= 590) {
            getWorld().removeObject(this);
        }
    }

    private void animate() {
        counter++;
        if (counter % 5 == 0) {  // ganti frame setiap 5 act()
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
        }
    }

    @Override
    public void gerak() {
        if (getWorld() == null) return;
        setLocation(getX() + speedX, getY() + speedY);

        if (getX() <= 5 || getX() >= getWorld().getWidth() - 5) {
            speedX = -speedX;
        }
    }

    public void kenaTembak() {
        if (getWorld() == null) return;
        
        LATAR world = (LATAR) getWorld();
        Greenfoot.playSound("explosion.wav");
        
        getWorld().addObject(new Ledakan(), getX(), getY());
        world.addScore(1);
        
         // drop bonus
    if (Greenfoot.getRandomNumber(100) < 2) {
        getWorld().addObject(new HP_Bonus(), getX(), getY());
    }
    
    // drop bonus destroy
    if (Greenfoot.getRandomNumber(100) < 3) {
        getWorld().addObject(new Enemy_Destroy_Bonus(), getX(), getY());
    }
    
    if (Greenfoot.getRandomNumber(100) < 5) {
    getWorld().addObject(new Barrier_Bonus(), getX(), getY());
    }

    world.removeObject(this);
    }
}
