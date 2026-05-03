import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        int sales_counter = 0;

        int max_massiv = 10000000;

        String[] name_tavara = new String[max_massiv];
        int[] id_tavara = new int[max_massiv];
        int[] price_tavara = new int[max_massiv];

        boolean working = true;

        while (working){
            System.out.println("выберите действие: ");
            String action = scanner.nextLine();
            switch (action){
                case "":
                    break;
                case "добавить товар":
                    i++;
                    System.out.println("введите название: ");
                    String name = scanner.nextLine();

                    System.out.println("введите цену");
                    int price = scanner.nextInt();

                    price_tavara[i] = price;
                    name_tavara[i] = name;
                    id_tavara[i] = i;
                    System.out.println("создан товар с id: " + i + " названием: " + name_tavara[i] + " и ценой: " + price_tavara[i]);
                    scanner.nextLine();
                    break;

                case "добавить покупку":

                    System.out.println("введите id товара");
                    int id_pokypki = scanner.nextInt();
                    if (id_pokypki <= i && id_pokypki > 0){
                        sales_counter++;
                        System.out.println("покупка завершена, был куплен товар с:");
                        System.out.println("id: " + sales_counter + " названием " + name_tavara[id_pokypki] + " c ценой " + price_tavara[id_pokypki]);
                        System.out.println("id чека: " + sales_counter);
                    }else {
                        System.out.println("Error: такого id не существует");
                    }

                    scanner.nextLine();
                    break;
                case "exit":
                    working = false;
                    break;
                default:
                    System.out.println("Error: неизвестная команда");
                    break;
            }
        }
    }
}
