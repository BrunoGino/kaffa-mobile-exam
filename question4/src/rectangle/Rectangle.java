package rectangle;

public class Rectangle {
    private Integer x1;
    private Integer x2;
    private Integer y1;
    private Integer y2;

    public Rectangle(Integer x1, Integer y1, Integer x2, Integer y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Integer getArea() {
        return getLeft() * getBottom();
    }

    public Integer getTop() {
        return Math.abs(x2 - x1);
    }

    public Integer getBottom() {
        return Math.abs(x2 - x1);
    }

    public Integer getRight() {
        return Math.abs(y2 - y1);
    }

    public Integer getLeft() {
        return Math.abs(y2 - y1);
    }

    public Integer getX1() {
        return x1;
    }

    public Integer getX2() {
        return x2;
    }

    public Integer getY1() {
        return y1;
    }

    public Integer getY2() {
        return y2;
    }
}
