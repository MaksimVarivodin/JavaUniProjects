package UniLabs.Lab1;

import java.util.Scanner;

public class Main {
    public static int generateRandom(int min, int max){
        int res = (int)( Math.random() * (max - min + 1) + min);

        return res;
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int size1 = 0, size2 = 0;
        System.out.print("Введите количество книг: ");
        size1 = inp.nextInt();// возможны ошибки при неправильном вводе
        System.out.print("Введите количество комиксов: ");
        size2 = inp.nextInt();// возможны ошибки при неправильном вводе
        Book[] bs = new Book[size1];
        Comics[] cmcs = new Comics[size2];
        for(int i = 0; i< size1; i++){
            int j = i+ 1;
            bs[i] = new Book("BookName "+ j, generateRandom(0, j* 100), generateRandom(0, j* 100), generateRandom(0, j* 1000), "AuthorName "+ generateRandom(1, j));
            Book.Add(bs[i]);
        }
        for(int i = 0; i< size2; i++){
            int j = i+ 1;
            cmcs[i] = new Comics("ComicsName "+j, generateRandom(0, j* 115), "IllustratorName "+ generateRandom(1, j), generateRandom(10,  50) );
            Comics.Add(cmcs[i]);
        }
        Comics.Print();
        boolean sortType = false;
        System.out.print("Выберите сортировку:\ntrue - возростающая\nfalse - нисходящая\n->");
        sortType = inp.nextBoolean();// возможны ошибки при неправильном вводе
        Book.Sort(sortType);
        Comics.Print();
        System.out.println("Средняя цена по печатной литературе: "+ Book.CountAverage());
        Comics.Clear();
    }
}