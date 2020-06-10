package rectangle;

public class AreaTest {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 5, 11, 11);
        Rectangle b = new Rectangle(7, 2, 13, 7);

        AreaChecker areaChecker = new AreaChecker();

        System.out.println("Has intersection: " + areaChecker.hasIntersectionBetweenTwo(a, b));
        System.out.println("Intersection area: " + areaChecker.checkAreaOfIntersectionBetweenTwo(a, b));
    }
}
