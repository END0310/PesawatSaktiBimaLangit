import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LATAR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LATAR extends World
{

    private int score = 0;
    private int nyawa = 3;
    private boolean gameOver = false;
    
     // Variabel untuk background bergerak
    private GreenfootImage background;
    private int scrollY = 0; // posisi scroll vertikal
    private int scrollSpeed = 2; // kecepatan gerak background

    public LATAR() {    
        super(450, 600, 1);
        
         // Ambil gambar background dari file (ganti sesuai file kamu)
        background = new GreenfootImage("Bg1.png"); // pastikan ada di folder 'images'
        setBackground(background);

        addObject(new PLAYER(), 225, 550);

        tampilnyawa();
        tampilscore();
    }

    public void act() {
        
        if (gameOver) return;

        // Panggil fungsi untuk menggerakkan background
        scrollBackground();
        // Batasi jumlah musuh biar tidak lag
        if (getObjects(ENEMY1.class).size() + getObjects(ENEMY2.class).size() > 10) {
            return;
        }

        // Spawn musuh random
        if (Greenfoot.getRandomNumber(100) < 2) {
            addObject(new ENEMY1(), Greenfoot.getRandomNumber(getWidth()), 0);
        }

        if (Greenfoot.getRandomNumber(100) < 2) {
            addObject(new ENEMY2(), Greenfoot.getRandomNumber(getWidth()), 0);
        }
    }

    
     private void scrollBackground() {
        scrollY += scrollSpeed;
        if (scrollY >= background.getHeight()) {
            scrollY = 0;
        }

        GreenfootImage scrollingImage = new GreenfootImage(getWidth(), getHeight());
        scrollingImage.drawImage(background, 0, scrollY - background.getHeight());
        scrollingImage.drawImage(background, 0, scrollY);
        setBackground(scrollingImage);
    }
    
    
    public void addScore(int points) {
        score += points;
        tampilscore();
    }

    public void tampilscore() {
        showText("Score: " + score, 60, 20);
    }

    public void updatenyawa(int point) {
        nyawa += point;
        tampilnyawa();

        if (nyawa <= 0) { Greenfoot.stop(); showText("GAME OVER", 225, 300); }
    }

    public void tampilnyawa() {
        showText("Nyawa: " + nyawa, 400, 20);
    }
    
    public int getNyawaPemain() {
    return nyawa;
    }
    
}
