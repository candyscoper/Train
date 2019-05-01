/*

The TwoEndRail class.  A TwoEndRail object has two ends,
which may or may be not be opposite each other.

*/

import java.awt.*;

abstract class TwoEndRail extends Rail {

    private Direction end1, end2;
    private Rail neighbour1;  // The Rail in the direction end1.
    private Rail neighbour2;  // The Rail in the direction end2.

    public boolean exitOK(Direction d) {
        return d.equals(end1) || d.equals(end2);
    }

    // Return true if d is valid for this Rail, return false and
    // print an error otherwise.
    private boolean validDir(Direction d) {
        if (!exitOK(d)) {
            System.err.print("exit(): Not a valid dir for this piece: ");
            System.err.println(end1.direction + " " + end2.direction + " " + d.direction);
            Exception e = new Exception();
            e.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    TwoEndRail(Direction e1, Direction e2, GridLoc loc) {
        super(loc);
        color = Color.black;
        end1 = e1;
        end2 = e2;
    }


//    public TwoEndRail(Direction e1, Direction e2) {
//        super();
//        color = Color.black;
//        end1 = e1;
//        end2 = e2;
//    }


    // Register that r is adjacent to me from direction d.
    public void register(Rail r, Direction d) {
        if (validDir(d)) {
            if (d.equals(end1)) {
                neighbour1 = r;
            } else {
                neighbour2 = r;
            }
        }
    }

    public void unRegister(Direction d) {
        if (validDir(d)) {
            if (d.equals(end1)) {
                neighbour1 = null;
            } else if (d.equals(end2)) {
                neighbour2 = null;
            }
        }
    }

    // Given that d is the Direction from which a Car entered,
    // report where the Car will exit.
    public Direction exit(Direction d) {
        if (validDir(d)) {
            return d.equals(end1)
                ? end2
                : end1;
        }

        return null;
    }

    // d is the direction that I entered from, and must be one of end1 and end2.
    // Return the Rail at the other end.
    public Rail nextRail(Direction d) {
        if (validDir(d)) {
            return d.equals(end1)
                ? neighbour2
                : neighbour1;
        }

        return null;
    }

    public String toString() {
        return "TwoEndRail";
    }

    ;
}

