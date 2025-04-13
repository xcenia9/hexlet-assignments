package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle circle) throws NegativeRadiusException {
        try {
            var area = Math.round(circle.getSquare());
            System.out.println(area);
        } catch (NegativeRadiusException message) {
            System.out.println("Не удалось посчитать площадь");
        } finally {
            System.out.println("Вычисление окончено");
        }

    }
}
// END
