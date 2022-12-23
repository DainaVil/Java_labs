public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Задание 1");
        var thread1 = new NewThread();
        thread1.start();
        thread1.join(); //Ждем окончания потока
        System.out.println("\n=============");

        System.out.println("Задание 2");
        var runnable = new NewRunnable();
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);
        var thread4 = new Thread(runnable);
        thread2.start();
        thread3.start();
        thread4.start();
        thread2.join(); //Ждем окончания потока
        thread3.join(); //Ждем окончания потока
        thread4.join(); //Ждем окончания потока
        System.out.println("\n=============");

        System.out.println("Задание 3");
        System.out.println("\n=============");
        var sb = new StringBuilder();
        sb.append('a');
        var thread5 = new Thread3(sb);
        var thread6 = new Thread3(sb);
        var thread7 = new Thread3(sb);
        thread5.start();
        thread6.start();
        thread7.start();
        thread5.join(); 
        thread6.join(); 
        thread7.join();  

        System.out.println("Задание 5");
        System.out.println("\n=============");
    }

}
