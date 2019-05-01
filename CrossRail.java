/*

The CrossRail class.  A CrossRail object has four ends.
This type of rail allows for a train to move over the same
area in different directions.

*/

import java.awt.*;

class CrossRail extends Rail {

    // My line coordinates for drawing myself.
    private double x1, y1, x2, y2, x3, y3, x4, y4;

    // (end1,end2) and (end3,end4) are the two pairs.
    // The are, in order, always 'north', 'south', 'east', and 'west'.
    private Direction end1, end2, end3, end4;

    private Rail neighbour1;  // The Rail in the direction end1.
    private Rail neighbour2;  // The Rail in the direction end2.
    private Rail neighbour3;  // The Rail in the direction end3.
    private Rail neighbour4;  // The Rail in the direction end4.

    public boolean exitOK(Direction d) {
        return d.equals(end1) || d.equals(end2) || d.equals(end3) || d.equals(end4);
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


    CrossRail(GridLoc loc) {// locates where the rail will be positioned
        super(loc);

        color = Color.darkGray;
        end1 = new Direction("north");
        end2 = new Direction("south");
        end3 = new Direction("east");
        end4 = new Direction("west");

        setLoc(loc);

    }

    public void setLoc(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.0;
        y1 = 0.5;
        x2 = 1.0;
        y2 = 0.5;

        x3 = 0.5;
        y3 = 0.0;
        x4 = 0.5;
        y4 = 1.0;
    }


    public void register(Rail r, Direction d) { //add the rail to the track
        if (validDir(d)) {
            if (d.equals(end1)) {
                neighbour1 = r;
            } else if (d.equals(end2)) {
                neighbour2 = r;
            } else if (d.equals(end3)) {
                neighbour3 = r;
            } else if (d.equals(end4)) {
                neighbour4 = r;
            }
        }
    }


    public void unRegister(Direction d) {// remove rail from the track
        if (validDir(d)) {
            if (d.equals(end1)) {
                neighbour1 = null;
            } else if (d.equals(end2)) {
                neighbour2 = null;
            } else if (d.equals(end3)) {
                neighbour3 = null;
            } else if (d.equals(end4)) {
                neighbour4 = null;
            }
        }
    }

    // Given that d is the Direction from which a Car entered,
    // report where the Car will exit.
    public Direction exit(Direction d) {
        if (validDir(d)) {
            if (d.equals(end1)) {
                return end2;
            } else if (d.equals(end2)) {
                return end1;
            } else if (d.equals(end3)) {
                return end4;
            } else if (d.equals(end4)) {
                return end3;
            }
        }

        return null;
    }

    // d is the direction that I entered from, and must be one of end1 and end2.
    // Return the Rail at the other end.
    public Rail nextRail(Direction d) {
        if (validDir(d)) {
            if (d.equals(end1)) {
                return neighbour2;
            } else if (d.equals(end2)) {
                return neighbour1;
            } else if (d.equals(end3)) {
                return neighbour4;
            } else if (d.equals(end4)) {
                return neighbour3;
            }
        }

        return null;
    }

    // Redraw myself.
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        Rectangle b = bounds();
        g.drawLine((int) (x1 * b.width), (int) (y1 * b.height),
            (int) (x2 * b.width), (int) (y2 * b.height));
        g.drawLine((int) (x3 * b.width), (int) (y3 * b.height),
            (int) (x4 * b.width), (int) (y4 * b.height));
    }

    public String toString() {
        return "CrossRail";
    }

}

