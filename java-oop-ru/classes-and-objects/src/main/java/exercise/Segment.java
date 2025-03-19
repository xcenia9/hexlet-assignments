package exercise;

// BEGIN
public class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public Point getBeginPoint() {
        if (getPoint1().getX() <= getPoint2().getX() || getPoint1().getY() <= getPoint2().getY()) {
            return getPoint1();
        } else {
            return getPoint2();
        }
    }

    public Point getEndPoint() {
        if (getPoint1().getX() <= getPoint2().getX() || getPoint1().getY() <= getPoint2().getY()) {
            return getPoint2();
        } else {
            return getPoint2();
        }
    }

    public Point getMidPoint() {
        int midX = (getPoint1().getX() + getPoint2().getX()) / 2;
        int midY = (getPoint1().getY() + getPoint2().getY()) / 2;
        Point midPoint = new Point(midX, midY);
        return midPoint;
    }
}
// END
