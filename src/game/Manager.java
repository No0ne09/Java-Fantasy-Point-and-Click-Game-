package game;

import java.io.IOException;

import event.Event1;

public class Manager {
	
	//obiekty do obslugi dzialania calej gry
	
	Action Action=new Action(this);
	
	public Interface UI = new Interface (this);
	
	public Scenes Change = new Scenes(this);
	
	public Event1 e1 = new Event1(this);
	
	public Gracz G = new Gracz(this);
	
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		
		new Manager();

	}

	public Manager() {
		G.Start();
		Change.ShowStart();
	}
	
}
