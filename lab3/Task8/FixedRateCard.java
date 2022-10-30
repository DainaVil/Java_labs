package Task8;

public class FixedRateCard  extends Card {
    private int type; // 1-студенческая, 2-школльная, 3-социальная
    private boolean status;
    private int month;

    public FixedRateCard(int type, boolean status) {
        this.type = type;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public int getType() {
        return this.type;
    }

    @Override
    public int getInfo() {
        if (getStatus()){
            System.out.println("Карта активна");
            return 1;
        }
        else {
            System.out.println("Карта неактивна");
            return 0;
        }
    }

    @Override
    public void topup() {
        setStatus(true);
    }

    @Override
    public void topup(int i, int i1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pay() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void pay(int i1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getRides() {
        return 0;
    }

}