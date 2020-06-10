package rectangle;

public class AreaChecker {

    public Integer checkAreaOfIntersectionBetweenTwo(Rectangle firstRectangle, Rectangle secondRectangle) {
        if (hasIntersectionBetweenTwo(firstRectangle, secondRectangle)) {
            return getIntersectionArea(firstRectangle, secondRectangle);
        } else {
            return 0;
        }
    }

    private Integer getIntersectionArea(Rectangle firstRectangle, Rectangle secondRectangle) {
        Integer intersectionLeft = Math.min(secondRectangle.getY1(), secondRectangle.getY2()) -
                Math.max(firstRectangle.getY1(), firstRectangle.getY2());
        Integer intersectionBottom =
                Math.min(secondRectangle.getX1(), secondRectangle.getX2()) -
                        Math.max(firstRectangle.getX2(), firstRectangle.getX1());
        Integer intersectionArea = intersectionLeft * intersectionBottom;
        return intersectionArea - (firstRectangle.getArea() - secondRectangle.getArea());
    }

    public boolean hasIntersectionBetweenTwo(Rectangle firstRectangle, Rectangle secondRectangle) {
        return (firstRectangle.getX1() < secondRectangle.getX2()) && (secondRectangle.getX1() < firstRectangle.getX2()) &&
                (firstRectangle.getY1() < secondRectangle.getY2()) && (secondRectangle.getY1() < firstRectangle.getY2());
    }

}
