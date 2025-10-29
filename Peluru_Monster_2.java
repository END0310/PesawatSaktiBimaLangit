import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Peluru_Monster_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peluru_Monster_2 extends Actor
{
 private int speed = 3;

    public Peluru_Monster_2() {
        GreenfootImage img = new GreenfootImage("Peluru_Monster_2.png");
        img.scale(20, 40);
        setImage(img);
    }

    public void act() {
        World w = getWorld();
        if (w == null) return; // Aman jika peluru sudah dihapus

        // Gerak ke bawah
        setLocation(getX(), getY() + speed);

        // Hapus jika keluar layar
        if (getY() >= 590) {
            if (getWorld() != null) getWorld().removeObject(this);
            return;
        }

         // ✅ Shield dicek lebih dulu
        Actor shield = getOneIntersectingObject(SHIELD.class);
        if (shield != null) {
            // Hapus shield
            w.removeObject(shield);

            // Beri tahu player shield hilang
            PLAYER player = (PLAYER) w.getObjects(PLAYER.class).get(0);
            player.setShieldOff();

            // Hapus peluru
            w.removeObject(this);
            return;
        }

        // ✅ Baru cek tabrakan dengan Player
        Actor player = getOneIntersectingObject(PLAYER.class);
        if (player != null) {
            PLAYER p = (PLAYER)player;
            p.kenaSerangan();

            w.removeObject(this);
            return;
        }

        // Tetap bisa tabrak peluru player
        Actor peluruPlayer = getOneIntersectingObject(PELURU_PLAYER.class);
        if (peluruPlayer != null) {
            w.removeObject(peluruPlayer);
            w.removeObject(this);
        }
    }
}

