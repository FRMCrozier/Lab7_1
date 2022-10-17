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

public class Main {
    public static void main(String[] args) {

        System.out.println("SHORT EXAMPLES:\n");

        /**
         * Пример с вводом значений радиуса, которые могут не подходить.
         */
        double value = -1;
        while (Circle.isRadiusCorrect("" + (value = Math.random() * 11 - 5)) < 0) {
            System.out.println(value);
        }
        Circle circle = new Circle(value);
        System.out.println(circle);

        /**
         * Пример с вводом радиуса с подходящим значением через setRadius().
         */
        Circle circle2 = new Circle();
        circle2.setRadius(5);
        System.out.println(circle2);

        /**
         * Пример с вводом радиуса с неподходящим значением через setRadius().
         */
        Circle circle3 = new Circle();
        circle3.setRadius(-5);
        System.out.println(circle3);

        /**
         * Пример с вводом значений высоты, которые могут не подходить.
         */
        double value2 = -1;
        while (Cylinder.isHeightCorrect("" + (value2 = Math.random() * 11 - 5)) < 0) {
            System.out.println(value2);
        }
        Cylinder cylinder = new Cylinder(value, value2);
        System.out.println(cylinder);

        /**
         * Пример с вводом подходящего радиуса и высоты через setRadius() и setHeight().
         */
        Cylinder cylinder2 = new Cylinder();
        cylinder2.setRadius(5);
        cylinder2.setHeight(5);
        System.out.println(cylinder2);

        /**
         * Пример с вводом подходящего радиуса, но неподходящей высоты через setRadius() и setHeight().
         */
        Cylinder cylinder3 = new Cylinder();
        cylinder3.setRadius(5);
        cylinder3.setHeight(-5);
        System.out.println(cylinder3);

        /**
         * Пример с вводом неподходящего радиуса, но подходящей высоты.
         */
        Cylinder cylinder4 = new Cylinder(-5, 5);
        System.out.println(cylinder4);

        /**
         * Пример с добавлением массива окружностей и массива соответствующих им уилиндров.
         */
        Circles circles = new Circles();
        Cylinders cylinders = new Cylinders();
        Random random = new Random();
        int N = random.nextInt(2, 20);
        int M = random.nextInt(2, N);
        Circle[] c = new Circle[N];

        for (int i = 0; i < c.length; i++) {
            c[i] = new Circle(random.nextDouble(0.1, 6));
            circles.addCircle(c[i]);
        }
        for (int j = 0; j < M; j++)
            cylinders.addCylinder(new Cylinder(c[j].getRadius(), random.nextDouble(0.1, 6)));


        System.out.println(N + " CIRCLES:\n" + circles);
        System.out.println(M + " CYLINDERS:\n" + cylinders);


        System.out.println("THE CIRCLE WITH THE MAX SQUARE:\n" + circles.getMaxCircleSquare());
        System.out.println("\nAVERAGE VOLUME OF CYLINDERS:\n" + cylinders.getAverageCylinderVolume());

        /**
         * Пример с удалением цилиндра из листа по его индексу.
         */
        cylinders.RemoveOnIndex(2);
        System.out.println("\nCYLINDERS WITHOUT ONE ELEMENT:\n" + cylinders);

        /**
         * Пример с удалением конкретного єлемента из листа масива по его имени
         */
        cylinders.addCylinder(cylinder2);
        System.out.println("\nCYLINDERS WITH NEW ELEMENT:\n" + cylinders);
        cylinders.RemoveOnElement(cylinder2);
        System.out.println("\nCYLINDERS WITHOUT THIS NEW ELEMENT:\n" + cylinders);
    }
}
