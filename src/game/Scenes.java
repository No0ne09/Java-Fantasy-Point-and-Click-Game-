package game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class Scenes  {
	Date date = new Date();
Manager M;
	
	public Scenes(Manager M) {
		this.M=M;
		
	}

	//zmiany scen
	public void Scena1() {
		M.UI.bgP[1].setVisible(true);
		M.UI.bgP[2].setVisible(false);
		M.UI.bgP[3].setVisible(false);
		M.UI.bgP[4].setVisible(false);
		M.UI.bgP[5].setVisible(false);
		M.UI.bgP[6].setVisible(false);
		M.UI.bgP[7].setVisible(false);
		M.UI.Text.setText("");
	}
	
	public void Scena2() {
		M.UI.bgP[1].setVisible(false);
		M.UI.bgP[2].setVisible(true);
		M.UI.bgP[3].setVisible(false);
		M.UI.bgP[4].setVisible(false);
		M.UI.bgP[5].setVisible(false);
		M.UI.bgP[6].setVisible(false);
		M.UI.bgP[7].setVisible(false);
		M.UI.Text.setText("Dokąd by tu pójść..."); 
		
		
	}
	
	public void Tawerna() {
		M.UI.bgP[1].setVisible(false);
		M.UI.bgP[2].setVisible(false);
		M.UI.bgP[3].setVisible(true);
		M.UI.bgP[4].setVisible(false);
		M.UI.bgP[5].setVisible(false);
		M.UI.bgP[6].setVisible(false);
		M.UI.bgP[7].setVisible(false);
		M.UI.Text.setText("\n Tawerna w środku lasu?");
		
		
		
	}
	
	public void Miejsce_Mocy() {
		M.UI.bgP[1].setVisible(false);
		M.UI.bgP[2].setVisible(false);
		M.UI.bgP[3].setVisible(false);
		M.UI.bgP[4].setVisible(true);
		M.UI.bgP[5].setVisible(false);
		M.UI.bgP[6].setVisible(false);
		M.UI.bgP[7].setVisible(false);
		M.UI.Text.setText("Medalion drży. To miejsce mocy.");
		
	}
	
	public void Scena5() {
		M.UI.bgP[1].setVisible(false);
		M.UI.bgP[2].setVisible(false);
		M.UI.bgP[3].setVisible(false);
		M.UI.bgP[4].setVisible(false);
		M.UI.bgP[5].setVisible(true);
		M.UI.bgP[6].setVisible(false);
		M.UI.bgP[7].setVisible(false);
		if(M.G.Boss==0) {
		M.UI.Text.setText("\nPotwór jest blisko. Czuję to."); 
		}
		else {M.UI.Text.setText("\nMuszę wracać do Jaskra.");}
		
	}
	
	
	
	public void Boss() {
		
		if(M.G.Boss==0&&M.G.Medytacja==1) 
		{
		M.UI.bgP[1].setVisible(false);
		M.UI.bgP[2].setVisible(false);
		M.UI.bgP[3].setVisible(false);
		M.UI.bgP[4].setVisible(false);
		M.UI.bgP[5].setVisible(false);
		M.UI.bgP[6].setVisible(true);
		M.UI.bgP[7].setVisible(false);
		M.UI.Text.setText("Graj muzyko!");
		}
		
		 if (M.G.Boss==0&&M.G.Medytacja==0)
		{
			M.UI.Text.setText("\nPotwór tam jest, ale najpierw muszę sie przygotować.");
		}
		 
		 if (M.G.Boss==1)
		{
				M.UI.Text.setText("\nNie mam tam czego szukać.");
		}
		 
		
		}
	
	public void ShowOver(int numer) throws IOException {
		M.UI.bgP[numer].setVisible(false);
		M.UI.inventory.setVisible(false);
		M.UI.life.setVisible(false);
		M.UI.attack.setVisible(false);
		M.UI.Over.setVisible(true);
		M.UI.Over.setText("Nie Żyjesz");
		M.UI.restart.setVisible(true);
		M.UI.restart.setText("Spróbuj jeszcze raz");
		
		FileWriter writer = new FileWriter("wynik.txt");
		  writer.write("Data ukonczenia "+date.toString()+"\n");
		  if(M.G.Potion==1) {
			  writer.write("Udało ci się zdobyć ukryty eliksir."+"\n"); 
		  }
		  if(M.G.Potion==0) {
			  writer.write("Nie udało ci się zdobyć ukrytego eliksiru."+"\n"); 
		  }
		  if(M.G.Moc==1) {
			  writer.write("Odkryłaś/łeś zapomniane miejsce mocy"+"\n"); 
		  }
		  if(M.G.Moc==0) {
			  writer.write("Nie odkryłaś/łeś zapomnianego miejsca mocy"+"\n"); 
		  }
		  if(M.G.Trucizna==1) {
			  writer.write("Dałaś/łeś się nabrać na darmowy alkohol"+"\n");
			  
		  }
		  if(M.G.Trucizna==0) {
			  writer.write("Nie dałaś/łeś się nabrać na darmowy alkohol"+"\n");
			  
		  }
		  if(M.G.Boss==0) {
			  writer.write("Nie udało ci się zrealizować zlecenia"+"\n");
		  }
		  if(M.G.Boss==1) {
			  writer.write("Udało ci się zrealizować zlecenia"+"\n");
		  }
		  if(M.G.CurrentHealth<=0) {
			  writer.write("Niestety poległaś/łeś."+"\n");
		  }
		  if(M.G.CurrentHealth>0) {
			  writer.write("Udało Ci się przeżyć."+"\n");
		  }
		  
		  writer.write("Zdobyte punkty ataku: "+Integer.toString(M.G.AttackPower)+"\n");
		  writer.write("Użyte silne ataki: "+Integer.toString(M.G.licznikSilne)+"\n");
		  writer.write("Użyte szybkie ataki: "+Integer.toString(M.G.licznikSzybkie)+"\n");
		  writer.write("Użyte ataki znakami: "+Integer.toString(M.G.licznikZnaki)+"\n");
		  writer.write("DZIĘKUJĘ ZA GRĘ");
		  
		  
	      writer.close();
		
	}
	
	public void ExitGameOver() {
		M.UI.Over.setVisible(false);
		M.UI.restart.setVisible(false);
		M.UI.inventory.setVisible(true);
		M.UI.attack.setVisible(true);
		M.UI.life.setVisible(true);
		M.UI.Start.setVisible(false);
		M.G.Start();
	}
		
	
	public void ShowStart()  {
		M.UI.inventory.setVisible(false);
		M.UI.life.setVisible(false);
		M.UI.attack.setVisible(false);
		M.UI.Start.setText("Szpony i kły");
		M.UI.Start.setVisible(true);
		M.UI.restart.setVisible(true);
		M.UI.restart.setText("Nowa gra");
		
	}

	
	
	public void ShowEnding(int numer) throws IOException, ClassNotFoundException {
		M.UI.bgP[numer].setVisible(false);
		M.UI.inventory.setVisible(false);
		M.UI.life.setVisible(false);
		M.UI.attack.setVisible(false);
		M.UI.bgP[7].setVisible(true);
		M.UI.Text.setText("\n Gratulacje! Udało Ci się ukończyć grę!");
		
		FileWriter writer = new FileWriter("wynik.txt");
		  writer.write("Data ukonczenia "+date.toString()+"\n");
		  if(M.G.Potion==1) {
			  writer.write("Udało ci się zdobyć ukryty eliksir."+"\n"); 
		  }
		  if(M.G.Potion==0) {
			  writer.write("Nie udało ci się zdobyć ukrytego eliksiru."+"\n"); 
		  }
		  if(M.G.Moc==1) {
			  writer.write("Odkryłaś/łeś zapomniane miejsce mocy."+"\n"); 
		  }
		  if(M.G.Moc==0) {
			  writer.write("Nie odkryłaś/łeś zapomnianego miejsca mocy."+"\n"); 
		  }
		  if(M.G.Trucizna==1) {
			  writer.write("Dałaś/łeś się nabrać na darmowy alkohol."+"\n");
			  
		  }
		  if(M.G.Trucizna==0) {
			  writer.write("Nie dałaś/łeś się nabrać na darmowy alkohol."+"\n");
			  
		  }
		  if(M.G.Boss==1) {
			  writer.write("Udało ci się zrealizować zlecenie."+"\n");
		  }
		  if(M.G.Boss==0) {
			  writer.write("Nie udało ci się zrealizować zlecenia."+"\n");
		  }
		  if(M.G.CurrentHealth<=0) {
			  writer.write("Niestety poległaś/łeś."+"\n");
		  }
		  if(M.G.CurrentHealth>0) {
			  writer.write("Udało Ci się przeżyć."+"\n");
		  }
		  
		  writer.write("Zdobyte punkty ataku: "+Integer.toString(M.G.AttackPower)+"\n");
		  writer.write("Pozostałe punkty życia: "+Integer.toString(M.G.CurrentHealth)+"\n");
		  writer.write("Użyte silne ataki: "+Integer.toString(M.G.licznikSilne)+"\n");
		  writer.write("Użyte szybkie ataki: "+Integer.toString(M.G.licznikSzybkie)+"\n");
		  writer.write("Użyte ataki znakami: "+Integer.toString(M.G.licznikZnaki)+"\n");
		  writer.write("DZIĘKUJĘ ZA GRĘ");
		  
		  
	      writer.close();
		
		
	}
	
	}
	
	
	
	
	
	

