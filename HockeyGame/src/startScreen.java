import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.*;
public class startScreen extends JFrame  {	

	public static void main(String[] args) {
		JFrame frame1 = new JFrame("Menu");
		JFrame frame2 = new JFrame("Arkanoid");
		JFrame frame3 = new JFrame("Help");
		JFrame frame4 = new JFrame("About");
		JFrame frame6 = new JFrame("Options");
		JTextArea jt= new JTextArea("CONTROLS:Use LEFT (<==) and RIGHT (==>) and UP () and DOWN() arrows to move the paddle",5,20);
		JTextArea jt1= new JTextArea("Air Hockey Game",5,20);
	
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ActionListener start = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				Screen ekran = new Screen("Arkanoid");				
				ekran.setResizable(false);
				ekran.setFocusable(false);					
				ekran.setSize(750 , 1000);				
				ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
				Game game1 = new Game();			
				game1.requestFocus();				
				game1.addKeyListener(game1);	
				game1.setFocusable(true);	
				game1.setFocusTraversalKeysEnabled(false);
			
				ekran.add(game1);
				 ekran.setLocationRelativeTo(null);
				ekran.setVisible(true);
				frame1.setVisible(false);		
				
				
		      }
		    };
	    ActionListener exit = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				
				System.exit(0);
		      }
		    };
		 ActionListener help = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 jt.setEditable(false);
				 frame3.add(jt);
				 frame3.setLocationRelativeTo(null);
				 frame3.setResizable(false);
				 frame3.pack();
				 frame3.setVisible(true);
			 }
		 };
		 ActionListener about = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 jt1.setEditable(false);
				 frame4.add(jt1);
				 frame4.setLocationRelativeTo(null);
				 frame4.setResizable(false);
				 frame4.pack();
				 frame4.setVisible(true);
			 }
		 };
		 
		 ActionListener level1 = new ActionListener() {
				public void actionPerformed(ActionEvent actionEvent) {
					Game.topdirY =3;
					Game.topdirX =3;
					Game.lvl =1;  
				}
			    };
	
					    
		 ActionListener options = new ActionListener() {
			 public void actionPerformed(ActionEvent actionEvent) {
				 Scores op = new Scores();		
					JFrame	f = new JFrame("Options");      
					JLabel  k = new JLabel("Best Scores:");
					op.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				
					
					JPanel p = new JPanel();
					p.add(k);
					
					 f.setSize(250, 300);
				     f.setVisible(true);    
				    f.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
				    f.setLocationRelativeTo(null);
				 		
					JRadioButton lvl1 = new JRadioButton("Level 1 (Normal) ");  
					f.add(lvl1);

					lvl1.addActionListener(level1);					
					ButtonGroup group = new ButtonGroup();  
					group.add(lvl1);				
			 }
		 };
 
		frame1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		JButton b1 = new JButton("New Game");
		JButton b2 = new JButton("  Options    ");
		JButton b4 = new JButton("     Help       ");
		JButton b5 = new JButton("     About     ");
		JButton b6 = new JButton("      Exit        ");
		b1.addActionListener(start);
		b2.addActionListener(options);
		b4.addActionListener(help);
		b5.addActionListener(about);
		b6.addActionListener(exit);
		frame1.add(b1);
		frame1.add(b2);
		frame1.add(b4);
		frame1.add(b5);
		frame1.add(b6);
		frame1.setLocationRelativeTo(null);
		frame1.setSize(200, 380);
		frame1.setVisible(true);
		
		
	
		

	}

}
