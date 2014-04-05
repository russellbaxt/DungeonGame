package dungeongame;

import java.awt.Color;

public class Tank extends Enemy {

	public Tank(int x, int y, World world) {
		super(x, y, world);
		speed = 2;
		maxHealth = 30;
		health = maxHealth;
		color = new Color(128, 0, 0);
		color2 = new Color(64, 0, 0);
		width = 32;
		height = 32;
		shoots = false;		
	}

}
