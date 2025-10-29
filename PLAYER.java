import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PLAYER extends Actor implements GERAK, TEMBAK {

    private int speed = 4;
    private int shootDelay = 0;
    private GreenfootSound suaraTembak = new GreenfootSound("bullet.wav");
    private boolean punyaShield = false;
    
    public PLAYER() {
        GreenfootImage img = new GreenfootImage("PLAYER.png");
        img.scale(60, 60);
        setImage(img);
    }

    public void act() {
        if (getWorld() == null) return;
        gerak();
        tembak();
        cekTabrakan();
        if (punyaShield) {
        updatePosisiShield();
        }
    }
    
    private void updatePosisiShield() {
        SHIELD shield = (SHIELD) getWorld().getObjects(SHIELD.class).get(0);
        shield.setLocation(getX(), getY());
    }  
    
 private void tabrakan(){
    if (getWorld() == null) return;
    
     int x = getX();
        int y = getY();
    // Mainkan suara ledakan
    Greenfoot.playSound("meledak.mp3");
    
    // Tampilkan animasi ledakan khusus player
    getWorld().addObject(new Ledakan_Player(), x, y);
    
    // Hapus player dari dunia
    //getWorld().removeObject(this);
    
    
    
    }
    
private void cekTabrakan() {
   
      // Tabakan dengan peluru musuh
    Actor peluru = getOneIntersectingObject(Peluru_Monster_2.class);
    if (peluru != null) {
        getWorld().removeObject(peluru);
        handleHit();
        return;
    }

    // Tabakan dengan musuh
    Actor enemy = getOneIntersectingObject(ENEMY1.class);
    if (enemy == null) enemy = getOneIntersectingObject(ENEMY2.class);

    if (enemy != null) {
        getWorld().removeObject(enemy);
        handleHit();
    }
}

private void handleHit() {
    if (punyaShield) {
        hilangkanShield();
    } else {
        ((LATAR)getWorld()).updatenyawa(-1);
        tabrakan();
    }
}

public void setShieldActive() {
     if (!punyaShield) {
        punyaShield = true;
        getWorld().addObject(new SHIELD(), getX(), getY());
    }
}

private void hilangkanShield() {
    if (punyaShield) {
        java.util.List<SHIELD> shields = getWorld().getObjects(SHIELD.class);
        for (SHIELD s : shields) {
            getWorld().removeObject(s);
        }
        punyaShield = false;
    }
}


@Override
public void gerak() {
    if (getWorld() == null) return; // Aman dari null

    int worldW = getWorld().getWidth();
    int worldH = getWorld().getHeight();

    if (Greenfoot.isKeyDown("w") && getY() > 20)
        setLocation(getX(), getY() - speed);

    if (Greenfoot.isKeyDown("s") && getY() < worldH - 20)
        setLocation(getX(), getY() + speed);

    if (Greenfoot.isKeyDown("a") && getX() > 20)
        setLocation(getX() - speed, getY());

    if (Greenfoot.isKeyDown("d") && getX() < worldW - 20)
        setLocation(getX() + speed, getY());
}

public void setShieldOff() {
    punyaShield = false;
}

public void kenaSerangan() {
    if (punyaShield) {
        hilangkanShield();
    } else {
        ((LATAR)getWorld()).updatenyawa(-1);
        tabrakan();
    }
}

    @Override
    public void tembak() {
        shootDelay--;

        if (Greenfoot.isKeyDown("space") && shootDelay <= 0) {
            getWorld().addObject(new PELURU_PLAYER(), getX(), getY() - 40);
             suaraTembak.play();
            shootDelay = 15;
        }
    }
}