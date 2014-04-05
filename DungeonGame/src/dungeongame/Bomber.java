package dungeongame;

import java.awt.Rectangle;

public class Bomber extends Enemy{

	public Bomber(int x, int y, World world) {
		super(x, y, world);
		speed = 12;
		width = 12;
		height = 12;
		maxHealth = 2;
		health = maxHealth;
		shoots = false;
	}
	

}
