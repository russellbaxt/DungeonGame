package dungeongame;

import java.awt.Color;

public class Warrior extends Enemy{

	public Warrior(int x, int y, World world) {
		super(x, y, world);
		width = 16;
		height = 16;
		speed = 6;
		maxHealth = 5;
		health = maxHealth;
		color = new Color(255, 0, 0);
		color2 = new Color(192, 0, 0);
		shoots = false;
		damage = 1;
	}

}
