import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;

public class GameBackground {
	private int bg;

	public GameBackground(int abg) {
		bg = abg;
	}

	public void draw(Graphics g) {
		
		//different colors
		if (bg == 1) {
			for (int i = 0; i < 80; ++i) {
				g.setColor(new Color(255, 171 + i, 0 + i * 2));
				g.fillRect(0, i * 10, 800, 10);
			}
		} 
		else if (bg == 2) {
			for (int i = 0; i < 80; ++i) {
				g.setColor(new Color(0 + i * 3, 230 + i / 4, 255));
				g.fillRect(0, i * 10, 800, 10);
			}
		}
		else if (bg == 3) {
			for (int i = 0; i < 80; ++i) {
				g.setColor(new Color(0 + i * 2, 255, 0 + i * 2));
				g.fillRect(0, i * 10, 800, 10);
			}
		}
		else if (bg == 4) {
			for (int i = 0; i < 80; ++i) {
				g.setColor(new Color(255, 0 + i * 2, 0 + i * 2));
				g.fillRect(0, i * 10, 800, 10);
			}
		}
		
		//the title
		g.setColor(Color.blue);
		g.fillRect(220, 10, 355, 65);
		g.setFont(new Font("Comic Sans MS", 0, 50));
		g.setColor(Color.white);
		g.drawString("j a c h o r d l e", 230, 60);
		
		//the tiles
		for (int j = 0; j < 6; ++j) {
			g.setColor(Color.black);
			g.fillRect(100 * j + 150, 100, 5, 600);
			g.fillRect(150, 100 * j + 100, 500, 5);
		}
		g.fillRect(150, 700, 505, 5);
	}
	
	public int gamemode(String s)  {
		
		return 0;
	}
}