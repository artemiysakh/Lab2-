import java.util.Scanner;
import java.util.Arrays;

public class Main {
    //Рекурсивная подпрограмма факториала
    public static int factorial(int n){
        if(n>=13){
            return -1; //Если число больше 12, возвращается -1
        }else{
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
        }
    }
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод значений
        System.out.print("Введите количество целых чисел N: ");
        int n = scanner.nextInt();

        int[] a = new int[n];
        System.out.print("Введите целые числа: \n");
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();

        int cntsq = 0; //Количество квадратов

        //Подсчитываем количество квадратов
        for (int i = 0; i < n; i++) {
            int sqrt = (int) Math.sqrt(a[i]);
            if((sqrt * sqrt) == a[i]){
                cntsq++;
            }
        }

        int cntnotsq = n - cntsq; //Количество не квадратов

        //Пустые массивы для хранения квадратов и не квадратов
        int[] squares = new int[cntsq];
        int[] notsquares = new int[cntnotsq];

        //Индексы квадратов
        int indsq = 0;
        int indnotsq = 0;

        //Вносим квадраты в соответствующий массив и заменяем их в основном массиве на 0, изменяем индекс
        for (int i = 0; i < n; i++) {
            int sqrt = (int) Math.sqrt(a[i]);
            if((sqrt * sqrt) == a[i]){
                squares[indsq]=a[i];
                indsq++;
                a[i]=0;
            }
        }
        //Вносим не квадраты в соответствующий массив, изменяем индекс
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                notsquares[indnotsq] = a[i];
                indnotsq++;
            }
        }

        //Сортируем два получившихся массива
        Arrays.sort(squares);
        Arrays.sort(notsquares);

        //Заменяем первые элементы массива на квадраты по возрастанию
        for (int i = 0; i < cntsq; i++) {
            a[i] = squares[i];
        }
        //Обнуляем индекс не квадратов, чтобы работать с ними в основном массиве
        indnotsq = 0;

        //Заменяем оставшиеся элементы массива на не квадраты по убыванию
        for (int i = cntsq; i < n; i++) {
            a[i] = notsquares[cntnotsq - 1 - indnotsq]; //Чтобы отсортировать по убыванию не квадраты: Индекс не квадратов равен количеству не квадратов - 1 -
                                                        // - индекс не квадратов, который будем увеличиваться на 1 с каждым ходом
            indnotsq++;
        }

        int cntcubes = 0; //Количество кубов

        //Подсчитываем количество кубов, с учётом того, отрицательное или положительное число
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                if((int) Math.cbrt(-a[i]) * (int) Math.cbrt(-a[i]) * (int) Math.cbrt(-a[i]) == -a[i]){
                    cntcubes++;
                }
            }else{
                if((int) Math.cbrt(a[i]) * (int) Math.cbrt(a[i]) * (int) Math.cbrt(a[i]) == a[i]){
                    cntcubes++;
                }
            }
        }

        //Выводим количество кубов
        System.out.print("Количество кубов: \n");
        System.out.print(cntcubes + " \n");

        //Заменяем квадраты целых чисел на их корни
        for (int i = 0; i < n; i++) {
            int sqrt = (int) Math.sqrt(a[i]);
            if((sqrt * sqrt) == a[i]){
                a[i]=sqrt;
            }
        }
        //Выводим получившийся массив
        System.out.print("Массив с квадратными корнями квадратов целых чисел и оставшимися числами: \n");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(" \n");

        //Заменяем все числа на их факториалы, с учётом того, что они неотрицательные
        for (int i = 0; i < n; i++) {
            if(a[i]>=0){
                a[i] = factorial(a[i]);
            }
        }
        //Вывод получившийся массив
        System.out.print("Массив с факториалами неотрицательных целых чисел: \n");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
