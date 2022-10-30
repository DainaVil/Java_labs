package Task8;

public class ATM {
    private final int atm = 2;

    public void topup(Card card) throws InterruptedException {
        System.out.println("-----");
        System.out.println("Пополнение баланса из банкомата");
        Topup.topup(card, atm);
    }
}
