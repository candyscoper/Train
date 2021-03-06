/*

The CornerRail class.  A CornerRail object has two ends,
which must be not be opposite each other. CornerRail is a curved rail that
changes the direction of a train.

*/

import java.awt.*;

abstract class CornerRail extends TwoEndRail {

    // The multipliers for the width and height.
    double x1, y1;
    int startAngle;


    CornerRail(Direction e1, Direction e2, GridLoc loc) {
        super(e1, e2, loc);
    }

    // Redraw myself.
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        Rectangle b = bounds();
        g.drawArc((int) (x1 * b.width), (int) (y1 * b.height), b.width, b.height, startAngle,
            90);
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

}

