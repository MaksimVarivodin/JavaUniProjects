package UniLabs.Lab4.BookShop.Realizations;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;

public class BookShopConsoleUI {
    Container<PaperLiterature> booklist, basket;

    public BookShopConsoleUI(){
        booklist = new Container<PaperLiterature>();
        basket = new Container<PaperLiterature>();
    }

    public int generateRandom(int min, int max){
        return (int)( Math.random() * (max - min + 1) + min);
    }
    public void Generate() throws ContainerException, ProductException{
        // объявление массивов книг и комиксов заданного ранее размера
        Book[] bs = new Book[5];
        Comics[] cmcs = new Comics[6];
        // генерация данных и заполнение статических полей Печатной литературы(предок)
        for(int i = 0; i< bs.length; i++){
            int j = i+ 1;
            bs[i] = new Book("BookName "+ j, generateRandom(0, j* 100), generateRandom(0, j* 100), generateRandom(0, j* 1000), "AuthorName "+ generateRandom(1, j));
            Book.Add(bs[i]);
            booklist.Add(bs[i]);
        }
        // генерация данных и заполнение статических полей Печатной литературы(предок)
        for(int i = 0; i< cmcs.length; i++){
            int j = i+ 1;
            cmcs[i] = new Comics("ComicsName "+j, generateRandom(0, j* 115), "IllustratorName "+ generateRandom(1, j), generateRandom(10,  50) );
            Comics.Add(cmcs[i]);
            booklist.Add( cmcs[i]);
        }

    }

    /**
     * печать списка продукции
     * */
    public void PrintBookList(){
        Scanner inp = new Scanner(System.in);
        System.out.print("""
                Enter type of sort:
                * AscDesc - true - возростающий порядок
                * AscDesc - false - нисходящий порядок
                -> """);
        booklist.Sort(inp.nextBoolean());
        booklist.Print();
    }

    /**
     * печать списка покупок
     * */
    public void PrintBasket(){
        Scanner inp = new Scanner(System.in);
        System.out.print("""
                Enter type of sort:
                * AscDesc - true - возростающий порядок
                * AscDesc - false - нисходящий порядок
                -> """);
        basket.Sort(inp.nextBoolean());
        basket.Print();
    }

    /**
     * получение информации в виде строк
     * */
    private String []FillOneBook(String [] fields){
        String [] data = new String[fields.length];
        Scanner inp = new Scanner(System.in);
        for(int i = 0; i< fields.length;i++)
        {
            System.out.println("Enter "+ fields[i]+ ": ");
            data[i] = inp.nextLine();
        }
        return data;
    }

    /**
     * свитч для книг и комиксов
     * */
    private PaperLiterature CreateBook (int type) throws ProductException{
        PaperLiterature book = null;
        switch(type){
            case 1:
                book= new Book();
                book = new Book(FillOneBook(book.GetFieldNames()));
            break;
            case 2:
                book= new Comics();
                book = new Comics(FillOneBook(book.GetFieldNames()));
            break;
        }

        return book;
    }

    /**
     * добавление бумажной литературы в контейнер
     * */
    private void AddNewBook() throws ContainerException, ProductException{
        String[] types = new String[]{"1 - Books", "2 - Comics"};
        Scanner inp = new Scanner(System.in);
        System.out.println("Select type of added literature");
        for (String s:
             types) {
            System.out.println(s);
        }
        System.out.print("-> ");
        booklist.Add(CreateBook(inp.nextInt()));
    }

    /**
     * добавление бумажной литературы в корзину
     * */
    private void AddBooksToBasket(PaperLiterature book, int quantity) throws ContainerException{
        for(int i = 0; i< quantity; i++)
            basket.Add(book);

    }

    /**
     * выбор книг которые нужно передать в метод выше
     * */
    private void SelectBooksToAddToBasket() throws ContainerException{
        Scanner inp = new Scanner(System.in);
        int index = -1, quantity = -1;
        System.out.println("Select literature to add to the basket:");
        System.out.print(booklist.toString());
        System.out.print("-> ");
        index = inp.nextInt();
        System.out.println("Input quantity:");
        System.out.print("-> ");
        quantity = inp.nextInt();
        AddBooksToBasket(booklist.getByIndex(index), quantity);

    }

    /**
     * покупка книгв корзине
     * */
    private void Buy(){
        basket.FillStaticVars();
        System.out.println("You bought "+PaperLiterature.GetBooksCount() + " books.");
        System.out.println("COST: "+ PaperLiterature.GetAllBooksCost());
        basket.DeleteStaticVars();
        ClearBasket();

    }

    /**
     * очистка корзины
     * */
    private void ClearBasket(){
        basket.Clear();
        System.out.println("Basket Cleared");
    }

    /**
     * свитч для выбора используемого метода
     * (на самом деле, будь это шарп,
     * то я бы смог использовать делегаты,
     * и это намного мне упростило жизнь)
     * */
    private boolean SwitchMethod(int selectedMethod)throws ContainerException, ProductException {
        switch (selectedMethod){
            case 1:  PrintBookList(); return false;
            case 2:  SelectBooksToAddToBasket(); return false;
            case 3:  PrintBasket(); return false;
            case 4:  Buy();  return false;
            case 5:  ClearBasket(); return false;
            case 6:  AddNewBook();  return false;
            default: return true;
        }
    }
    /**
     * основная функция класса,
     * которая реализовывает взаимодействие между пользователем и всеми классами в проекте
     * */
    public void SelectAction() throws ContainerException, ProductException, FileNotFoundException, IOException, ClassNotFoundException {
        Scanner inp = new Scanner(System.in);
        booklist.Deserialization("bookList");
        for(;;){
            System.out.print("""
                    1 - Literature available
                    2 - Add books to basket
                    3 - Basket
                    4 - Buy books in Basket
                    5 - Clear Basket
                    6 - Add new Literature
                    7 - Exit
                    -> """);
            if(SwitchMethod(inp.nextInt())){
                System.out.println("Stopped virtual Shop");
                if(booklist.Empty())// просто на всякий случай, если программа сломается
                    Generate();
                booklist.Serialization("bookList");
                inp.nextLine();
                return;
            }
        }

    }
}
