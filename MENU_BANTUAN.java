import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MENU_BANTUAN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MENU_BANTUAN extends MENU
{

     public MENU_BANTUAN() {
        // Panggil konstruktor induk untuk buat world 450x600
        super();

        //Ganti background dengan gambar bantuan
        GreenfootImage bg = new GreenfootImage("TOMBOL_BANTUAN.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);

        // Tambahkan tombol kembali ke menu utama
        //addObject(new TOMBOL_KEMBALI(), 50, 50);
    }
   
}
