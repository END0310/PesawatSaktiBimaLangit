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
        // Load 3 frame animasi (pakai try biar aman kalau file gak ketemu)
        for (int i = 0; i < 3; i++) {
            try {
                frames[i] = new GreenfootImage("ENEMY1(" + (i+1) + ").png");
                frames[i].scale(50, 80);
            } catch (IllegalArgumentException e) {
                frames[i] = new GreenfootImage(50, 80); // fallback biar gak error
            }
        }
        setImage(frames[0]);
    }

    public void act() {
        animate();   // ganti frame
        gerak();     // zigzag
        setLocation(getX(), getY() + 1); // turun

        if (getY() >= 590 && getWorld() != null) {
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
        // ? mainkan suara ledakan sekali (jangan spam)
         if (Greenfoot.getRandomNumber(3) == 0) {
            Greenfoot.playSound("explosion.wav");
        }
        
        // ? tambahkan ledakan (dibatasi 5 agar tidak berat)
        if (getWorld().getObjects(Ledakan.class).size() < 5) {
            getWorld().addObject(new Ledakan(), getX(), getY());
        }

        LATAR world = (LATAR) getWorld();
        world.addScore(1);

        // ?drop bonus dengan probabilitas
        if (Greenfoot.getRandomNumber(100) < 2) {
            getWorld().addObject(new HP_Bonus(), getX(), getY());
        }
        if (Greenfoot.getRandomNumber(100) < 3) {
            getWorld().addObject(new Enemy_Destroy_Bonus(), getX(), getY());
        }
        if (Greenfoot.getRandomNumber(100) < 5) {
            getWorld().addObject(new Barrier_Bonus(), getX(), getY());
        }

        //  hapus musuh sekali saja, setelah semuanya ditambahkan
        if (getWorld() != null) {
            getWorld().removeObject(this);}
        }

    }
