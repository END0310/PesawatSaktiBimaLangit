import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PLAYER_MATI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Ledakan extends Actor {
    private GreenfootImage[] frames;
    private int currentFrame = 0;
    private int counter = 0;
    private int delay = 5; // sama gaya animasi ENEMY2 (ganti frame tiap 5 act)

    public Ledakan() {
        // jumlah frame ledakan — samakan dengan yang kamu punya (ubah jika perlu)
        int nFrames = 3;

        frames = new GreenfootImage[nFrames];

        for (int i = 0; i < nFrames; i++) {
            GreenfootImage img = null;
            // mencoba dua pola nama file umum: "ENEMY_MATI(1).png" atau "ENEMY_MATI1.png"
            try {
                img = new GreenfootImage("ENEMY_MATI(" + (i+1) + ").png");
            } catch (IllegalArgumentException e1) {
                try {
                    img = new GreenfootImage("ENEMY_MATI" + (i+1) + ".png");
                } catch (IllegalArgumentException e2) {
                    img = null;
                }
            }

            if (img != null) {
                // skala disamakan dengan ENEMY2 agar proporsional
                img.scale(40, 70);
                frames[i] = img;
            } else {
                // fallback: buat image kosong agar tidak NullPointer (warna transparan)
                GreenfootImage fallback = new GreenfootImage(40, 70);
                // Optional: beri sedikit warna supaya kelihatan saat debug
                // fallback.setColor(Color.RED); fallback.fill();
                frames[i] = fallback;
            }
        }

        setImage(frames[0]);
    }

    public void act() {
        counter++;
        if (counter % delay == 0) {
            currentFrame++;
            if (currentFrame < frames.length) {
                setImage(frames[currentFrame]);
            } else {
                // selesai animasi -> hapus objek ledakan
                if (getWorld() != null) {
                    getWorld().removeObject(this);
                }
            }
        }
    }
}

