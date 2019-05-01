/**
 * The GridLoc class. This class specifies where the rails should be positioned
 */

// The (x,y) location on the Track.
public class GridLoc {

    int row;
    int col;

    public GridLoc(int r, int c) {
        row = r;
        col = c;
    }

    public String toString() {
        return (row + " " + col);
    }

}

