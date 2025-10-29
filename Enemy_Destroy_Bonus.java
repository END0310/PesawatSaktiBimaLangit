import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy_Destroy_Bonus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy_Destroy_Bonus extends Actor
{
     public Enemy_Destroy_Bonus () {
        GreenfootImage img = new GreenfootImage("Enemy_Destroy_Bonus.png"); 
        img.scale(40,40); // ubah ukuran sesuai kebutuhan
        setImage(img);
    }

    
    
     public void act() {
        setLocation(getX(), getY() + 2);

        if (getY() >= 590) {
            getWorld().removeObject(this);
            return;}
        cekAmbilPlayer();
    }

    private void cekAmbilPlayer() {
         Actor player = getOneIntersectingObject(PLAYER.class);
    if (player != null) {
        LATAR world = (LATAR)getWorld();

        // Ambil semua musuh yang ada di dunia
        java.util.List<ENEMY1> enemy1List = world.getObjects(ENEMY1.class);
        java.util.List<ENEMY2> enemy2List = world.getObjects(ENEMY2.class);

        int jumlahMusuh = enemy1List.size() + enemy2List.size();

        // Tambah score
        world.addScore(jumlahMusuh);

          // Ledakan ENEMY1
        for (ENEMY1 e : enemy1List) {
            Greenfoot.playSound("explosion.wav"); // ✅ suara ledakan per musuh
            world.addObject(new Ledakan(), e.getX(), e.getY());
        }

        // Ledakan ENEMY2
        for (ENEMY2 e : enemy2List) {
            Greenfoot.playSound("explosion.wav"); // ✅ suara ledakan per musuh
            world.addObject(new Ledakan(), e.getX(), e.getY());
        }

        // Hapus semua musuh setelah animasi dibuat
        world.removeObjects(enemy1List);
        world.removeObjects(enemy2List);

        // (opsional jika ada) Suara khusus
         //Greenfoot.playSound("bonus.wav");

        // Hapus bonus setelah digunakan
        getWorld().removeObject(this);
    }
}
}
