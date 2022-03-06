package repeat.enums;

class App {
    public static void main(String[] args){

        Direction direction = Direction.LEFT;

        System.out.printf("Ordinal:%d%n", direction.ordinal());

        int ordinal = 3;
        direction = Direction.values()[ordinal];

        System.out.println(direction.toString());
        System.out.println("/////////////////////////");

        for (Direction d : Direction.values())
            System.out.println(d.toString());

        }
}

enum Direction {
    RIGHT, TOP, LEFT, BOTTOM
}

