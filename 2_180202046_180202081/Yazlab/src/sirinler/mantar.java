package sirinler;

import java.util.Random;

import javax.swing.ImageIcon;

public class mantar extends Thread{
	public void mantaryap()  throws InterruptedException{
		while(true) {
			Random rand = new Random();
			int rand1 = rand.nextInt(13); 
	        int rand2 = rand.nextInt(11);
	        if(sirinler.harita[rand2][rand1]==1) {
	        	sirinler.Lharita[rand2][rand1].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/mantar.png"));
	        	System.out.print("eklendi");
	        	sirinler.altýnlar[rand2][rand1]=50;
	        	break;
	        }
	        
		}
		
		
		
		
	}
	public void run() {
		
		while(true) {
		try {
			Thread.sleep(20000);
			mantaryap();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
}
