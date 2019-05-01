// A direction; one of 'north', 'south', 'east' and 'west'.

class Direction {

    public String direction;

    public Direction(String s) {

        if (!s.equals("north") && !s.equals("south") &&
            !s.equals("east") && !s.equals("west")) {
            System.err.println(s + " is an invalid direction.  Must be " +
                "'north', 'south', 'east' or 'west'");
            System.exit(0);
        }

        direction = s;

    }

    public boolean equals(Direction d) {
        return d.equals(direction);
    }

    public boolean equals(String s) {
        return s.equals(direction);
    }

    public String toString() {
        return direction;
    }

    public Direction opposite() {
        Direction d = null;
        switch (direction) {
            case "north":
                d = new Direction("south");
                break;
            case "south":
                d = new Direction("north");
                break;
            case "east":
                d = new Direction("west");
                break;
            case "west":
                d = new Direction("east");
                break;

        }

        return d;
    }

}

