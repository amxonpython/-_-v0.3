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

        int[] deletes = new int[max_massiv];
        boolean[] deleted_product = new boolean[max_massiv];

        boolean working = true;

        while (working){
            System.out.println("выберите действие: ");
            String action = scanner.nextLine();
            switch (action){
                case "":
                    break;
                case "добавить товар":
                    if(i == max_massiv){
                        System.out.println("вы дастигнули лимит товаров");
                    }else {
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
                    }

                case "добавить покупку":

                    System.out.println("введите id товара");
                    int id_pokypki = scanner.nextInt();
                    if (id_pokypki <= i && id_pokypki > 0 && !deleted_product[id_pokypki]){
                        sales_counter++;
                        System.out.println("покупка завершена, был куплен товар с:");
                        System.out.println("id: " + sales_counter + " названием " + name_tavara[id_pokypki] + " c ценой " + price_tavara[id_pokypki]);
                        System.out.println("id чека: " + sales_counter);
                    }else {
                        System.out.println("Error: такого id не существует или был удалён");
                    }

                    scanner.nextLine();
                    break;
                case "exit":
                    working = false;
                    break;
                case "delete":
                    System.out.println("введите id тавара который хотите удалить");
                    int delete = scanner.nextInt();
                    if (deletes[delete] < i){
                        id_tavara = null;
                        name_tavara = null;
                        price_tavara = null;

                        deleted_product[delete] = true;

                        System.out.println("товар " + name_tavara[delete] + " был удалём");
                    }else{
                        System.out.println("тавар не найдей");
                    }

                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Error: неизвестная команда");
                    break;
            }
        }
    }
}
