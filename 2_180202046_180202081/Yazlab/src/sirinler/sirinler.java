package sirinler;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Node {
	// (x, y) represents matrix cell coordinates
	// dist represent its minimum distance from the source
	int x, y, dist;

	// maintain a parent node for printing path
	Node parent;

	Node(int x, int y, int dist, Node parent) {
		this.x = x;
		this.y = y;
		this.dist = dist;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "{" + x + ", " + y + '}';
	}
};

public class sirinler extends JFrame {
	static int siri;
	static int konumx = 5;
	static int konumy = 6;
	static int dusx;
	static int dusy;
	static int dusa;
	static int dusb;
	int altýn = 1;
	static int i = 0;
	static int a = 0;
	static int i1 = 0;
	static int a1 = 0;
	static int coord[][] = new int[5000][2];
	static int coord1[][] = new int[5000][2];
	static int is = 1;
	static int ROW = 11;
	static int COL = 13;
	public static int sirin = 10;
	private static final int M = 11;
	private static final int N = 13;

	// Below arrays details all 4 possible movements from a cell
	private static final int row[] = { -1, 0, 0, 1 };
	private static final int col[] = { 0, -1, 1, 0 };

	// Function to check if it is possible to go to position (row, col)
	// from current position. The function returns false if (row, col)
	// is not a valid position or has value 0 or it is already visited
	private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
		return (row >= 0) && (row < M) && (col >= 0) && (col < N) && mat[row][col] == 1 && !visited[row][col];
	}

	// Find Shortest Possible Route in a matrix mat from source
	// cell (i, j) to destination cell (x, y)
	private static void BFS(int mat[][], int i, int j, int x, int y) {

		// construct a matrix to keep track of visited cells
		boolean[][] visited = new boolean[M][N];

		// create an empty queue
		Queue<Node> q = new ArrayDeque<>();

		// mark source cell as visited and enqueue the source node
		visited[i][j] = true;
		q.add(new Node(i, j, 0, null));

		// stores length of longest path from source to destination
		int min_dist = Integer.MAX_VALUE;
		Node node = null;
		// run till queue is not empty
		while (!q.isEmpty()) {
			// pop front node from queue and process it
			node = q.poll();

			// (i, j) represents current cell and dist stores its
			// minimum distance from the source
			i = node.x;
			j = node.y;
			int dist = node.dist;

			// if destination is found, update min_dist and stop
			if (i == x && j == y) {
				min_dist = dist;
				break;
			}

			// check for all 4 possible movements from current cell
			// and enqueue each valid movement
			for (int k = 0; k < 4; k++) {
				// check if it is possible to go to position
				// (i + row[k], j + col[k]) from current position
				if (isValid(mat, visited, i + row[k], j + col[k])) {
					// mark next cell as visited and enqueue it
					visited[i + row[k]][j + col[k]] = true;
					q.add(new Node(i + row[k], j + col[k], dist + 1, node));
				}
			}
		}

		if (min_dist != Integer.MAX_VALUE) {
			System.out.println("The shortest path from source to destination " + "has length " + min_dist);
			printPath(node);
		} else {
			System.out.println("Destination can't be reached from source");
		}

	}

	private static void printPath(Node node) {

		if (node == null) {

			return;
		}

		/*
		 * if(is==1) { dusx=node.x; dusy=node.y; Lharita[node.x][node.y].setIcon(new
		 * ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png")); is=0;}
		 */
		coord[i][0] = node.x;
		coord[i][1] = node.y;
		coord1[i1][0] = node.x;
		coord1[i1][1] = node.y;
		a++;
		a1++;
		Lharita[coord[i][0]][coord[i][1]].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/11.png"));
		Lharita[coord1[i1][0]][coord1[i1][1]].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/11.png"));
		if (siri == 1)
			Lharita[konumx][konumy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/lazy.png"));
		else
			Lharita[konumx][konumy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/brainy.png"));
		// Lharita[dusx][dusy].setIcon(new
		// ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		i++;
		i1++;
		printPath(node.parent);
		System.out.println(node);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int[][] harita = new int[11][13];
	static JLabel[][] Lharita = new JLabel[11][13];
	static int[][] altýnlar = new int[11][13];
	private JPanel contentPane;
	String imagePath;
	private int sir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws FileNotFoundException
	 */

	public sirinler() {
		coord[1][0] = 0;
		coord[1][1] = 3;
		coord1[1][0] = 0;
		coord1[1][1] = 10;
		if (sirin == 1)
			imagePath = "C:/Users/Ýlker/Desktop/Yazlab/images/lazy.png";
		if (sirin == 0)
			imagePath = "C:/Users/Ýlker/Desktop/Yazlab/images/brainy.png";
		// Image sir = new ImageIcon(this.getClass().getResource(imagePath)).getImage();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 863);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		loadmap(sirin);

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();

				revalidate();
				repaint();
				if (altýn <= 0) {
					JOptionPane.showMessageDialog(null, "Altýnýnýz Tükendi Oyunu Kaybettiniz", "Oyun Bitti",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new AnaSayfa();
				}
				// Player movement
				if (key == KeyEvent.VK_W) {
					if (harita[konumx - 1][konumy] == 1) {
						Lharita[konumx][konumy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
						Lharita[konumx - 1][konumy].setIcon(new ImageIcon(imagePath));
						if (altýnlar[konumx - 1][konumy] == 5)
							altýn = altýn + 5;
						if (altýnlar[konumx - 1][konumy] == 50)
							altýn = altýn + 50;
						konumx = konumx - 1;

					}
				}
				if (key == KeyEvent.VK_A) {
					if (harita[konumx][konumy - 1] == 1) {
						Lharita[konumx][konumy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
						Lharita[konumx][konumy - 1].setIcon(new ImageIcon(imagePath));
						if (altýnlar[konumx][konumy - 1] == 5)
							altýn = altýn + 5;
						if (altýnlar[konumx][konumy - 1] == 50)
							altýn = altýn + 50;
						konumy = konumy - 1;
					}
				}
				if (key == KeyEvent.VK_S) {
					if (harita[konumx + 1][konumy] == 1) {
						Lharita[konumx][konumy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
						Lharita[konumx + 1][konumy].setIcon(new ImageIcon(imagePath));
						if (altýnlar[konumx + 1][konumy] == 5)
							altýn = altýn + 5;
						if (altýnlar[konumx + 1][konumy] == 50)
							altýn = altýn + 50;
						konumx = konumx + 1;
					}
				}
				if (key == KeyEvent.VK_D) {
					if (harita[konumx][konumy + 1] == 1) {
						Lharita[konumx][konumy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
						Lharita[konumx][konumy + 1].setIcon(new ImageIcon(imagePath));
						if (altýnlar[konumx][konumy + 1] == 5)
							altýn = altýn + 5;
						if (altýnlar[konumx][konumy + 1] == 50)
							altýn = altýn + 50;
						konumy = konumy + 1;
					}
				}
				if (konumx == 7 && konumy == 12) {
					JOptionPane.showMessageDialog(null,
							"Tebrikler, Þirineyi kurtardýnýz.\n Sahip Olunan Altýn: " + altýn, "Oyun Bitti",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new AnaSayfa();
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {

				while (i > 0) {
					Lharita[coord[i][0]][coord[i][1]]
							.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
					i--;
				}

				int b = 0;
				while (b < 5000) {
					coord[b][0] = 0;
					coord[b][1] = 0;
					b++;
				}
				a = 0;

				BFS(harita, dusx, dusy, konumx, konumy);
				Lharita[coord[a - 2][0]][coord[a - 2][1]]
						.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
				/*
				 * if(coord[a-2]!=null) { Lharita[coord[a-1][0]][coord[a-1][1]].setIcon(new
				 * ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
				 * Lharita[coord[a-2][0]][coord[a-2][1]].setIcon(new
				 * ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
				 * 
				 * }
				 */
				Lharita[coord[a - 1][0]][coord[a - 1][1]]
						.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
				dusx = coord[a - 3][0];
				dusy = coord[a - 3][1];
				if (dusx == konumx && dusy == konumy) {
					dusx = 0;
					dusy = 3;
					altýn = altýn - 15;
				}
				// Lharita[dusx][dusy].setIcon(new
				// ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				while (i1 > 0) {
					Lharita[coord1[i1][0]][coord1[i1][1]]
							.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
					i1--;
				}

				int bi = 0;
				while (bi < 5000) {
					coord1[bi][0] = 0;
					coord1[bi][1] = 0;
					bi++;
				}
				a1 = 0;
				BFS(harita, dusa, dusb, konumx, konumy);

				Lharita[coord1[a1 - 2][0]][coord1[a1 - 2][1]]
						.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
				/*
				 * if(coord[a-2]!=null) { Lharita[coord[a-1][0]][coord[a-1][1]].setIcon(new
				 * ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
				 * Lharita[coord[a-2][0]][coord[a-2][1]].setIcon(new
				 * ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
				 * 
				 * }
				 */
				Lharita[coord1[a1 - 1][0]][coord1[a1 - 1][1]]
						.setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
				dusa = coord1[a1 - 2][0];
				dusb = coord1[a1 - 2][1];
				if (dusa == konumx && dusb == konumy) {
					dusa = 0;
					dusb = 10;
					altýn = altýn - 15;
				}
			}

		});
		/*
		 * Image img0 = new ImageIcon(this.getClass().getResource(
		 * "C:/Users/Ýlker/Desktop/Yazlab/images/0.png")).getImage(); Image img1 = new
		 * ImageIcon(this.getClass().getResource(
		 * "C:/Users/Ýlker/Desktop/Yazlab/images/1.png")).getImage();
		 */

	}

	public int getSirin() {
		return sirin;
	}

	public void setSirin(int sirin) {
		sirinler.sirin = sirin;
	}

	public static void main(String args[]) {
		new AnaSayfa();

	}

	public void loadmap(int sir) {
		siri = sir;
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 11; j++) {
				altýnlar[j][i] = 0;
			}
		}

		File dosya = new File("C:/Users/Ýlker/Desktop/Yazlab/harita.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(dosya);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tmp = sc.nextLine();

		String tmp1 = sc.nextLine();

		for (int j = 0; j < 11; j++) {
			String map = sc.nextLine();
			String[] sep = map.split("\\s");
			for (int i = 0; i < 13; i++) {

				harita[j][i] = Integer.parseInt(sep[i]);
				System.out.print(harita[j][i] + " ");

			}
			System.out.println();
		}

		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 11; j++) {
				Lharita[j][i] = new JLabel("");
				if (harita[j][i] == 1)
					Lharita[j][i].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/1.png"));
				if (harita[j][i] == 0)
					Lharita[j][i].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/0.png"));
				Lharita[j][i].setBounds(i * 75, j * 75, 75, 75);
				contentPane.add(Lharita[j][i]);
				Lharita[j][i].repaint();
			}
		}
		if (sir == 0) {
			Lharita[5][6].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/brainy.png"));
		} else
			Lharita[5][6].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/lazy.png"));
		Lharita[7][12].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/sirine.png"));

		if (tmp.startsWith("Karakter:Gargamel,Kapi:A")) {
			System.out.println("Gargamel A");
			dusx = 0;
			dusy = 3;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp.startsWith("Karakter:Gargamel,Kapi:C")) {
			System.out.println("Gargamel C");
			dusx = 5;
			dusy = 0;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp.startsWith("Karakter:Gargamel,Kapi:D")) {
			System.out.println("Gargamel D");
			dusx = 10;
			dusy = 3;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp.startsWith("Karakter:Gargamel,Kapi:B")) {
			System.out.println("Gargamel B");
			dusx = 0;
			dusy = 10;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp.startsWith("Karakter:Azman,Kapi:A")) {
			System.out.println("Azman A");
			dusa = 0;
			dusb = 3;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp.startsWith("Karakter:Azman,Kapi:B")) {

			System.out.println("Azman B");
			dusa = 0;
			dusb = 10;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp.startsWith("Karakter:Azman,Kapi:C")) {

			System.out.println("Azman C");
			dusa = 5;
			dusb = 0;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp.startsWith("Karakter:Azman,Kapi:D")) {

			System.out.println("Azman D");
			dusa = 10;
			dusb = 3;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp1.startsWith("Karakter:Gargamel,Kapi:A")) {
			System.out.println("Gargamel A");
			dusx = 0;
			dusy = 3;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp1.startsWith("Karakter:Gargamel,Kapi:C")) {
			System.out.println("Gargamel C");
			dusx = 5;
			dusy = 0;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp1.startsWith("Karakter:Gargamel,Kapi:D")) {
			System.out.println("Gargamel D");
			dusx = 10;
			dusy = 3;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp1.startsWith("Karakter:Gargamel,Kapi:B")) {
			System.out.println("Gargamel B");
			dusx = 0;
			dusy = 10;
			Lharita[dusx][dusy].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/garga.png"));
		}
		if (tmp1.startsWith("Karakter:Azman,Kapi:A")) {
			System.out.println("Azman A");
			dusa = 0;
			dusb = 3;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp1.startsWith("Karakter:Azman,Kapi:B")) {

			System.out.println("Azman B");
			dusa = 0;
			dusb = 10;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp1.startsWith("Karakter:Azman,Kapi:C")) {

			System.out.println("Azman C");
			dusa = 5;
			dusb = 0;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}
		if (tmp1.startsWith("Karakter:Azman,Kapi:D")) {

			System.out.println("Azman D");
			dusa = 10;
			dusb = 3;
			Lharita[dusa][dusb].setIcon(new ImageIcon("C:/Users/Ýlker/Desktop/Yazlab/images/az.png"));
		}

		
	}

}
