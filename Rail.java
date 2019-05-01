/*

The Rail class.  A Rail object is a piece of track.  It knows
whether there is a Train on it or not, and Trains can enter()
and leave().  Given an entrance, a Rail can report where the exit()
is.

*/

import java.awt.*;

abstract class Rail extends Canvas {

    // The amount of space in which Rails have to draw themselves.


    protected Color color;
    boolean haveATrain;
    private Car currentCar;
    private GridLoc location;

    // True if a car entered or left.  Used to speed up redrawing.
    public boolean stateChanged = true;

    Rail(GridLoc loc) {
        location = loc;
        haveATrain = false;
    }

    Rail() {
        super();
        haveATrain = false;
        Rectangle b = bounds();
        resize(20, 20);
    }

    // Return true iff I have a Car.
    boolean occupied() {
        return haveATrain;
    }

    public void setLoc(GridLoc loc) {
        location = loc;
    }

    public GridLoc getLoc() {
        return location;
    }

    // Redraw myself.
    public void draw(Graphics g) {

        Rectangle b = bounds();
        g.setColor(Color.white);
        g.fillRect(0, 0, b.width - 1, b.height - 1);
        g.setColor(Color.lightGray);
        g.drawRect(0, 0, b.width - 1, b.height - 1);

        if (haveATrain) {
            currentCar.draw(g);
        }
    }

    // Register that a Train is on me.  Return true if succesful,
    // false otherwise.
    boolean enter(Car newCar) {
        haveATrain = true;
        currentCar = newCar;
        return true;
    }

    // Register that a Train is no longer on me.
    void leave() {
        haveATrain = false;
        repaint();
    }

    // Update my display.
    public void paint(Graphics g) {
        draw(g);
    }

    // Return true if d is a valid direction for me.
    abstract public boolean exitOK(Direction d);

    // Register that Rail r is in Direction d.
    abstract public void register(Rail r, Direction d);

    // Register that there is no Rail in Direction d.
    abstract public void unRegister(Direction d);

    // Given that d is the Direction from which a Car entered,
    // report where the Car will exit.
    abstract public Direction exit(Direction d);

    // Given that d is the Direction from which a Car entered,
    // report which Rail is next.
    abstract public Rail nextRail(Direction d);

    // Return myself as a string.
    public String toString() {
        return "Rail";
    }

}

