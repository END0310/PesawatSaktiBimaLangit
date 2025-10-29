import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ENEMY2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ENEMY2 extends Actor implements MUSUH, TEMBAK {

    private GreenfootImage[] frames = new GreenfootImage[3];
    private int currentFrame = 0;
    private int counter = 0;
    
    private int shootDelay = 10;

    
    public ENEMY2() {
        // Load 3 frame animasi
        for (int i = 0; i < 3; i++) {
            frames[i] = new GreenfootImage("ENEMY2(" + (i+1) + ").png");
            frames[i].scale(40, 70);
        }
        setImage(frames[0]);
    }

    public void act() {
        fall();
        tembak();
        animate();
        
        if (getY() >= 590) {
            getWorld().removeObject(this);
            return;
        }
    }
    
    private void animate() {
        counter++;
        if (counter % 5 == 0) {  // ganti frame setiap 5 act()
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
        }
    }

    private void fall() {
        setLocation(getX(), getY() + 1);
    }

    public void tembak() {
        shootDelay--;

        if (shootDelay <= 0) {
            getWorld().addObject(new Peluru_Monster_2(), getX(), getY() + 40);
            shootDelay = Greenfoot.getRandomNumber(300) + 200;
        }
    }


    public void kenaTembak() {
     if (getWorld() == null) return;  
        
        LATAR w = (LATAR)getWorld();
        w.addScore(1);
        Greenfoot.playSound("explosion.wav");// Mainkan suara ledakan
        w.addObject(new Ledakan(), getX(), getY());
          // drop bonus
    if (Greenfoot.getRandomNumber(100) < 2) {
        getWorld().addObject(new HP_Bonus(), getX(), getY());
    }
    
    // drop bonus destroy
    if (Greenfoot.getRandomNumber(100) < 5) {
        getWorld().addObject(new Enemy_Destroy_Bonus(), getX(), getY());
    }
    
    if (Greenfoot.getRandomNumber(100) < 10) {
    getWorld().addObject(new Barrier_Bonus(), getX(), getY());
    }
        
        w.removeObject(this);
    }



}
