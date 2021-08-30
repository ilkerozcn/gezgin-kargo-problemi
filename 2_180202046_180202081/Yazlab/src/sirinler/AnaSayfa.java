package sirinler;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import static java.lang.Thread.sleep;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



public class AnaSayfa {
	JFrame Menu = new JFrame("Þirinler");
	JButton Start = new JButton("Baþlat");
	JButton Exit = new JButton("Çýkýþ");
	JButton Tembel = new JButton();
	JButton Gozluk = new JButton();
	int menuWidth = 100;
	int menuHeight = 30;
	int menuY = 460;
	int WIDTH = 490;
	int HEIGHT = 530;
	ImageIcon picture = new ImageIcon("images/ana.png");
	JLabel imageLabel = new JLabel(picture);
	altýn ThreadAl = new altýn();
	mantar m = new mantar();
	public AnaSayfa() {
		
		
		Menu.setResizable(true);
		Menu.setSize(WIDTH, HEIGHT);
		Menu.setLayout(null);
		Menu.setLocationRelativeTo(null);
		Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tembel.setSize(75, 75);
		Tembel.setLocation(120, 420);
		Tembel.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/lazy.png"));
		Gozluk.setSize(75, 75);
		Gozluk.setLocation(250, 420);
		Gozluk.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/brainy.png"));
		Start.setSize(menuWidth, menuHeight);
		Start.setLocation(10, menuY);
		Menu.add(Start);
		Menu.add(Tembel);
		Menu.add(Gozluk);
		Gozluk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sirinler.sirin= 0;
				
			}});
		
		Tembel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			sirinler.sirin= 1 ;
				
			}});
		Start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				// new sirinler();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {if(sirinler.sirin==10) {
							JOptionPane.showMessageDialog(null, "Oyuna baþlamadan önce Tembel Þirin veya Gözlüklü Þirini seçin.", "Uyarý",
									JOptionPane.INFORMATION_MESSAGE);
							new AnaSayfa();
						
						
						}else {
							if(sirinler.sirin==0)
							System.out.println("Gözlüklü Þirin seçildi.");
							if(sirinler.sirin==1)
							System.out.println("Tembel Þirin seçildi.");
							sirinler frame = new sirinler();
							frame.setVisible(true);
							ThreadAl.start();
							m.start();}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				Menu.setVisible(false);
			}

		});
		Exit.setSize(menuWidth, menuHeight);
		Exit.setLocation(375, menuY);
		Menu.add(Exit);
		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		imageLabel.setBounds((WIDTH - 549) / 2, 25, 549, 413);
		imageLabel.setVisible(true);
		Menu.add(imageLabel);
		Menu.setVisible(true);
	}
}
