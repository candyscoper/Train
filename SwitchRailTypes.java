/**
 * The SwitchRailTypes class. This class specifies all of the details that come with
 * being a SwitchRail with a certain direction. Details that are specified are each of
 * their start angles of a rail's position and the location they will be put.
 */
class SwitchRailTypes extends SwitchRail {

    private void setLoc(String dir1, String dir2, String dir3, GridLoc loc) {
        if (dir1.equals("north") && dir2.equals("south") && dir3.equals("east")) {
            nse(loc);
            startAngle = 180;
        } else if (dir1.equals("north") && dir2.equals("south") && dir3.equals("west")) {
            nsw(loc);
            startAngle = 270;
        } else if (dir1.equals("south") && dir2.equals("north") && dir3.equals("east")) {
            sne(loc);
            startAngle = 180;
        } else if (dir1.equals("south") && dir2.equals("north") && dir3.equals("west")) {
            snw(loc);
            startAngle = 0;
        } else if (dir1.equals("west") && dir2.equals("east") && dir3.equals("north")) {
            wen(loc);
            startAngle = 270;
        } else if (dir1.equals("west") && dir2.equals("east") && dir3.equals("south")) {
            wes(loc);
            startAngle = 0;
        } else if (dir1.equals("east") && dir2.equals("west") && dir3.equals("north")) {
            ewn(loc);
            startAngle = 180;
        } else if (dir1.equals("east") && dir2.equals("west") && dir3.equals("south")) {
            ews(loc);
            startAngle = 90;
        }


    }

    // Set all locations of each rail directions specified

    private void sne(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = 0.0;
        x2 = 0.5;
        y2 = 1.0;
        x3 = 0.5;
        y3 = -0.5;

    }

    private void snw(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = 0.0;
        x2 = 0.5;
        y2 = 1.0;
        x3 = -0.5;
        y3 = 0.5;

    }

    private void nse(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = 0.0;
        x2 = 0.5;
        y2 = 1.0;
        x3 = 0.5;
        y3 = -0.5;

    }

    private void nsw(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.5;
        y1 = 0.0;
        x2 = 0.5;
        y2 = 1.0;
        x3 = -0.5;
        y3 = -0.5;

    }

    private void wen(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.0;
        y1 = 0.5;
        x2 = 1.0;
        y2 = 0.5;
        x3 = -0.5;
        y3 = -0.5;

    }

    private void wes(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.0;
        y1 = 0.5;
        x2 = 1.0;
        y2 = 0.5;
        x3 = -0.5;
        y3 = 0.5;

    }

    private void ewn(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.0;
        y1 = 0.5;
        x2 = 1.0;
        y2 = 0.5;
        x3 = 0.5;
        y3 = -0.5;
    }

    private void ews(GridLoc loc) {
        super.setLoc(loc);
        x1 = 0.0;
        y1 = 0.5;
        x2 = 1.0;
        y2 = 0.5;
        x3 = 0.5;
        y3 = 0.5;

    }

    SwitchRailTypes(String dir1, String dir2, String dir3, GridLoc loc) {
        super(new Direction(dir1), new Direction(dir2), new Direction(dir3), loc);
        setLoc(dir1, dir2, dir3, loc);

    }

}
