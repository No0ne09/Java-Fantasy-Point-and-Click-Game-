package game;

public class Gracz {
	Manager M;
	
	public int MaxHealth;
	public int CurrentHealth;
	public int Moc;
	public int Trucizna;
	public int Potion;
	public int Alchemia;
	public int Medytacja;
	public int BossHealth;
	public int AttackPower;
	public int MaxPower;
	public int Boss;
	public int licznikSilne;
	public int licznikSzybkie;
	public int licznikZnaki;
	
	public Gracz(Manager M) {
		this.M=M;
	}
	
	
	//statystki gracza przy rozpoczeciu gry
	public void Start() {
		MaxHealth=5;
		CurrentHealth=2;
		Moc=0;
		Trucizna=0;
		Potion=0;
		Alchemia=0;
		Medytacja=0;
		AttackPower=1;
		MaxPower=4;
		BossHealth=15;
		Boss=0;
		licznikSilne=0;
		licznikSzybkie=0;
		licznikZnaki=0;
		UpdatePlayer();
	}
	
	
	//akutalizacja statystyk
	public void UpdatePlayer() 
	{
		
		//zycie
		for(int i=0;i<5;i++) 
		{
			M.UI.lifeLabel[i].setVisible(false);
		}
		
		int HealthAmount=CurrentHealth;
		
		while(HealthAmount!=0) {
			M.UI.lifeLabel[HealthAmount-1].setVisible(true);
			HealthAmount--;
			
		}
		
		//attack
		for(int i=0;i<4;i++) 
		{
			M.UI.attackLabel[i].setVisible(false);
		}
		
		int AttackAmount=AttackPower;
		
		while(AttackAmount!=0) {
			M.UI.attackLabel[AttackAmount-1].setVisible(true);
			AttackAmount--;
			
		}
		
		//eq
		if(Moc==0){
			M.UI.moc.setVisible(false);
		}
		if(Moc==1){
			M.UI.moc.setVisible(true);
		}
		if(Trucizna==0){
			M.UI.trucizna.setVisible(false);
		}
		if(Trucizna==1){
			M.UI.trucizna.setVisible(true);
		}
		if(Potion==0){
			M.UI.potion.setVisible(false);
		}
		if(Potion==1){
			M.UI.potion.setVisible(true);
		}
		if(Alchemia==0){
			M.UI.alchemia.setVisible(false);
		}
		if(Alchemia==1){
			M.UI.alchemia.setVisible(true);
		}
		if(Medytacja==0){
			M.UI.medytacja.setVisible(false);
		}
		if(Medytacja==1){
			M.UI.medytacja.setVisible(true);
		}
		if(Boss==0){
			M.UI.boss.setVisible(false);
		}
		if(Boss==1){
			M.UI.boss.setVisible(true);
		}
		
	}
}
