import java.util.*;

/*
 * Player class that play games in the simulator
 */
public class Cell {
	private Object item;

	/*
     * A constructor that creates an empty cell
     */
	public Cell() {
	}

	/*
	 * Place an item on the cell
	 */
	public void placeItem(Object item) {
		this.item = item;
	}

	/*
	 * Clear the item on the cell
	 */
	public void clearItem() {
		this.item = null;
	}

	/*
	 * Check if the cell is empty
	 */
	public boolean isEmpty() {
		return this.item == null;
	}

	/*
	 * Override the default toString method
	 */
	public String toString() {
		if (this.isEmpty()) {
			return " ";
		} else {
			return item.toString();
		}
	}
}