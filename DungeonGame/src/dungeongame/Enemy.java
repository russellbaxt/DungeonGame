package dungeongame;

import java.awt.Color;

public class Enemy extends Character {

	int counter = 0;
	double random = 0;

	public Enemy(int x, int y, World world) {
		super(x, y, world);
		speed = 6;
		maxHealth = 5;
		health = maxHealth;
		color = new Color(0, 0, 0);
		color2 = new Color(0, 0, 0);
		damage = 1;
		shoots = true;
	}

	public void Move() {
		super.Move();
		angle = (int) Math.toDegrees(Math.atan2(-y + world.getPlayerY(), -x + world.getPlayerX()));
		if (shoots) {
			if (counter == (int) random) {
				random = Math.random();
				random = random * 80;
				random += 80;
				world.addProjectiles(new Projectile(x, y, 6, 6, 12, angle, 0));
				counter = 0;
			}

			counter++;
		}

	}

}
