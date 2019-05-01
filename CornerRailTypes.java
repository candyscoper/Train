/**
 * The CornerRailTypes Class. This class specifies all of the specialized details of each
 * particular type of Corner rail which includes south-east, south-west, north-east and
 * north-west
 */
class CornerRailTypes extends CornerRail {

    private void setLoc(String dir1, String dir2, GridLoc loc) {
        if (dir1.equals("south") && dir2.equals("east")) {
            se(loc);
            startAngle = 90;
        } else if (dir1.equals("south") && dir2.equals("west")) {
            sw(loc);
            startAngle = 0;
        } else if (dir1.equals("north") && dir2.equals("east")) {
            ne(loc);
            startAngle = 180;
        } else if (dir1.equals("north") && dir2.equals("west")) {
            nw(loc);
            startAngle = 270;
        }

    }

    private void se(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = 0.5;

    }

    private void sw(GridLoc loc) {
        super.setLoc(loc);
        x1 = -0.5;
        y1 = 0.5;

    }

    private void ne(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = -0.5;

    }

    private void nw(GridLoc loc) {
        super.setLoc(loc);
        x1 = -0.5;
        y1 = -0.5;

    }

    CornerRailTypes(String dir1, String dir2, GridLoc loc) {
        super(new Direction(dir1), new Direction(dir2), loc);
        setLoc(dir1, dir2, loc);

    }


}

