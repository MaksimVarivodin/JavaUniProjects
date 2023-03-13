package UniLabs.Lab1;

import java.util.Scanner;

public class Main {

    /**
     *      генерация случайных чисел целого типа в заданном диапазоне
     * */
    public static int generateRandom(int min, int max){
        return (int)( Math.random() * (max - min + 1) + min);
    }

    /**
     *      мейн
     * */
    public static void main(String[] args) {
        // cоздание переменных размера и сканера

        Scanner inp = new Scanner(System.in);

        // введение данных о размере массива книг
        System.out.print("Введите количество книг: ");
        int size1 = inp.nextInt();// возможны ошибки при неправильном вводе

        // введение данных о размере массива комиксов
        System.out.print("Введите количество комиксов: ");
        int size2 = inp.nextInt();// возможны ошибки при неправильном вводе

        // объявление массивов книг и комиксов заданного ранее размера
        Book[] bs = new Book[size1];
        Comics[] cmcs = new Comics[size2];
        Container<PaperLiterature> container1= new Container<PaperLiterature>();
        // генерация данных и заполнение статических полей Печатной литературы(предок)
        for(int i = 0; i< size1; i++){
            int j = i+ 1;
            bs[i] = new Book("BookName "+ j, generateRandom(0, j* 100), generateRandom(0, j* 100), generateRandom(0, j* 1000), "AuthorName "+ generateRandom(1, j));
            Book.Add(bs[i]);
            container1.Add(bs[i]);
        }
        // генерация данных и заполнение статических полей Печатной литературы(предок)
        for(int i = 0; i< size2; i++){
            int j = i+ 1;
            cmcs[i] = new Comics("ComicsName "+j, generateRandom(0, j* 115), "IllustratorName "+ generateRandom(1, j), generateRandom(10,  50) );
            Comics.Add(cmcs[i]);
            container1.Add( cmcs[i]);

        }



        // печать контейнера
        container1.Print();


        // создание переменной типа сортировки и ее инициализация
        boolean sortType;
        System.out.print("Выберите сортировку:\ntrue - возростающая\nfalse - нисходящая\n->");
        sortType = inp.nextBoolean();// возможны ошибки при неправильном вводе

        // сортировка контейнеров
        container1.Sort(sortType);

        // печать отсортированных контейнеров
        container1.Print();

        // получение средней цены по всей Печатной литературе(предок)
        System.out.println("Средняя цена по печатной литературе: "+ Book.CountAverage());

        /*
         *  я тут это делаю не потому что гк это не очистит,
         *  а потому что хочу использовать методы,
         *  которые написал ХД
         * */

        // очистка статических полей
        for (Book b: bs
             ) {
            Book.Delete(b);
        }
        for (Comics c: cmcs
             ) {
            Comics.Delete(c);
        }

        // зануление полей
        container1.Clear();

        // проверка результатов
        System.out.println("Средняя цена по печатной(удаленной) литературе: "+ Book.CountAverage());
    }
}