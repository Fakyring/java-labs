import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FurnitureShop {
    public static class Defaults {
        public double width = 100, height = 50, depth = 100, price = 1000;
        public String manu = "IKEA", material = "Wood";
        public int count = 1;

        @Override
        public String toString() {
            return "Defaults {" +
                    "width=" + width +
                    ", height=" + height +
                    ", depth=" + depth +
                    ", material='" + material + '\'' +
                    ", manu='" + manu + '\'' +
                    ", count=" + count +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) {
        Defaults dp = new Defaults(); //Для редактирования значений, которые в классе абстракции
        List<Furniture> fn = new ArrayList<Furniture>();
        Scanner sc = new Scanner(System.in);
        String a; //а - выбор, n - для проверки на размер
        while (true) {
            System.out.println("1) Add new");
            System.out.println("2) Show");
            System.out.println("3) Change defaults");
            System.out.println("4) Exit");
            System.out.print("Choose action: ");
            a = sc.next();
            switch (a) {
                case "1" -> {
                    while (a != "4")
                        a = AddFurniture(fn, sc, dp); //Костыль, чтобы создать бесконечный цикл для добавления
                }
                case "2" -> {
                    ShowFurniture(fn); //Вывод мебели
                }
                case "3" -> {
                    ChangeDefaults(dp, sc); //Изменить значения абстракции
                }
                case "4" -> {
                    System.exit(0); //Выход
                }
            }
        }
    }

    private static void ChangeDefaults(Defaults dp, Scanner sc) {
        System.out.println(dp);
        System.out.print("Width: ");
        dp.width = sc.nextDouble();
        System.out.print("Height: ");
        dp.height = sc.nextDouble();
        System.out.print("Depth: ");
        dp.depth = sc.nextDouble();
        System.out.print("Material: ");
        dp.material = sc.next();
        System.out.print("Manu: ");
        dp.manu = sc.next();
        System.out.print("Count: ");
        dp.count = sc.nextInt();
        System.out.print("Price: ");
        dp.price = sc.nextDouble();
    }

    private static void AddTable(List<Furniture> fn, Scanner sc) {
        System.out.println("Legs(number), is angled(1-T, 0-F)");
        fn.add(new Table(sc.nextInt(), sc.nextInt() == 1));
    }

    private static void AddChair(List<Furniture> fn, Scanner sc) {
        System.out.println("Legs(n>2), max weight(n>50), seat material, is rolling(1-T, 0-F)");
        fn.add(new Chair(sc.nextInt(), sc.nextInt(), sc.next(), sc.nextInt() == 1));
    }

    private static void AddSofa(List<Furniture> fn, Scanner sc) {
        System.out.println("Doors(number), sections(number), has hang bar(1-T, 0-F)");
        fn.add(new Sofa(sc.nextInt(), sc.nextInt(), sc.nextInt() == 1));
    }

    private static void ShowFurniture(List<Furniture> fn) {
        for (Furniture furniture : fn) {
            System.out.println(furniture);
        }
    }

    static String AddFurniture(List<Furniture> fn, Scanner sc, Defaults dp) {
        System.out.println("1) New table");
        System.out.println("2) New chair");
        System.out.println("3) New sofa");
        System.out.println("4) Back");
        System.out.print("Choose action: ");
        switch (sc.next()) {
            case "1" -> {
                AddTable(fn, sc);
                ApplyDefaults(fn.get(fn.size() - 1), dp);
            }
            case "2" -> {
                AddChair(fn, sc);
                ApplyDefaults(fn.get(fn.size() - 1), dp);
            }
            case "3" -> {
                AddSofa(fn, sc);
                ApplyDefaults(fn.get(fn.size() - 1), dp);
            }
            case "4" -> {
                return "4";
            }
        }
        return "1";
    }

    private static void ApplyDefaults(Furniture fn, Defaults dp) {
        fn.setWidth(dp.width);
        fn.setHeight(dp.height);
        fn.setDepth(dp.depth);
        fn.setMaterial(dp.material);
        fn.setManufacturer(dp.manu);
        fn.setCount(dp.count);
        fn.setPrice(dp.price);
    }
}
