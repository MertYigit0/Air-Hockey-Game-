import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

//import TimeCounter.DisplayCountdown;

//import java.util.Timer;
import java.util.TimerTask;


import java.util.TimerTask;



public class Game extends JPanel implements KeyListener , ActionListener  {

	javax.swing.Timer timer = new Timer(1, this);
	private BufferedImage paddleImage , paddleImage1 , Ball , background;	
	
   public boolean upt , downt , leftt ,rightt , at , wt , st, dt;

	public static int lives = 3;
	public static int scorePlayer1 = 0;
	public static int scorePlayer2 = 0;
	public static int lvl = 1;
	
	public  JTextField  x = new JTextField(15);		
	
	public int en = 70;
	public int boy = 32;
	
	
	private int topY = 200;
	private int topX = 10;
	public static int topdirY = 8;
	public static int topdirX =8;
		
	
	
	private int paddleY1 = 100;
	private int dirPaddleY1 = 25;
	private int paddleX1 = 400;
	private int dirPaddleX1 = 25;
	
	
	private int paddleY2 = 800;
	private int dirPaddleY2 = 25;	
	private int paddleX2 = 400;
	private int dirPaddleX2 = 25;
	
	
	java.util.Timer timer1;
	

	public Game() {
		   timer1 = new java.util.Timer();
	        timer1.schedule(new DisplayCountdown(), 0, 1000);
	
		
		try {
		paddleImage = ImageIO.read(new FileImageInputStream(new File("paddle.png")));
		}catch(IOException ex){
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex);
		}	
		try {
			paddleImage1 = ImageIO.read(new FileImageInputStream(new File("bluepaddle.png")));
			}catch(IOException ex){
				Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex);
			}	
		try {
			background = ImageIO.read(new FileImageInputStream(new File("table.png")));
			}catch(IOException ex){
				Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex);
			}	
		try {
			Ball = ImageIO.read(new FileImageInputStream(new File("hockeyball.png")));
			}catch(IOException ex){
				Logger.getLogger(Game.class.getName()).log(Level.SEVERE , null , ex);
			}			
		 setBackground(Color.DARK_GRAY) ;
		 
		 timer.start();	
		 
		 
	}	
	
	 class DisplayCountdown extends TimerTask {

         static int seconds = 90;
         public void run() {
              if (seconds > 0) {
        
                 seconds--;
              } else {

               
               
             }    
       }
  }     
	 
	 
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);		
		
		g.drawImage(background, -3 , -3 ,740 , 964 , this);

		g.drawImage(Ball  ,topX , topY  ,50 , 50, this );
		
		
		
		g.drawImage(paddleImage ,paddleX1 , paddleY1 ,100 , 50, this );
		g.drawImage(paddleImage1 ,paddleX2 , paddleY2 ,103 , 53, this );

		g.setFont(new Font("Times New Roman" , Font.PLAIN , 60));
		g.setColor(Color.red);
		g.drawString(" " +scorePlayer1 , 660, 450 );

		g.setFont(new Font("Times New Roman" , Font.PLAIN , 60));
		g.setColor(Color.blue);
		g.drawString(" " +scorePlayer2 , 660, 535);
		
		g.setFont(new Font("Times New Roman" , Font.PLAIN , 60));
		g.setColor(Color.black);
		
		g.drawString(" " + DisplayCountdown.seconds , 15, 470);
		
		
		if(DisplayCountdown.seconds == 0) {
			if(scorePlayer1 == scorePlayer2) {
				g.setFont(new Font("Times New Roman" , Font.PLAIN , 90));
				g.setColor(Color.orange);
				g.drawString("           TIE ! ", 40, 450);
			}
			else if (scorePlayer1 > scorePlayer2){
				g.setFont(new Font("Times New Roman" , Font.PLAIN , 60));
				g.setColor(Color.red);
				g.drawString("              RED WON ! ", 40, 450);
			}
          else if (scorePlayer1 < scorePlayer2){
        	  g.setFont(new Font("Times New Roman" , Font.PLAIN , 60));
      		g.setColor(Color.blue);
        	  g.drawString("             BLUE  WON ! ", 40, 450);
			}
			
			timer.stop();
			
		}
		

		if(scorePlayer1 == 5) {
			g.setColor(Color.RED);
			g.setFont(new Font("TimesRoman", 1, 75));  
			g.drawString("       RED WON ! ", 40, 450);
		}
		
		if(scorePlayer2 == 5) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("TimesRoman", 1, 75));  
			g.drawString("    BLUE  WON ! ", 40, 450);
		}


		if(leftt == true) {	
			if(paddleX1 <= 20) {
				paddleX1 = 20 ;
			}else {
				paddleX1  =paddleX1 -dirPaddleX1/4;}}	
		 if(rightt== true) {
			if(paddleX1 >= 615) {
				paddleX1 =615 ;
			}		else {
				paddleX1  = paddleX1 +dirPaddleX1/4;}}
		 if(upt == true) {
			if(paddleY1 <= 40) {
				paddleY1 = 40;
			}		else {
				paddleY1  = paddleY1 - dirPaddleY1/4;}}
		 if(downt == true) {
			if(paddleY1 >= 420) {
				paddleY1 =420 ;
			}		else {
				paddleY1  = paddleY1 +dirPaddleY1/4;}
		}
	 
		 if(at == true) {     
	            if(paddleX2 <= 20) {
	                paddleX2 =20 ;
	            }else {
	                paddleX2  =paddleX2 -dirPaddleX2 /4;
	            }   }
	       if(dt== true) { 
	            if(paddleX2 >= 615) {
	                paddleX2 =615 ;
	            }        else {
	                paddleX2  = paddleX2 +dirPaddleX2 / 4;} }     
	     if(wt== true) {   
	            if(paddleY2 <= 490) {
	                paddleY2 =490 ;
	            }      
	     else {
	                paddleY2  = paddleY2 - dirPaddleY2 /4;}
	        }
	        if(st== true) { 
	            if(paddleY2 >= 865) {
	                paddleY2 =865 ;
	            }        else {
	                paddleY2  = paddleY2 + dirPaddleY2 /4;}
	        }
	        
	  //-----------------------      
	        if(topY  <= 10 ) {
	    		if(topX >= 200  && topX <=540 ) {
	    			scorePlayer2 += 1;
	    			 topY = 200;
	    			 topX = 30;
	    			 
	    		}
	    		}
	    		
	    		if(topY  >=  885 ) {
	    			if(topX >= 200  && topX <=530 ) {
	    				scorePlayer1 += 1;
	    			 topY = 200;
	    				 topX = 30;
	    				
	    			}
	    			}
	        
	        
	        
	}
	@Override
	public void repaint() {
		super.repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {			
	}

	@Override
	public void keyPressed(KeyEvent e) {	
		int c = e.getKeyCode();			
		 if (e.getKeyCode() == KeyEvent.VK_UP) {
		        upt = true;
		    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		    	  downt = true;
		    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    	  rightt = true;
		    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		    	  leftt = true;
		    } 
		 if (e.getKeyCode() == KeyEvent.VK_W) {
		        wt = true;
		    } else if (e.getKeyCode() == KeyEvent.VK_S) {
		    	  st = true;
		    } else if (e.getKeyCode() == KeyEvent.VK_D) {
		    	  dt = true;
		    } else if (e.getKeyCode() == KeyEvent.VK_A) {
		    	 at = true;
		    }     
		//paint(getGraphics());
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		
		 if (e.getKeyCode() == KeyEvent.VK_UP) {
		        upt = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		    	  downt = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		    	  rightt = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		    	  leftt = false;
		    }
		 
		 if (e.getKeyCode() == KeyEvent.VK_W) {
		        wt = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_S) {
		    	  st = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_D) {
		    	  dt = false;
		    } else if (e.getKeyCode() == KeyEvent.VK_A) {
		    	 at = false;
		    }
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
		topY += topdirY;
		topX += topdirX;
		
		if(topY >=890 ) {	 			
			topdirY =-topdirY; 
		}
		
		if(topY <= 10  ) {
			topdirY =-topdirY; //kenar
		}
	
		if(topX >= 665 ) {   //kenar 
		 topdirX =-topdirX;
			}
		
		if(topX <= 10  ) {  //kenar 
		 topdirX =-topdirX;
		}
		
		
		if(topX <= paddleX1 +100  ) {
			if(topX >= paddleX1 - 60  ) {
				if( topY <= paddleY1 +50  ) {
					if (topY >= paddleY1 -50) {
			
	
			topdirY =-topdirY;
		}}}}
		
		if(topX <= paddleX2 +100  ) {
			if(topX >= paddleX2 - 60  ) {
				if( topY <= paddleY2 +50  ) {
					if (topY >= paddleY2 -50) {		
			topdirY =-topdirY;
		}}}}
		
		
		
		
		
		//---------------------------------			
			repaint();
			if(scorePlayer1 == 5  ||  scorePlayer2 == 5 ) {
				timer.stop();			

			            }
			
			
			
			
			
			           
			        }


}