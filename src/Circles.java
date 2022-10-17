import java.util.List;
import java.util.ArrayList;

public class Circles {

    private final ArrayList<Circle> circles;
    public Circles() {
        this.circles = new ArrayList<>();
    }

    public ArrayList<Circle> getCircles()
    {return circles;}

    public boolean addCircle(Circle circle) {
        return circles.add(circle);
    }

    public void RemoveOnIndex(int number) {
        if (number < circles.size())
            circles.remove(number);
    }

    public void RemoveOnElement(Circle circle) {
        circles.remove(circle);
    }


    public String getMaxCircleSquare() {
        int max = 0;
        for (int i = 0; i < circles.size() - 1; i++) {
            if (circles.get(max).getSquare() < circles.get(i + 1).getSquare())
                max = i + 1;
        }
        return "Circle " + max + " with square " + circles.get(max).getSquare();
    }

    @Override
    public String toString() {
        return "" + circles + "\n";
    }
}
