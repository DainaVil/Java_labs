package Task8;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var schoolCard = new FixedRateCard(2, false);
        var socialCard = new FixedRateCard(2, true);
        var singleCard1 = new SinglePaymentCard(0, 0);
        var singleCard2 = new SinglePaymentCard(100, 1);

        MobileTopup mobileTopup = new MobileTopup();
        mobileTopup.topup(schoolCard);
        schoolCard.getInfo();
        mobileTopup.topup(singleCard1);
        singleCard1.getInfo();

        Terminal term = new Terminal();
        term.passCard(schoolCard);
        term.passCard(socialCard);
        term.passCard(singleCard1);
        term.passCard(singleCard1);
        term.passCard(singleCard2);

        System.out.println("Информация о карте 2 - списались в первую очередь поездки");
        singleCard2.getInfo();

        term.printStats();
    }
}
