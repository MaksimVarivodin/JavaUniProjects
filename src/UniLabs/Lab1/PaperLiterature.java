package UniLabs.Lab1;

/**
 *
 *      абстрактный класс-родитель — бумажная литература
 *
 */

public abstract class PaperLiterature {

    /**
     *      поле имени книги
     * */
    protected String name;

    /**
     *      поле цены книги
     * */
    protected float price;
    // BigDecimal
    /**
     *      статическое поле - общая стоимость всех экземпляров книг-наследников
     * */
    private static float AllBooksCost;

    /**
     *      статическая переменная — счетчик экземпляров книг-наследников
     * */
    private static int BooksCount;

    /**
     *      конструктор с двумя параметрами
     * */
    public PaperLiterature(String name, float price){
        this.name = name;
        this.price = price;
    };

    /**
     *      конструктор по умолчанию
     * */
    public PaperLiterature(){};
    /**
     *      геттер цены
     * */
    public float getPrice() {
        return price;
    }

    /**
     *      геттер имени
     * */
    public String getName() {
        return name;
    }

    /**
     *      сеттер имени
     * */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *      сеттер цены
     * */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     *      преобразование в строку
     * */
    @Override
    public String toString(){
        return "Price:\t"+ price + "\tName:\t"+ name+ "\t";
    }

    /**
     *      посчитать среднее
     * */
    public static float CountAverage(){
        return AllBooksCost/((float)BooksCount);
    }

    /**
     *      добавление книги в конец массива
     * */
    public static void Add(PaperLiterature b){
        AllBooksCost += b.price;
        BooksCount++;
    }

    /**
     *      удаление из конца массива
     * */
    public static void Delete(PaperLiterature b){
        AllBooksCost -= b.price;
        BooksCount--;
    }
}
