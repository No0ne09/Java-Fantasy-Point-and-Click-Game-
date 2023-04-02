package event;

import java.io.IOException;

import game.Manager;

public class Event1 {
	
	Manager M;
	
	public Event1(Manager M) {
		this.M=M;
		
	}
	
	//reakcje na odpowiednie dzialania 
	public void TalkJaskier() throws ClassNotFoundException, IOException {
		if(M.G.Boss==0) {
		M.UI.Text.setText("Jaskier: Bierz się za to zlecenie i znikajmy stąd.");
	}
		else {
			M.Change.ShowEnding(1);
			}
		}

	public void AttackJaskier() {
		M.UI.Text.setText("Jaskier: A to za co?");
	}
	
	public void WspominajJaskier() {
		M.UI.Text.setText("Jaskier: Ale wtedy z Czarnymi to daliśmy czadu!");
	}
	
	public void Sleep1() {
		M.UI.Text.setText("Mam spać w dzień?");
	}
	
	public void Search1() {
		if(M.G.CurrentHealth!=M.G.MaxHealth&&M.G.Potion==0&&M.G.AttackPower!=M.G.MaxPower) {
		M.UI.Text.setText("Ten eliksir może się przydać. \n *Zyskujesz dodatkowy punkt życia i ataku*");
		M.G.CurrentHealth++;
		M.G.AttackPower++;
		M.G.Potion=1;
		M.G.UpdatePlayer();
		}
		else {
			M.UI.Text.setText("Nic tu nie ma.");
		}
		
		
	}
	
	public void Destroy1() {
		M.UI.Text.setText("Po co miałbym niszczyć dobry namiot?");
	}
	
	public void LookNamiot() {
		M.UI.Text.setText("To namiot Jaskra.");
	}
	
	public void Search2() {
		M.UI.Text.setText("Oprócz lutni i wina nic tu nie znajdę.");
	}
	
	public void Drink() throws IOException {
		if(M.G.Trucizna==0) 
			{
		M.UI.Text.setText("\n *Alkohol był zatruty, tracisz punkt zdrowia*");
		M.G.CurrentHealth-=1;
		M.G.Trucizna=1;
		M.G.UpdatePlayer();
		
	if(M.G.CurrentHealth==0) 
		{
		M.UI.Text.setText("Zaraza");
		M.G.UpdatePlayer();
		M.Change.ShowOver(3);
		
		}
			}
		
		else {
			M.UI.Text.setText("\n Drugi raz się na to nie nabiorę.");
		}
	}
	
	public void Price() {
		if(M.G.Trucizna==0) {
		M.UI.Text.setText("\n Oberżysta: Jak dla ciebie to za darmo.");
	}
		
		else {M.UI.Text.setText("\n Oberżysta: Smakowało?");}
	}
	
	public void Steal() {
		M.UI.Text.setText("\n Oberżysta: Zaraz się zatrujesz. Trzema funtami stali.");
	}
	
	public void Gain() {
		if(M.G.CurrentHealth!=M.G.MaxHealth&&M.G.Moc==0&&M.G.AttackPower!=M.G.MaxPower) {
			M.UI.Text.setText("Zaczerpnąłeś z miejsca mocy. \n*Zdobywasz dodatkowy punkt życia i ataku*");
			M.G.CurrentHealth++;
			M.G.Moc=1;
			M.G.AttackPower+=1;
			M.G.UpdatePlayer();
			}
			else {
				M.UI.Text.setText("Nic tu nie zrobię.");
			}
			
		
	}
	
	public void Comment() {
		M.UI.Text.setText("Szkoda, że Ciri tego nie widzi.");
	}
	
	public void Check1() {
		if(M.G.Moc==0) {
		M.UI.Text.setText("Może udałoby mi się jakoś z niego skorzystać.");
	}
		else {
			M.UI.Text.setText("Nic tu nie zrobię.");
		}
	}
	
	public void Prepare() {
		if(M.G.Alchemia==1&M.G.Medytacja==1) 
		{
			M.UI.Text.setText("Jestem już gotowy.");
		}
		if(M.G.Alchemia==1&&M.G.Medytacja==0&&M.G.CurrentHealth!=M.G.MaxHealth&&M.G.AttackPower!=M.G.MaxPower) {
		M.UI.Text.setText("*Przygotowywujesz się do walki z bestią*");
		M.G.Medytacja=1;
		M.G.CurrentHealth+=1;
		M.G.AttackPower+=1;
		M.G.UpdatePlayer();
	}
		if(M.G.Alchemia==0&&M.G.Medytacja==0) {
			
				M.UI.Text.setText("Nic mi to nie da.");
		}
		
		
		
	}
	
	public void Check2() {
		M.UI.Text.setText("\n Medalion drży. To nie jest człowiek.");
	}
	
	public void Talk2() {
		if(M.G.Trucizna==0) {
		M.UI.Text.setText("\nOberżysta: Witaj mistrzu wiedzminie.");
	}
		else {M.UI.Text.setText("\nOberżysta: Znikaj odmieńcze.");}
	}
	
	public void Ask() {
		if(M.G.Boss==0) 
		{
		M.UI.Text.setText("\nOberżysta: Nie słyszałem nic o żadnej bestii.");
		}
		else {M.UI.Text.setText("\nOberżysta: Przecież widzę ten łeb bestii przy twoim pasie.");}
		}
	
	
	public void Check3() {
		M.UI.Text.setText("To bardzo rzadkie zioło.");
	}
	
	public void Talk3() {
		M.UI.Text.setText("Ciekawe czy driady pozwoliłyby mi to zerwać.");
	}
	
	public void Collect() 
	{
		if(M.G.Alchemia==0) {
		M.UI.Text.setText("Przyda się do zlecenia. \n *Zdobywasz składnik alchemiczny*");
		M.G.Alchemia=1;
		M.G.UpdatePlayer();
		
		}
		else
		{
			M.UI.Text.setText("Nie potrzebuję więcej");	
		}
		
		}
	
	
	public void Attack1() throws IOException {
		if(M.G.CurrentHealth>0&&M.G.BossHealth>0) 
		{
		M.G.CurrentHealth-=1;
		M.G.BossHealth-=1.5*M.G.AttackPower;
		M.G.licznikSzybkie++;
		M.G.UpdatePlayer();
		M.UI.Text.setText("HP przeciwnika: "+ Integer.toString(M.G.BossHealth));
		}
		
		if(M.G.CurrentHealth==0) 
		{
		M.UI.Text.setText("");
		M.G.UpdatePlayer();
		M.Change.ShowOver(6);
		}
		
		if(M.G.CurrentHealth>0&&M.G.BossHealth<=0) 
		{
			M.G.Boss=1;
			M.G.UpdatePlayer();
			M.Change.Scena5();
			
		}
		
	}
	public void Attack2() throws IOException {
		if(M.G.CurrentHealth>0&&M.G.BossHealth>0) 
		{
		M.G.CurrentHealth-=1;
		M.G.BossHealth-=1.75*M.G.AttackPower;
		M.G.licznikSilne++;
		M.G.UpdatePlayer();
		M.UI.Text.setText("HP przeciwnika: "+ Integer.toString(M.G.BossHealth));
		}
		
		if(M.G.CurrentHealth==0) 
		{
		M.UI.Text.setText("");
		M.G.UpdatePlayer();
		M.Change.ShowOver(6);
		}
		
		if(M.G.CurrentHealth>0&&M.G.BossHealth<=0) 
		{
			M.G.Boss=1;
			M.G.UpdatePlayer();
			M.Change.Scena5();
			
		}
	}
	
	public void Attack3() throws IOException {
		if(M.G.CurrentHealth>0&&M.G.BossHealth>0) 
		{
		M.G.BossHealth-=1.25*M.G.AttackPower;
		M.G.CurrentHealth-=1;
		M.G.licznikZnaki++;
		M.G.UpdatePlayer();
		M.UI.Text.setText("HP przeciwnika: "+ Integer.toString(M.G.BossHealth));
		
		}
		
		if(M.G.CurrentHealth==0) 
		{
		M.UI.Text.setText("");
		M.G.UpdatePlayer();
		M.Change.ShowOver(6);
		}
		
		if(M.G.CurrentHealth>0&&M.G.BossHealth<=0) 
		{
			M.G.Boss=1;
			M.G.UpdatePlayer();
			M.Change.Scena5();
			
		}
	}

}
