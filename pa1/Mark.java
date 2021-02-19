import java.util.*;

/*
 * Mark class that represent a simple mark, such as O or X
 */
public class Mark {
	private String mark;

	/*
     * A constructor that creates an empty cell
     */
	public Mark(String c) {
		this.mark = c;
	}

	/*
	 * Override the default toString method
	 */
	public String toString() {
		return mark;
	}
}