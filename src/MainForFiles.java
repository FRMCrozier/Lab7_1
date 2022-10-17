import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Вариант 3.
 * Задание: Создать класс окружность, член класса – R. Предусмотреть в классе методы вычисления и
 * вывода сведений о фигуре – площади, длины окружности. Создать производный класс – круглый
 * прямой цилиндр с высотой h, добавить в класс метод определения объема фигуры, перегрузить методы
 * расчета площади и вывода сведений о фигуре. Написать программу, демонстрирующую работу с
 * классом: дано N окружностей и M цилиндров, найти окружность максимальной площади и средний объем
 * цилиндров.
 */

public class MainForFiles {


    public static void main(String[] args) throws IOException {
        final int N = 10;
        Circles circles = new Circles();
        Cylinders cylinders = new Cylinders();
        Random random = new Random();

        Circle[] c = new Circle[N];
        for (int i = 0; i < c.length; i++) {
            c[i] = new Circle(random.nextDouble(0.1, 6));
            circles.addCircle(c[i]);
        }
        for (int j = 0; j < N; j++)
            cylinders.addCylinder(new Cylinder(c[j].getRadius(), random.nextDouble(0.1, 6)));

        System.out.println(N + " CIRCLES:\n" + circles);
        System.out.println(N + " CYLINDERS:\n" + cylinders);

        ArrayList<Circle> cls = circles.getCircles();
        ArrayList<Cylinder> cyl = cylinders.getCylinders();

        long timeStart = System.currentTimeMillis(), t1, t2, t3, t4, t5;
        Files f = new Files();
        t1 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        f.Save("Circle.txt", cls);
        f.Clear(cls);
        f.Load("CirclesForLoad.txt", cls);
        f.Save("Circle2.txt", cls);
        f.Save("Cylinder.txt", cyl);
        f.Clear(cyl);
        f.Load("CylindersForLoad.txt", cyl);
        f.Save("Cylinder2.txt", cyl);
        t2 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        f.Serialize("CircleSerialize.txt", cls);
        f.Deserialize("CircleSerialize.txt", cls);
        f.Serialize("CylinderSerialize.txt", cyl);
        f.Deserialize("CylinderSerialize.txt", cyl);
        t3 = System.currentTimeMillis() - timeStart;

        timeStart = System.currentTimeMillis();
        f.sFastJSON("CircleFJSON.json", cls);
        f.Clear(cls);
        f.dFastJSON("CircleFJSON.json", cls);
        f.sFastJSON("CylinderFJSON.json", cyl);
        f.Clear(cyl);
        f.dFastJSON("CylinderFJSON.json", cyl);
        t4 = System.currentTimeMillis() - timeStart;

        System.out.println("Initial Data Generation:	" + t1 + " ms");
        System.out.println("Text format Save/load:		" + t2 + " ms");
        System.out.println("Java serialization/des:		" + t3 + " ms");
        System.out.println("FastJackson serialization/des:	" + t4 + " ms");


    }
}
