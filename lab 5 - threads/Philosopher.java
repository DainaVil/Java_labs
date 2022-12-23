public class Philosopher extends Thread {

    // side 1 - право, 0 - лево

    private int maxPortion = 100; // порция спагетти ограничена
    private int portion = 5; // скорость еды
    private boolean hasLeftFork, hasRightFork = false;
    private int leftForkID;
    private int rightForkID;

    private volatile int[] forks = new int [6];

    Philosopher (int leftForkID, int[] forks) {
        this.leftForkID = leftForkID;
        this.forks = forks;
        rightForkID = (getForkID(0) == 1) ? 5 : getForkID(0) - 1;
    }

    // найти айди вилки справа/слева
    public int getForkID(int side) {
        return  (side == 0) ? this.leftForkID : this.rightForkID;
    }

    // взять вилку справа/слева
    private void takeFork(int side){
        if (forks[getForkID(side)] == 1) dream();
        else {
            forks[getForkID(side)] = 1;
            if (side == 0) {
                hasLeftFork = true;
            } else {
                hasRightFork = true;
            }
            String str = "Философ-" + this.leftForkID;
            str += (side == 1) ? " взял правую вилку" : " взял левую вилку";
            System.out.println(str);
        }
    }

    // вернуть вилку
    private void putFork(int side) {
        forks[getForkID(side)] = 0;
        if (side == 0) {
            hasLeftFork = false;
        } else {
            hasRightFork = false;
        }
        try {
            String str = "Философ-" + this.leftForkID;
            str += (side == 1) ? " положил правую вилку" : " положил левую вилку";
            System.out.println(str);
            Thread.sleep(300);
        } catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
    private void eat() {
        
        if (portion > maxPortion) portion = maxPortion;
        try {
            maxPortion -= portion;
            System.out.println("Философ-" + this.leftForkID + " ест спагетти"); 
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dream() {
        try {
            System.out.println("Философ-" + this.leftForkID + " размышляет");    
            Thread.sleep(600);
        } catch (InterruptedException e){
            e.printStackTrace();
        }              
    }

    @Override
    public void run() {
        while (true) {
            if (!(hasLeftFork && hasRightFork)) {
                // попытка получить обе вилки
                takeFork(1);
                takeFork(0);
            } else {
                break;
            }
        }

        // только после получения двух вилок запускается процесс еды
        while (maxPortion > 0){
            eat();
        }

        if (hasLeftFork) putFork(0);
        if (hasRightFork) putFork(1);
        
        System.out.println("Философ-" + this.leftForkID + " закончил есть");
        super.run();
    }
}