package UniLabs.Lab3.BookShop.Realizations;

import UniLabs.Lab3.BookShop.Interfaces.IPaperLit;

/**
 *
 *      абстрактный класс-родитель — бумажная литература
 *
 */

public abstract class PaperLiterature implements IPaperLit {

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
     *      конструктор по умолчанию
     * */

    public PaperLiterature(){};
    /**
     *      геттер цены
     * */
    @Override
    public float getPrice() {
        return price;
    }

    /**
     *      геттер имени
     * */
    @Override
    public String getName() {
        return name;
    }

    /**
     *      сеттер имени
     * */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     *      сеттер цены
     * */
    @Override
    public void setPrice(float price) throws ProductException {
        if(price < 0.0)
            throw new ProductException(price);
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
