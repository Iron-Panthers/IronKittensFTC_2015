/**
	The colors for each alliance.
*/
public enum AllianceColor {
	BLUE (1, 2), 
	RED  (3, 4);

	/** Hue range **/
	public final int min, max;

	AllianceColor(int min, int max) {
		this.min = min;
		this.max = max;
	}
}