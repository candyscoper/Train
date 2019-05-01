/*

The SwitchRail class.  A SwitchRail object has three ends, and a controller
which determines which ends are used.  If a Car moves on from the first end,
the switch determines which of the other two ends it leaves from.  If it moves
on from one of the other two ends, it automatically leaves by the first end.

*/

import java.awt.*;

abstract class SwitchRail extends Rail {

    // My line coordinates for drawing myself.
    double x1, y1, x2, y2, x3, y3;

    // Info for my corner portion.
    int startAngle;

    // (end1,end2) and (end1,end3) are the two pairs.
    // end1 and end2 are the straight directions (i.e., they are
    // opposite each other), and end1 and end3 form the corner.
    private Direction end1, end2, end3;

    private Rail neighbour1;  // The Rail in the direction end1.
    private Rail neighbour2;  // The Rail in the direction end2.
    private Rail neighbour3;  // The Rail in the direction end3.

    // Whether I am aligned to go straight.
    private boolean goingStraight;

    SwitchRail(Direction e1, Direction e2, Direction e3, GridLoc loc) {
        super(loc);
        color = Color.magenta;
        end1 = e1;
        end2 = e2;
        end3 = e3;
    }


    public boolean exitOK(Direction d) {
        return d.equals(end1) || d.equals(end2) || d.equals(end3);
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

    // Register that r is adjacent to me from direction d.
    public void register(Rail r, Direction d) {
        if (validDir(d)) {
            if (d.equals(end1)) {
                neighbour1 = r;
            } else if (d.equals(end2)) {
                neighbour2 = r;
            } else if (d.equals(end3)) {
                neighbour3 = r;
            }
        }
    }


    public void unRegister(Direction d) {
        if (validDir(d)) {
            if (d.equals(end1)) {
                neighbour1 = null;
            } else if (d.equals(end2)) {
                neighbour2 = null;
            } else if (d.equals(end3)) {
                neighbour3 = null;
            }
        }
    }

    // Given that d is the Direction from which a Car entered,
    // report where the Car will exit.
    // Note that if d is not end1's Direction, then it will have to
    // exit toward end1.
    public Direction exit(Direction d) {
        if (validDir(d)) {
            if (!d.equals(end1)) {
                return end1;
            } else if (d.equals(end1)) {
                if (goingStraight) {
                    return end2;
                } else {
                    return end3;
                }
            }
        }

        return null;
    }

    // d is the direction that I entered from, and must be one of end1, end2 and end3.
    // Return the Rail at the other end.
    public Rail nextRail(Direction d) {
        if (validDir(d)) {
            if (!d.equals(end1)) {
                return neighbour1;
            } else {
                if (goingStraight) {
                    return neighbour2;
                } else {
                    return neighbour3;
                }
            }
        }

        return null;
    }

    // Handle a mouse click.  This will toggle the direction of the switch.
    public boolean handleEvent(Event evt) {
        Object target = evt.target;

        if (evt.id == Event.MOUSE_DOWN && !occupied()) {
            goingStraight = !goingStraight;
            repaint();
            return true;
        }

        // If we get this far, I couldn't handle the event
        return false;
    }

    // Redraw myself.
    public void draw(Graphics g) {

        super.draw(g);

        Rectangle b = bounds();

        // Draw current direction of the switch darker.
        if (goingStraight) {
            g.setColor(Color.lightGray);
            g.drawArc((int) (x3 * b.width), (int) (y3 * b.height),
                b.width, b.height, startAngle, 90);
            g.setColor(color);
            g.drawLine((int) (x1 * b.width), (int) (y1 * b.height),
                (int) (x2 * b.width), (int) (y2 * b.height));
        } else {
            g.setColor(Color.lightGray);
            g.drawLine((int) (x1 * b.width), (int) (y1 * b.height),
                (int) (x2 * b.width), (int) (y2 * b.height));
            g.setColor(color);
            g.drawArc((int) (x3 * b.width), (int) (y3 * b.height),
                b.width, b.height, startAngle, 90);
        }
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

}

