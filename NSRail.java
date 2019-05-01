/*

The NSRail class.  A NSRail object has two ends,
which must be opposite each other.

*/


class NSRail extends StraightRail {

    NSRail(GridLoc loc) {
        super(new Direction("north"), new Direction("south"), loc);
        setLoc(loc);
    }


    public void setLoc(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = 0.0;
        x2 = 0.5;
        y2 = 1.0;
    }

}

