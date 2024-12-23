## Отчет по лабораторной работе № 2

#### № группы: `ПМ-2402`

   #### Выполнил: `Ковалев Артемий Алексеевич`

#### Вариант: `12`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> Напишите программу на Java, которая выполняет следующие действия
с одномерным массивом целых чисел:
1. Считывает с консоли число N, затем N целых чисел и заполняет
   массив размером N.
2. Размещает числа в массиве таким образом, чтобы сначала шли числа, являющиеся квадратами целых чисел, в порядке возрастания,
   затем остальные числа в порядке убывания.
3. Находит и выводит количество чисел в массиве, которые являются
   кубами целых чисел.
4. Выводит элементы массива, заменяя числа, являющиеся квадратами, на их квадратные корни, остальные числа оставляет без изменений.
5. Заменяет каждое число в массиве на его факториал (если число
   неотрицательное) и выводит полученный массив. 

   Данную задачу можно разделить на 5 подзадач: нахождение квадратов целых чисел и не квадратов, их сортировка в основном массиве, 
нахождение количества кубов целых чисел, замена квадратов на их квадратные корни и замена чисел в массиве на их факториалы.


### 2. Входные и выходные данные

#### Данные на вход

На вход программы подаются: натуральное число N, затем N целых чисел. Верхняя граница получаемых
чисел не дана.

|                            | Тип         | min значение | max значение |
|----------------------------|-------------|--------------|--------------|
| N (количество целых чисел) | Целое число | 1            | Нет          |
| A (одно из N целых чисел)  | Целое число | Нет          | Нет          |


#### Данные на выход

Т.к. программа должна вывести количество чисел в массиве, которые являются кубами целых чисел, то на выход мы получим
единственное целое неотрицательное число, не превышающее N. Также программа выводит два массива, 
в одном из которых выводятся квадратные корни, в другом факториалы чисел. Длина этих массивов так же не превышает число N.
Значения целых чисел в этих массивах не имеют ни нижней, ни верхней границы. 

|          | Тип                         | min значение | max значение |
|----------|-----------------------------|--------------|--------------|
| Число 1  | Целое неотрицательное число | 0            | N            |
| Массив 1 | Массив целых чисел          | Нет          | Нет          |
| Массив 2 | Массив целых чисел          | Нет          | Нет          |

### 3. Выбор структуры данных

Программа получает натуральное число N. Для хранения числа N
можно выделить переменную (`n`) типа `int`. Также для хранения N чисел, 
которые подаются на вход, необходимо выделить массив (`a`) типа `int`.

|                            | название переменной | Тип (в Java) | 
|----------------------------|---------------------|--------------|
| N (количество целых чисел) | `n`                 | `int`        |
| a (массив целых чисел)     | `a`                 | `int`        |


Также для вывода результата необходимо выделить переменные для хранения количества квадратов и не квадратов целых чисел,
их индексов и количества кубов целых чисел. Также необходимо выделить два пустых массива для хранения квадратов 
и не квадратов целых чисел.


|          | название переменной | Тип (в Java) | 
|----------|--------------------|--------------|
| Число 1  | `cntsq`            | `int`        |
| Число 2  | `cntnotsq`         | `int`        |
| Число 3  | `indsq`            | `int`        |
| Число 4  | `indnotsq`         | `int`        |
| Число 5  | `cntcubes`         | `int`        |
| Массив 1 | `squares`          | `int`        |
| Массив 2 | `notsquares`       | `int`        |




### 4. Алгоритм

#### Алгоритм выполнения программы:

1. **Ввод данных:**
   Программа считывает натуральное число N, обозначенное как `n`, затем N целых чисел.

   2. **Сравнение чисел:**  
      Для начала программа подсчитывает количество квадратов, с помощью цикла `while`. Вносим квадраты 
      в соответствующий массив `squares` и заменяем их в основном массиве на 0, изменяем индекс `indsq`.
      Вносим не квадраты(числа, не равные 0 в основном массиве) в соответствующий массив `notsquares`, изменяем индекс `indnotsq`. Сортируем два получившихся массива.
      Заменяем первые элементы основного массива на квадраты по возрастанию. Обнуляем индекс не квадратов, чтобы работать с ними в основном массиве.
      Заменяем оставшиеся элементы массива на не квадраты по убыванию.Чтобы отсортировать по убыванию не квадраты: Индекс не квадратов равен количеству не квадратов - 1 - индекс 
      не квадратов, который будем увеличивать на 1 с каждым ходом. Далее, Подсчитываем количество кубов, с учётом того, отрицательное или положительное число.
      Выводим количество кубов. Затем заменяем квадраты целых чисел на их корни. Выводим получившийся массив. Далее, нужно заменить все числа на их факториалы, с учётом того, что они 
      неотрицательные. Для этого вызывается рекурсивная функция `factorial`. Если число, подставляемое в эту функцию, больше 12, то выводится некорректный результат, так как тип `int` 
      не может содержать числа такого размера, а сам массив целочисленный. Поэтому вместо факториала такого числа, в результирующий массив будет добавлена "заглушка" в виде -1. 
      И, наконец, выводим получившийся массив.

   
3. **Вывод результата:**  
   На экран выводятся: количество кубов целых чисел и два массива,
   в одном из которых выводятся квадратные корни в порядке возрастания и оставшиеся числа в порядке убывания, в другом факториалы всех чисел.

   
### 5. Программа

```java

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
            int j = 0;
            while (j*j <= a[i]) {
                if (j*j == a[i]) {
                    cntsq++;
                    break;
                }
                j++;
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
            int j = 0;
            while (j*j <= a[i]) {
                if (j*j == a[i]) {
                    squares[indsq]=a[i];
                    indsq++;
                    a[i]=0;
                    break;
                }
                j++;
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


```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений.

1.
    - **Input**:
        ```
        5
        16 8 3 7 9
        ```

    - **Output**:
        ```
      Количество кубов: 1
      Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 3 4 8 7 3
      Массив с факториалами неотрицательных целых чисел: 6 24 40320 5040 6
       ```

2.
   - **Input**:
       ```
       5
       27 81 5 6 8
       ```

   - **Output**:
       ```
     Количество кубов: 2
     Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 9 27 8 6 5
     Массив с факториалами неотрицательных целых чисел: 362880 -1 40320 720 120
       ```
3.

   - **Input**:
       ```
       10
       18 97 100 16 378 3 4 15 45 49
       ```

   - **Output**:
       ```
     Количество кубов: 0
     Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 2 4 7 10 378 97 45 18 15 3
     Массив с факториалами неотрицательных целых чисел: 2 24 5040 3628800 -1 -1 -1 -1 -1 6
       ```

4.

    - **Input**:
        ```
      6
      14 7 8 69 64 23
        ```

    - **Output**:
        ```
      Количество кубов: 2
      Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 8 69 23 14 8 7
      Массив с факториалами неотрицательных целых чисел: 40320 -1 -1 -1 40320 5040
        ```
5.
   - **Input**:
       ```
       7
       25 14 1096 225 2225 32 78
       ```

   - **Output**:
       ```
     Количество кубов: 0
     Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 5 15 2225 1096 78 32 14
     Массив с факториалами неотрицательных целых чисел: 120 -1 -1 -1 -1 -1 -1
       ```
6.

   - **Input**:
       ```
     5
     0 1 2 3 4
       ```

   - **Output**:
       ```
     Количество кубов: 2 
     Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 0 1 2 3 2
     Массив с факториалами неотрицательных целых чисел: 1 1 2 6 2
       ```
7.
    - **Input**:
        ```
      4
      25 81 0 197
        ```

    - **Output**:
        ```
      Количество кубов: 1
      Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 0 5 9 197
      Массив с факториалами неотрицательных целых чисел: 1 120 362880 -1
        ```
8. 

    - **Input**:
        ```
      9
      1024 85 81 69 34 75 25 25 16
        ```

    - **Output**:
        ```
      Количество кубов: 0
      Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 4 5 5 9 32 85 75 69 34
      Массив с факториалами неотрицательных целых чисел: 24 120 120 362880 -1 -1 -1 -1 -1
        ```
9. 

    - **Input**:
        ```
      5
      1 0 9 27 8
        ```

    - **Output**:
        ```
      Количество кубов: 4
      Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 0 1 3 27 8
      Массив с факториалами неотрицательных целых чисел: 1 1 6 -1 40320
        ```
10. 

    - **Input**:
        ```
        4
      135 278 115 231
        ```

    - **Output**:
        ```
      Количество кубов: 0
      Массив с квадратными корнями квадратов целых чисел и оставшимися числами: 278 231 135 115
      Массив с факториалами неотрицательных целых чисел: -1 -1 -1 -1
        ```
      