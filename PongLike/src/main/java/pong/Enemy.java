package pong;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy {
	public double x, y;
	public final int width, height;
	
	public Enemy(double x, double y) {
		this.x = x;
		this.y = y;
		width = 40;
		height = 5;
	}

	public void tick() {
		x += (Game.ball.x - x - 6) * 0.04;
		
		if(x + width >= Game.WIDTH) {
			x = Game.WIDTH - width;
		}
		else if(x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x, (int) y, width, height);
	}
}
