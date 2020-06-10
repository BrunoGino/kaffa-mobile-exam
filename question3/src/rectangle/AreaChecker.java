package rectangle;

public class AreaChecker {

    public boolean hasIntersectionBetweenTwo(Rectangle firstRectangle, Rectangle secondRectangle) {
        return (firstRectangle.getX1() < secondRectangle.getX2()) && (secondRectangle.getX1() < firstRectangle.getX2()) &&
                (firstRectangle.getY1() < secondRectangle.getY2()) && (secondRectangle.getY1() < firstRectangle.getY2());
    }

}
