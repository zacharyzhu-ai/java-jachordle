//required import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jachordle extends JPanel {
	
    private int tc = 0;//timer
    private int tcd = 0; //a timer counter

    private int enter = 0; //enter counter
    private int levelctrl = 1; //level control
    
    private String fill [][] = {{"", "", "", "", ""}, //row one
    							{"", "", "", "", ""}, //row two
    							{"", "", "", "", ""}, //row three
    							{"", "", "", "", ""}, //row four
    							{"", "", "", "", ""}, //row five
    							{"", "", "", "", ""}, //row six
    							{"", "", "", "", ""}, //row seven(for backup) 
    							};
    
    private boolean backspacesignal = false; //backspace signal
    private boolean lvldetect = false; //detects the change in levels
    private boolean enterdetect = false; //detects whenever the player hits enter
    private boolean check = false; //checks if the round is complete
    private boolean lost = false; //when the player loses the game
    private boolean delete = false; //if a player want to delete a letter
    
    //the boolean flickers for every single line 
    private boolean l1 = false;
    private boolean l2 = false;
    private boolean l3 = false;
    private boolean l4 = false;
    private boolean l5 = false;
    private boolean l6 = false;
    
    private ArrayList<String> word = new ArrayList<String>();
    
    private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }
    
    private class Keyboard implements KeyListener  {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
			int a = e.getKeyCode();
	
			if(a == 10)  {//enter
				enterdetect = true;
				enter++;
				tcd = tc + 70;
			}
			if(a == 8)  {//backspace
				if (word.size() > 0) {
					delete = true;
				}
				else { //if the player is hitting backspace at the beginning
					backspacesignal = true;
					tcd = tc + 70;
				}
			}
			if(a == 65)  {//a
				word.add("a");
			}
			if(a == 66)  {//b
				word.add("b");
			}
			if(a == 67)  {//c
				word.add("c");
			}
			if(a == 68)  {//d
				word.add("d");
			}
			if(a == 69)  {//e
				word.add("e");
			}
			if(a == 70)  {//f
				word.add("f");
			}
			if(a == 71)  {//g
				word.add("g");
			}
			if(a == 72)  {//h
				word.add("h");
			}
			if(a == 73)  {//i
				word.add("i");
			}
			if(a == 74)  {//j
				word.add("j");
			}
			if(a == 75)  {//k
				word.add("k");
			}
			if(a == 76)  {//l
				word.add("l");
			}
			if(a == 77)  {//m
				word.add("m");
			}
			if(a == 78)  {//n
				word.add("n");
			}
			if(a == 79)  {//o
				word.add("o");
			}
			if(a == 80)  {//p
				word.add("p");
			}
			if(a == 81)  {//q
				word.add("q");
			}
			if(a == 82)  {//r
				word.add("r");
			}
			if(a == 83)  {//s
				word.add("s");
			}
			if(a == 84)  {//t
				word.add("t");
			}
			if(a == 85)  {//u
				word.add("u");
			}
			if(a == 86)  {//v
				word.add("v");
			}
			if(a == 87)  {//w
				word.add("w");
			}
			if(a == 88)  {//x
				word.add("x");
			}
			if(a == 89)  {//y
				word.add("y");
			}
			if(a == 90)  {//z
				word.add("z");
			}
		}
    }
    
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    
    private BufferedImage image;
    private Graphics g;
    private Timer timer;
    
    public Jachordle() {
    	
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = image.getGraphics();
        
        //goal word importing stuff idk
        GoalWord gw = new GoalWord();
        gw.wordBank();
        gw.pick();
        
        timer = new Timer(10, new TimerListener());
		timer.start();
		addMouseListener(new Mouse());
		addKeyListener(new Keyboard());
		setFocusable(true); 
    }
    
    private class TimerListener implements ActionListener  {
    	@Override
    	public void actionPerformed(ActionEvent e)  {
    
    		//backgrounds
			GameBackground bg = new GameBackground(levelctrl);
			bg.draw(g);
			
			GoalWord gw = new GoalWord();
			gw.wordBank();
			
			
			//gamemode
			if(bg.gamemode("yes") == 0) {
				
			}
			
			//make sure it wont go out of the tile vertically 
			if(enter > 6)  {
				enter--;
			}
			
			//if a player deletes a letter
			if(delete)  {
				fill[enter][word.size()-1] = "";
				word.remove(word.size() - 1);
				delete = false;
			}
			
			//checking
			if(l1)  {
				gw.check(fill[0]);
				gw.drawBox(g, 0);
			}
			if(l2)  {
				gw.reset();
				gw.check(fill[1]);
				gw.drawBox(g, 1);
			}
			if(l3)  {
				gw.reset();
				gw.check(fill[2]);
				gw.drawBox(g, 2);
			}
			if(l4)  {
				gw.reset();
				gw.check(fill[3]);
				gw.drawBox(g, 3);
			}
			if(l5)  {
				gw.reset();
				gw.check(fill[4]);
				gw.drawBox(g, 4);
			}
			if(l6)  {
				gw.reset();
				gw.check(fill[5]);
				gw.drawBox(g, 5);
			}
			
			//draw out the letters
			for(int r = 0; r < fill.length; r++)  {  //loops over the rows and draw them out
				for(int c = 0; c < fill[0].length; c++)  {  //loops over the columns and draw them out
					if(word.size() >= 1)  { 
						fill[enter][0] = word.get(0);
					}
					if(word.size() >= 2)  {
						fill[enter][1] = word.get(1);
					}
					if(word.size() >= 3)  {
						fill[enter][2] = word.get(2);
					}
					if(word.size() >= 4)  {
						fill[enter][3] = word.get(3);
					}
					if(word.size() >= 5)  {
						fill[enter][4] = word.get(4);
					}
  					if(word.size() > 5)  {
  						word.remove(word.size() - 1);
					}
					for (int k = 0; k <= enter; k++) {
						g.setFont(new Font("Comic Sans MS", 0, 70));
						g.setColor(Color.black);
						g.drawString(fill[k][c], 180 + 100 * c, 175 + k * 100);
					}
					if (enterdetect) {
						if(gw.fCheck(enter, fill[enter]) == 1)  {
							check = true;
						}
						if(gw.fCheck(enter, fill[enter]) == 2)  {
							lost = true;
						}
						if(fill[enter][4].equals(""))  {
							enter--;
							enterdetect = false;
						}
						else {
							if(enter >= 1)  {
								l1 = true;
							}
							if(enter >= 2)  {
								l2 = true;
							}
							if(enter >= 3)  {
								l3 = true;
							}
							if(enter >= 4)  {
								l4 = true;
							}
							if(enter >= 5)  {
								l5 = true;
							}
							if(enter >= 6)  {
								l6 = true;
							}
							for (int i = 0; i < fill[0].length; i++) {
								fill[enter][i] = "";
							}
							word.clear();
							enterdetect = false;
						}
					}
				}
			}
			
			//fixing this whatever bug
			if(enterdetect && word.size() == 0)  {
				enter--;
				enterdetect = false;
			}
			
			//if ur hitting backspace at the first tile
			if(backspacesignal)  {
				g.setColor(Color.red);
				g.fillRect(200, 320, 395, 65);
				g.setFont(new Font("Comic Sans MS", 0, 40));
				g.setColor(Color.black);
				g.drawString("stop backspacing >:(", 220, 360);
			}
			if(word.size() != 0 || tc > tcd)  {
				backspacesignal = false;
			}
			
			//resets timer each timer the level changed
			if(lvldetect)  {
				tc = 0;
				gw.reset();
				l1 = false;
				l2 = false;
				l3 = false;
				l4 = false;
				l5 = false;
				l6 = false;
				lvldetect = false;
			}
			
			//draw levels
			g.setFont(new Font("Comic Sans MS", 0, 30));
			g.setColor(Color.black);
			g.drawString("level  " + levelctrl, 50, 60);
			
			//draw timer
			g.setFont(new Font("Comic Sans MS", 0, 30));
			g.setColor(Color.black);
			g.drawString("time left: " + ((60 - levelctrl * 10) - tc/60), 600, 60);
			
			//to the next level automatically 
			if((60 - levelctrl * 10) - tc/60 <= 0 || check)  {
				if (levelctrl < 5) {
					lvldetect = true;
					levelctrl++;
					for (int r = 0; r < fill.length; r++) {
						for (int c = 0; c < fill[0].length; c++) {
							fill[r][c] = "";
						}
					}
					enter = 0;
					word.clear();
					gw.pick();
					tc = 0;
				}
				if(levelctrl == 5)  {
					timer.stop();
				}
				check = false;
			}
    		tc++;
    		
    		//losing screen
    		if(lost || (60 - levelctrl * 10) - tc/60 <= 0 && fill[6][0].equals(""))  {
    			g.setColor(Color.red);
				g.fillRect(370, 320, 65, 65);
				g.fillRect(150, 385, 505, 85);
				g.setFont(new Font("Comic Sans MS", 0, 60));
				g.setColor(Color.black);
				g.drawString("L", 390, 370);
				g.drawString("goal word: " + gw.getGoalWord(), 170, 445);
				timer.stop();
    		}
    		
    		//wining screen
    		if(levelctrl == 4)  {
    			if(gw.fCheck(enter, fill[enter]) == 1)  {
    				g.setColor(Color.red);
    				g.fillRect(100, 300, 605, 260);
    				g.setFont(new Font("Comic Sans MS", 0, 30));
    				g.setColor(Color.black);
    				g.drawString("talented, brilliant, incredible, amazing,", 107, 340);
    				g.drawString("showstopping, spectacular, never the same, ", 107, 380);
    				g.drawString("totally unique, completely not ever been", 107, 420);
    				g.drawString("done before, unafraid to reference or not", 107, 460);
    				g.drawString("reference, put it in a blender, shit on it, ", 107, 500);
    				g.drawString("vomit on it, eat it, give birth to it", 107, 540);
    				timer.stop();
    			}
    		}
    		repaint();
    	}
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
    
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Jachordle");
        frame.setSize(WIDTH, WIDTH);
        frame.setLocation(0, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Jachordle());
        frame.setVisible(true);
    }
}