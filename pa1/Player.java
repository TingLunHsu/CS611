import java.util.*;

/*
 * Player class that play games in the simulator
 */
public class Player {
	private String name;
	private int score;

	/*
     * A constructor that creates a new player
     */
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}

	/*
	 * When a player wins, this method will be called to increment the player's score
	 */
	public void incrementScore() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public String toString() {
		return name;
	}
}