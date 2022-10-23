package task5;

class WeightArray {
    int[] valuesArr;
    int[] weightsArr;
    int[] rangesArr;
    int sum = 0;

    // Конструктор класса 
    public WeightArray(int[] values, int[] weights) {
        valuesArr = values;
        weightsArr = weights;

        sum = 0;
        for (int i: weights)
            sum += i;
        rangesArr = new int[sum];

        //Создаем массив с поправкой на веса значений
        System.out.print("Массив с поправкой на веса значений\n");
        int s = 0;
        for(int i = 0; i < weightsArr.length; i++) {
            for(int j = 0; j < weightsArr[i]; j++) {
                rangesArr[s] = values[i];
                System.out.print(rangesArr[s] + " ");
                s++;
            }
        }
    }

    public int getRandom(){
        double random =  (Math.random() * (rangesArr.length - 1));
        System.out.println("\nРезультат: " + rangesArr[(int) random]);
        return rangesArr[(int) random];
    }
}

public class Main {
    public static void main(String[] args) {

        int[] values = {1, 2, 3};
        int[] weights = {1, 2, 10};

        WeightArray weightArray = new WeightArray(values, weights);
        weightArray.getRandom();
        weightArray.getRandom();
        weightArray.getRandom();
        weightArray.getRandom();
        weightArray.getRandom();
        weightArray.getRandom();
    }
}
