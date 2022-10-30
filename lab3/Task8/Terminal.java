package Task8;

public class Terminal {

    private int singleRides;
    private int income;

    private int successes;
    private int failires;

    public boolean passCard(Card card){
        int type = card.getType();
        boolean check = card.getStatus();
        if (check) {
            if (type == 4) {
                if (card.getRides() != 0)  {
                    this.singleRides += 1;
                    this.income += 46;
                    card.pay();
                } else {
                    this.income += 46;
                    card.pay(46);
                }
            } else {
                this.income += 46;
            }

            System.out.println("Проход одобрен");
            this.successes += 1;
            return true;
        } else {
            System.out.println("Проход запрещен");
            this.failires += 1;
            return false;
        }
    }
    public void printStats() {
         System.out.println("-----");
         System.out.println("Количество разовых билетов: " + this.singleRides);
         System.out.println("Проход одобрен " + this.successes + " раз");
         System.out.println("Проход запрещен " + this.failires + " раз ");
         System.out.println("Итого прибыль: " + this.income);
         System.out.println("-----");
    }

    public static int getPrice (int cardType) {
        switch (cardType) {
            case 1:
                return 300; // студенческая 
            case 2:
                return 200; // школьная
            case 3:
                return 100; // coцкарта
            case 4:
                return 46; // разовая поездка
            default:
                return 0;
        } 
    }

}
