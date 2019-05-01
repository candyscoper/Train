/*

The StraightRail class.  A StraightRail object has two ends,
which must be opposite each other. They look like a linear rail.

*/

import java.awt.*;

abstract class StraightRail extends TwoEndRail {

    // The multipliers for the endpoints of the StraightRail.
    double x1, y1, x2, y2;

    StraightRail(Direction e1, Direction e2, GridLoc loc) {
        super(e1, e2, loc);
        color = Color.blue;
    }


    // Redraw myself.
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        Rectangle b = bounds();
        g.drawLine((int) (x1 * b.width), (int) (y1 * b.height),
            (int) (x2 * b.width), (int) (y2 * b.height));
    }

    public String toString() {
        return this.getClass().getSimpleName();
    }

}

