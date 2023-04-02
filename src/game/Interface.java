package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Interface 
{
	
//okno
JFrame window;
Manager M;
public JTextArea Text;
public JPanel bgP[] = new JPanel[10]; //plansze
public JLabel bgL[] = new JLabel[10];

//interfejs gracza
JPanel life;
JLabel lifeLabel[] = new JLabel[6];

JPanel attack;
JLabel attackLabel[] = new JLabel[5];

JPanel inventory;
public JLabel potion, moc, trucizna,alchemia,medytacja,boss;


//Game over
public JLabel Over;
public JButton restart;

//menu
public JLabel Start;


public Interface(Manager M) 
{
	
	this.M=M;
	WindowCreate();	//stworzenie okna
	Screen();		//wyswietlanie odpowiednich plansz
	Player();		//wyswieltanie statystyk gracza
	GameOver();
	StartMenu();
	window.setVisible(true);
}

public void WindowCreate() 
{
	
window=new JFrame("Wiedzmin 4");		//okno rozgrywki
window.setSize(1280,720);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.getContentPane().setBackground(Color.black);
window.setLayout(null);

Text=new JTextArea();		//przestrzen na dialogi
Text.setBounds(40,550,1180,500);
Text.setBackground(Color.black);
Text.setForeground(Color.white);
Text.setFont(new Font("Bookman Old Style",Font.PLAIN,40));
window.add(Text);
Text.setEditable(false);		
Text.setLineWrap(true);			//zawijanie tekstu
Text.setWrapStyleWord(true);




}

public void BackCreate(int numer,String plik) //wstawianie odpowiedniego tla
{
	bgP[numer] = new JPanel();
	bgP[numer].setBounds(40,75,1180,500);
	bgP[numer].setBackground(Color.black);
	bgP[numer].setLayout(null);
	bgP[numer].setVisible(false);
	window.add(bgP[numer]);
	
	bgL[numer]= new JLabel();
	bgL[numer].setBounds(0,0,1180,500);
	
	ImageIcon View=new ImageIcon(getClass().getClassLoader().getResource(plik));
	bgL[numer].setIcon(View);
	
}

public void ObjectCreate(int numer,int x, int y, int szer, int wys, String plik,String W1,String W2,String W3,String W1result,String W2result,String W3result) 
{	
	JPopupMenu Menu = new JPopupMenu();		//menu interakcji
	JMenuItem menu[]=new JMenuItem[5];
	
	menu[1]=new JMenuItem(W1);
	menu[1].addActionListener(M.Action);
	menu[1].setActionCommand(W1result);
	Menu.add(menu[1]);
	
	menu[2]=new JMenuItem(W2);
	menu[2].addActionListener(M.Action);
	menu[2].setActionCommand(W2result);
	Menu.add(menu[2]);
	
	menu[3]=new JMenuItem(W3);
	menu[3].addActionListener(M.Action);
	menu[3].setActionCommand(W3result);
	Menu.add(menu[3]);
	
	
	JLabel Object = new JLabel();
	Object.setBounds(x,y,szer,wys);	//pozycjonowanie
	ImageIcon ViewObject=new ImageIcon(getClass().getClassLoader().getResource(plik)); //wczytanie zdjecia dla obiektu
	Object.setIcon(ViewObject);
	//Object.setBackground(Color.blue);
	//Object.setOpaque(true);
	Object.addMouseListener(new MouseListener() 
	{

		public void mousePressed(MouseEvent e) 		//wykrywanie wcisniecia myszy
		{
			if(SwingUtilities.isLeftMouseButton(e)) 
			{
				Menu.show(Object,e.getX(),e.getY());
			}
		}

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseReleased(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent e) {
			
		}

		public void mouseExited(MouseEvent e) {
			
		}
		
		
	}
	);
	
	bgP[numer].add(Object);	//dodanie obiektu do odpowiedniego ekranu
	
}

public void Arrow(int numer, int x, int y, int szer, int wys,String polecenie) {
	JButton Strzalka = new JButton();
	Strzalka.setBounds(x,y,szer,wys);
	
	Strzalka.setBackground(null);
	Strzalka.setContentAreaFilled(false);
	
	Strzalka.setVisible(true);
	Strzalka.addActionListener(M.Action);
	Strzalka.setActionCommand(polecenie);
	Strzalka.setBorderPainted(false);
	bgP[numer].add(Strzalka);
	
	
	
}


//tworzenie interfejsu gracza (życie, ekwipunek)
public void Player() {
	
	life =  new JPanel();
	life.setBounds(50,10,250,50);
	life.setBackground(Color.black);
	life.setLayout(new GridLayout(1,5));
	window.add(life);
	
	ImageIcon LifeIcon=new ImageIcon(getClass().getClassLoader().getResource("life.png"));
	
	attack =  new JPanel();
	attack.setBounds(400,10,250,50);
	attack.setBackground(Color.black);
	attack.setLayout(new GridLayout(1,5));
	window.add(attack);
	
	ImageIcon AttackIcon=new ImageIcon(getClass().getClassLoader().getResource("miecz.png"));
	
	for(int i=0;i<5;i++) {
		lifeLabel[i]= new JLabel();
		lifeLabel[i].setIcon(LifeIcon);
		life.add(lifeLabel[i]);
	}
	
	for(int i=0;i<4;i++) {
		attackLabel[i]= new JLabel();
		attackLabel[i].setIcon(AttackIcon);
		attack.add(attackLabel[i]);
	}
	
	inventory =  new JPanel();
	inventory.setBounds(850,10,300,50);
	inventory.setBackground(Color.black);
	inventory.setLayout(new GridLayout(1,6));
	window.add(inventory);
	
	potion= new JLabel();
	ImageIcon PotionIcon=new ImageIcon(getClass().getClassLoader().getResource("potion.png"));
	potion.setIcon(PotionIcon);
	inventory.add(potion);
	
	
	moc= new JLabel();
	ImageIcon MieczIcon=new ImageIcon(getClass().getClassLoader().getResource("moc.png"));
	moc.setIcon(MieczIcon);
	inventory.add(moc);
	
	trucizna= new JLabel();
	ImageIcon TruciznaIcon=new ImageIcon(getClass().getClassLoader().getResource("poison.png"));
	trucizna.setIcon(TruciznaIcon);
	inventory.add(trucizna);
	
	alchemia= new JLabel();
	ImageIcon AlchemiaIcon=new ImageIcon(getClass().getClassLoader().getResource("alchemy.png"));
	alchemia.setIcon(AlchemiaIcon);
	inventory.add(alchemia);
	
	medytacja= new JLabel();
	ImageIcon MedytacjaIcon=new ImageIcon(getClass().getClassLoader().getResource("zbroja.png"));
	medytacja.setIcon(MedytacjaIcon);
	inventory.add(medytacja);
	
	boss= new JLabel();
	ImageIcon BossIcon=new ImageIcon(getClass().getClassLoader().getResource("boss_icon.png"));
	boss.setIcon(BossIcon);
	inventory.add(boss);
	
	}


public void GameOver() {
	
	Over = new JLabel();
	Over.setBounds(390,200,500,200);
	Over.setForeground(Color.red);
	Over.setFont(new Font("Bookman Old Style",Font.PLAIN,100));
	Over.setVisible(false);
	window.add(Over);
	
	restart = new JButton();
	restart.setBounds(380,400,500,50);
	restart.setFont(new Font("Bookman Old Style",Font.BOLD,35));
	restart.setBorder(null);
	restart.setBackground(null);
	restart.setForeground(Color.white);
	restart.setFocusPainted(false);
	restart.addActionListener(M.Action);
	restart.setActionCommand("restart");
	restart.setVisible(false);
	window.add(restart);
}

public void StartMenu() {
	
	Start = new JLabel();
	Start.setBounds(395,200,500,200);
	Start.setForeground(Color.red);
	Start.setFont(new Font("Bookman Old Style",Font.PLAIN,80));
	Start.setVisible(false);
	window.add(Start);
	
	
}

public void Screen() //obiekty na odpowiednich ekranach
{
	//Scena startowa
	BackCreate(1,"rsz_start.jpg");
	ObjectCreate(1,350,175,150,250,"jaskier.png","Rozmawiaj","Zaatakuj","Wspominaj","TalkJaskier","AttackJaskier","WspominajJaskier");
	ObjectCreate(1,800,345,213,73,"namiot.png", "Śpij","Przeszukaj","Przygotuj się","Sleep1","Search1","Prepare");
	ObjectCreate(1,550,345,213,73,"namiot.png", "Spójrz","Przeszukaj","Zniszcz","LookNamiot","Search2","Destroy1");
	Arrow(1,2,70,50,350,"Scena2");
	Arrow(1,1130,70,50,350,"Miejsce_Mocy");
	bgP[1].add(bgL[1]);
	
	//las
	BackCreate(2,"las.png");
	ObjectCreate(2,220,100,70,70,"herb.png", "Zbadaj","Rozmawiaj","Zbierz","Check3","Talk3","Collect");
	Arrow(2,400,420,500,50,"Scena1");
	Arrow(2,5,100,80,300,"Tawerna");
	Arrow(2,400,150,180,180,"Scena5");
	bgP[2].add(bgL[2]);
	
	//tawerna
	BackCreate(3,"tawerna.gif");
	ObjectCreate(3,800,20,350,350,"blank.png", "Zapytaj o cenę","Napij się","Ukradnij","Price","Drink","Steal");
	ObjectCreate(3,480,60,250,380,"blank.png", "Zbadaj","Rozmawiaj","Zapytaj o potwora","Check2","Talk2","Ask");
	Arrow(3,2,70,50,350,"Scena2");
	bgP[3].add(bgL[3]);
	
	//Miejsce mocy
	BackCreate(4,"place_of_power.jpg");
	ObjectCreate(4,800,100,200,200,"blank.png", "Zbadaj","Zaczerpnij","Skomentuj","Check1","Gain","Comment");
	Arrow(4,400,420,450,50,"Scena1");
	Arrow(4,2,70,50,350,"Scena1");
	bgP[4].add(bgL[4]);
	
	//Arena przed bossem
	BackCreate(5,"s5.gif");
	Arrow(5,1130,70,50,350,"Scena2");
	Arrow(5,675,360,100,100,"Boss");
	bgP[5].add(bgL[5]);
	
	
	//Bossfight
	BackCreate(6,"boss_bg.jpg");
	Arrow(6,2,70,30,350,"Scena5");
	ObjectCreate(6,780,70,450,450,"boss.gif", "Szybki Atak","Silny Atak","Użyj znaków","Attack1","Attack2","Attack3");
	bgP[6].add(bgL[6]);
	
	//endscreen
	BackCreate(7,"ending.gif");
	bgP[7].add(bgL[7]);
	
	
	
}
}
