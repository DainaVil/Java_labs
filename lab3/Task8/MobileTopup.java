package Task8;

public class MobileTopup extends Topup{
    private final int mobile = 1;

    public void topup(Card card) throws InterruptedException {
        System.out.println("-----");
        System.out.println("Пополнение баланса из мобильного приложения");
        Topup.topup(card, mobile);
    }
}
