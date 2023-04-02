package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Action implements ActionListener{
	
		Manager M;
		
	public Action(Manager M) {
		this.M=M;
	}

	
	public void actionPerformed(ActionEvent e) {
		
		//wykrywanie dzialan
		String choice=e.getActionCommand();
		switch(choice) {
		
		//akcje
		case "TalkJaskier" :try {
				M.e1.TalkJaskier();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			} break;
			
		case "AttackJaskier" :M.e1.AttackJaskier();break;
		case "WspominajJaskier" :M.e1.WspominajJaskier();break;
		case "Sleep1" :M.e1.Sleep1(); break;
		case "Search1" :M.e1.Search1(); break;
		case "Destroy1" :M.e1.Destroy1(); break;
		case "LookNamiot" :M.e1.LookNamiot(); break;
		case "Search2" :M.e1.Search2(); break;
		case "Drink": try {
				M.e1.Drink();
			} catch (IOException e2) {
				e2.printStackTrace();
			} break;
		case "Price": M.e1.Price();break;
		case "Steal": M.e1.Steal();break;
		case "Gain": M.e1.Gain();break;
		case "Check1":M.e1.Check1();break;
		case "Comment":M.e1.Comment();break;
		case "Prepare":M.e1.Prepare();break;
		case "Check2":M.e1.Check2();break;
		case "Talk2":M.e1.Talk2();break;
		case "Ask":M.e1.Ask();break;
		case "Check3":M.e1.Check3();break;
		case "Talk3":M.e1.Talk3();break;
		case "Collect":M.e1.Collect();break;
		case "Attack1":try {
				M.e1.Attack1();
			} catch (IOException e1) {
			
				e1.printStackTrace();
			}break;
		case "Attack2":try {
				M.e1.Attack2();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}break;
		case "Attack3":try {
				M.e1.Attack3();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}break;
		
		//zmiana scen
		case "Scena2":M.Change.Scena2();break;
		case "Scena1":M.Change.Scena1();break;
		case "Tawerna":M.Change.Tawerna();break;
		case "Miejsce_Mocy":M.Change.Miejsce_Mocy();break;
		case "Scena5":M.Change.Scena5();break;
		case "Boss":M.Change.Boss();break;
		case "restart":M.Change.ExitGameOver();M.Change.Scena1();break;
		
		
		}
		
		
	}

}
