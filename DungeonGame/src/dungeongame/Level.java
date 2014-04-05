package dungeongame;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Level {
	private String level;
	private int levelNumber;
	private BufferedReader r;
	private World world;

	public Level(String level, int levelNumber, World world) {
		this.level = level;
		this.levelNumber = levelNumber;
		this.world = world;
		drawCharacters1();
		drawCharacters2();
	}

	public void drawCharacters1() {
		r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("level" + levelNumber + ".txt")));
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 40; j++) {
				int current = 0;
				try {
					String s = "" + (char) (r.read());
					current = Integer.parseInt(s);
				} catch (Exception e) {
					j -= 1;
				}

				if (current == 1) {
					world.addPlayer(j * 32, i * 32);
				}

			}
		}
	}

	public void drawCharacters2() {
		r = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("level" + levelNumber + ".txt")));
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 40; j++) {
				int current = 0;
				try {
					String s = "" + (char) (r.read());
					current = Integer.parseInt(s);
				} catch (Exception e) {
					j -= 1;
				}

				if (current == 2) {
					world.addWarrior(j * 32, i * 32);
				}

				if (current == 3) {
					world.addTank(j * 32, i * 32);
				}

				if (current == 4) {
					world.addSniper(j * 32, i * 32);
				}
			}
		}
	}

}
