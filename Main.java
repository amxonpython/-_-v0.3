import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> id_tavara_list = new ArrayList<>();
        List<String> name_tavara_list = new ArrayList<>();
        List<Integer> price_tavara_list = new ArrayList<>();

        List<Boolean> deleted_product_list = new ArrayList<>();

        int i = -1;

        int sales_counter = 0;


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

                    price_tavara_list.add(i, price);
                    name_tavara_list.add(i, name);
                    id_tavara_list.add(i, i);

                    deleted_product_list.add(false);

                    System.out.println("создан товар с id: " + id_tavara_list.get(i) + " названием: " + name_tavara_list.get(i) + " и ценой: " + price_tavara_list.get(i));
                    scanner.nextLine();

                    break;

                case "добавить покупку":

                    System.out.println("введите id товара");
                    int id_pokypki = scanner.nextInt();
                    if (id_pokypki >= 0) {
                        if (id_pokypki <= i && !deleted_product_list.get(id_pokypki)) {
                            sales_counter++;
                            System.out.println("покупка завершена, был куплен товар с:");
                            System.out.println("id: " + id_tavara_list.get(id_pokypki) + " названием " + name_tavara_list.get(id_pokypki) + " c ценой " + price_tavara_list.get(id_pokypki));
                            System.out.println("id чека: " + sales_counter);
                        } else {
                            System.out.println("Error: такого id не существует или был удалён");
                        }
                    } else {
                        System.out.println("Error: такого id не существует или был удалён");
                    }

                    scanner.nextLine();
                    break;
                case "exit":
                    working = false;
                    break;
                case "удалить товар":
                    if (i >= 0){
                        System.out.println("введите id товара который хотите удалить");
                        int delete = scanner.nextInt();
                        String cash_data_delite = name_tavara_list.get(delete);

                        if (delete <= i){
                            id_tavara_list.set(delete, -1);
                            name_tavara_list.set(delete, "null");
                            price_tavara_list.set(delete, -1);

                            deleted_product_list.set(delete, true);

                            System.out.println("товар " + cash_data_delite + " был удалён");
                        }else{
                            System.out.println("товар не найден");
                        }
                    }else {
                        System.out.println("нету товара");
                    }

                    scanner.nextLine();
                    break;

                case "список товара":
                    if (i > -1){
                        for (int i1 = 0; i1 <= i; i1++){
                            System.out.println("id: " + id_tavara_list.get(i1) + " названием: " + name_tavara_list.get(i1) + " цена: " + price_tavara_list.get(i1));

                        }
                    }else {
                        System.out.println("нету товара");
                    }

                    break;
                case "help":
                    comands.help();
                    break;
                default:
                    System.out.println("Error: неизвестная команда");
                    break;
            }
        }
    }
}
