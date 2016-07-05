package dungeongame;

import java.awt.Color;
import java.util.ArrayList;

public class World {

	int levelNumber = 1;
	int score = 0;
	ArrayList<Character> characters = new ArrayList<Character>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public World() {
		// characters.add(new Player(562, 409, this, new Color(0, 128, 255),
		// new Color(0, 77, 205), 30));
		int levelNumber = 1;
		Level level = new Level("Hi", levelNumber, this);
		// for (int i = 0; i < 10; i++) {
		// characters.add(new Enemy((int) (Math.random() * 800), (int) (Math
		// .random() * 800), this, new Color(255, 0, 0), new Color(
		// 205, 0, 0), 5));
		// }

	}

	public void move() {
		int enemies = 0;
		int players = 0;
		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i) instanceof Enemy) {
				enemies += 1;
			}

			if (characters.get(i) instanceof Player) {
				players += 1;
			}
		}
		
		if (players == 0) {
			characters.removeAll(characters);
			levelNumber = 1;
			Level level = new Level("Hi", levelNumber, this);
		}
		if (enemies == 0) {
			characters.remove(0);
			projectiles.removeAll(projectiles);
                        if(levelNumber < Constants.numberOfLevels){
			    levelNumber += 1;
                        }
                        else{
                            levelNumber = 1;
                        }
			Level level = new Level("Hi", levelNumber, this);
		}
		for (int i = 0; i < characters.size(); i++) {
			characters.get(i).Move();
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).move();
		}

		collisions();

		if (!characters.isEmpty() && characters.get(0).health < 0) {
			characters.clear();
			projectiles.clear();
		}

		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i).health <= 0) {
				characters.remove(i);
			}
		}

		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i) instanceof Enemy) {
			}
		}

	}

	private void collisions() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isOnDaScreen()) {
				projectiles.remove(i);
			}
		}

		for (int i = 0; i < characters.size(); i++) {
			for (int j = 0; j < characters.size(); j++) {
				if (i != j) {

					characters.get(i).checkIntersect(characters.get(j));
				}

			}
		}

		for (int i = 0; i < characters.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {
				characters.get(i).checkIntersect(projectiles.get(j));
			}
		}
	}

	public void addPlayer(int x, int y) {
		characters.add(new Player(x, y, this));
	}

	public void addWarrior(int x, int y) {
		characters.add(new Warrior(x, y, this));
	}

	public void addTank(int x, int y) {
		characters.add(new Tank(x, y, this));
	}

	public void addSniper(int x, int y) {
		characters.add(new Sniper(x, y, this));
	}

	public int getPlayerX() {
		return characters.get(0).x;
	}

	public int getPlayerY() {
		return characters.get(0).y;
	}

	public void addToScore(int increase) {
		score += increase;
	}

	public int getScore() {
		return score;
	}

	public ArrayList<Character> getCharacterArray() {
		return characters;
	}

	public ArrayList<Projectile> getProjectileArray() {
		return projectiles;
	}

	public void addProjectiles(Projectile bullet) {
		projectiles.add(bullet);
	}
}
