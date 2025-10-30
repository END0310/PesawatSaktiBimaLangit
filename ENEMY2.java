import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ENEMY2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ENEMY2 extends Actor implements MUSUH, TEMBAK {
  private int shootDelay = 10;
    private GreenfootImage[] frames = new GreenfootImage[3];
    private int currentFrame = 0;
    private int counter = 0;

    public ENEMY2() {
        // Load 3 frame animasi
        for (int i = 0; i < 3; i++) {
            frames[i] = new GreenfootImage("ENEMY2(" + (i + 1) + ").png");
            frames[i].scale(40, 70);
        }
        setImage(frames[0]);
    }

    public void act() {
        if (getWorld() == null) return;

        animate();
        fall();
        tembak();

        // hapus kalau sudah di bawah
        if (getY() >= 590) {
            getWorld().removeObject(this);
        }
    }

    private void animate() {
        counter++;
        if (counter % 5 == 0) {
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
        }
    }

    private void fall() {
        setLocation(getX(), getY() + 1);
    }

    public void tembak() {
        shootDelay--;

        if (shootDelay <= 0 && getWorld() != null) {
            // batasi jumlah peluru aktif agar tidak lag
            if (getWorld().getObjects(Peluru_Monster_2.class).size() < 10) {
                getWorld().addObject(new Peluru_Monster_2(), getX(), getY() + 40);
            }
            shootDelay = Greenfoot.getRandomNumber(300) + 200;
        }
    }

    public void kenaTembak() {
        if (getWorld() == null) return;

        // 🔊 mainkan suara ledakan (acak biar gak spam)
        if (Greenfoot.getRandomNumber(3) == 0) {
            Greenfoot.playSound("explosion.wav");
        }

        // 💥 tambahkan ledakan tapi dibatasi
        if (getWorld().getObjects(Ledakan.class).size() < 5) {
            getWorld().addObject(new Ledakan(), getX(), getY());
        }

        LATAR w = (LATAR) getWorld();
        w.addScore(1);

        // 🎁 drop bonus dengan probabilitas ringan
        if (Greenfoot.getRandomNumber(100) < 2) {
            getWorld().addObject(new HP_Bonus(), getX(), getY());
        }

        if (Greenfoot.getRandomNumber(100) < 3) {
            getWorld().addObject(new Enemy_Destroy_Bonus(), getX(), getY());
        }

        if (Greenfoot.getRandomNumber(100) < 4) {
            getWorld().addObject(new Barrier_Bonus(), getX(), getY());
        }

        // hapus musuh aman
        if (getWorld() != null) {
            getWorld().removeObject(this);}
}

}
