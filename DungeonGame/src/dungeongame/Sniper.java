package dungeongame;

import java.awt.Color;

public class Sniper extends Enemy {

	public Sniper(int x, int y, World world) {
		super(x, y, world);
		width = 16;
		height = 16;
		shoots = true;
		maxHealth = 5;
		health = maxHealth;
		color = new Color(255, 0, 128);
		color2 = new Color(192, 0, 64);
		speed = 4;
	}

}
