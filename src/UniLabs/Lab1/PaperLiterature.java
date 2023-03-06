package UniLabs.Lab1;

/**
 *
 *      абстрактный класс-родитель — бумажная литература
 *
 */

public abstract class PaperLiterature {

    /**
     *
     *      поле имени книги
     *
     * */
    protected String name;

    /**
     *
     * поле цены книги
     *
     * */
    protected float price;

    /**
     *
     *      статическое поле - общая стоимость всех экземпляров книг-наследников
     *
     * */
    private static float AllBooksCost;

    /**
     *
     *      статическая переменная — счетчик экземпляров книг-наследников
     *
     * */
    private static int BooksCount;

    /**
     *
     *      статическая переменная - контейнер всех книг
     *
     * */
    private static Container<PaperLiterature> books;

    /**
     *
     *      конструктор с двумя аргументами
     *
     * */
    public PaperLiterature(String name, float price){
        this.name = name;
        this.price = price;
    };

    /**
     *
     *      конструктор по умолчанию
     *
     * */
    public PaperLiterature(){
        this.name = "name";
        this.price = 0.0f;
    }

    /**
     *
     *      геттер цены
     *
     * */
    public float getPrice() {
        return price;
    }

    /**
     *
     *      геттер имени
     *
     * */
    public String getName() {
        return name;
    }

    /**
     *
     *      сеттер имени
     *
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     *      сеттер цены
     *
     * */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *
     *      преобразование в строку
     *
     * */
    @Override
    public String toString(){
        return "Price:\t"+ price + "\tName:\t"+ name+ "\t";
    }

    /**
     *
     *      посчитать среднее
     *
     * */
    public static float CountAverage(){
        return AllBooksCost/((float)BooksCount);
    }

    /**
     *
     *      добавление книги в конец массива
     *
     * */
    public static void Add(PaperLiterature b){
        int index = 0;
        if (books != null)
            index = books.length;
        else {
            books = new Container<PaperLiterature>();
        }
        AddByIndex(b, index);
    }

    /**
     *
     *      добавление книги по индексу
     *
     * */
    public static void AddByIndex(final PaperLiterature b, final int index){
        AllBooksCost += b.price;
        BooksCount++;
        books.AddByIndex(b, index);
    }

    /**
     *
     *      удаление из конца массива
     *
     * */
    public static void Delete(){
        DeleteByIndex(books.length - 1);
    }

    /**
     *
     *      удаление по индексу
     *
     * */
    public static void DeleteByIndex(final int index){
        AllBooksCost -= books.getByIndex(index).price;
        BooksCount--;
        books.Delete(index);
    }

    /**
     *
     *  сортировка
     *  AscDesc - true - возростающий порядок
     *  AscDesc - false - нисходящий порядок
     *
     * */
    public static void Sort(boolean AscDesc){
        for (int i = 0; i< books.length -1; i++){
            for(int j = 0; j< books.length - i -1; j++){
                float p1 = books.getByIndex(j).getPrice(),
                      p2 = books.getByIndex(j+ 1).getPrice();
                if ((AscDesc && p1 > p2)|| (!AscDesc && p1 < p2))
                    books.Swap(j, j+1);
            }
        }
    }

    /**
     *
     *      печать массива
     *
     * */
    public static void Print(){
        books.Print();
    }

    /**
     *
     *      очистка массива
     *
     * */
    public static void Clear(){
        books.Clear();
        AllBooksCost = 0;
        BooksCount = 0;
        System.gc();
    }
}
