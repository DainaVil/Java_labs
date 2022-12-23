// Создать класс, реализующий интерфейс Runnable.
// Переопределить run() метод. Создать цикл for. В цикле распечатываем значения от 0 до 100 делящиеся на 10 без остатка.
// Используем статический метод Thread.sleep(), чтобы сделать паузу.
// Создать три потока, выполняющих задачу распечатки значений.

// Создать класс, реализующий интерфейс Runnable.
// Переопределить run() метод. Создать цикл for. В цикле распечатываем значения от 0 до 100 делящиеся на 10 без остатка.
// Используем статический метод Thread.sleep(), чтобы сделать паузу.
// Создать три потока, выполняющих задачу распечатки значений.


class NewRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.print(Thread.currentThread().getName() + " " + i + "\n");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } 
        }
    }
}
