package Task8;

public class SinglePaymentCard extends Card{

    private boolean status;
    private int balance;
    private int rides;
    private int type;
    
    public SinglePaymentCard (int balance, int rides) {
        this.rides = rides;
        this.balance = balance;
        this.type = 4;
        this.status = true;
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    public void setStatus() {
        if (this.rides == 0 && this.balance == 0) {
            this.status = false;
        } else {
            this.status = true;
        }
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getRides() {
        return rides;
    }

    public void setRides(int amount) {
        this.rides += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int amount) {
        this.balance += amount;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public int getInfo() {
        System.out.println("Баланс карты: \n "+ getRides() + " поездок\n  " + getBalance() + " рублей");
        if (getRides() != 0) return getRides();
        return getBalance();
    }

    @Override
    public void topup() {
        // TODO Auto-generated method stub 
    }

    @Override
    public void topup(int type, int amount) {
        if(type == 1) setRides(amount);
        if(type == 2) setBalance(amount);
        setStatus();
    }

    @Override
    public void pay() {
        setRides(-1);
        setStatus();
    }

    @Override
    public void pay(int amount) {
        setBalance(-amount);
        setStatus();
    }
    
}
