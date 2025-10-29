import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MENU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MENU extends World
{
   // Jangan dikomentari, karena ini digunakan untuk musik
    private GreenfootSound backsound = new GreenfootSound("BACKSOUND.mp3");
    
    public MENU()
    {     
        super(450, 600, 1); 

        // Atur background agar sesuai ukuran dunia
        GreenfootImage bg = new GreenfootImage("MENU_UTAMA.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        // Putar musik latar menu utama
        backsound.playLoop();

        
        if(this.getClass().getName().equalsIgnoreCase("MENU_UTAMA"))
        {
            START mulai = new START();
            addObject(mulai, getWidth() / 2, 400);
            TOMBOL_BANTUAN bantu = new TOMBOL_BANTUAN ();
            addObject(bantu, getWidth() / 2, 500);
        }else{
            
            addObject(new TOMBOL_KEMBALI(),50,50);
        }
        // Tambahkan tombol-tombol
        //addTombol();
    }

    /** Menambahkan tombol-tombol utama ke menu **/
    //private void addTombol() {
        // Tombol mulai
      //  START mulai = new START();
       // addObject(mulai, getWidth() / 2, 400);

        // Tombol bantuan
       // TOMBOL_BANTUAN bantuan = new TOMBOL_BANTUAN();
       // addObject(bantuan, getWidth() / 2, 500);
    //}

    /** Hentikan musik ketika masuk ke dunia lain **/
    public void stopBacksound() {
        backsound.stop();
    }
    }
