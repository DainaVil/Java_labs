package Task8;

import java.util.Scanner;

public class Topup {

    static Scanner scanner = new Scanner(System.in); 
    
    public static void topup(Card card, int type) throws InterruptedException {
        if (card.getType() == 1 || card.getType() == 2 || card.getType() == 3) {
            if (!(card.getStatus())){
                int price = Terminal.getPrice(card.getType());
                try {
                    System.out.println("Тариф: " + price + "\nСумма пополнения:");
                    int amount = scanner.nextInt();
                    if (amount == price) card.topup();
                    else System.out.println("Ошибка - сумма не соответствует тарифу");
                } catch (Exception ex) {
                    System.out.println("Ошибка");
                }
            } else {
                System.out.println("Карта уже активна");
            }
        } else if (card.getType() == 4) {
            System.out.println("Введите 1 для пополнения поездок, 2 для пополнения баланса");
            String command = scanner.next();
            if (command.equals("1")) {
                int price = Terminal.getPrice(card.getType());
                try {
                    System.out.println("Тариф: " + price + "\nСумма пополнения:");
                    int amount = scanner.nextInt();
                    if(amount % price == 0) {
                        card.topup(1, amount / price);
                    } else {
                        System.out.println("Ошибка - некратное число поездок");
                    }
                }
                catch (Exception ex) {
                    System.out.println("Ошибка");
                }

            } else if (command.equals("2")) {
                System.out.println("Сумма пополнения:");
                int amount = scanner.nextInt();
                card.topup(2, amount);
            }
        }
    }
}
