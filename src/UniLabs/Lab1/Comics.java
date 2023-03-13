package UniLabs.Lab1;

/**
 *      комиксы
 * */
public class Comics extends PaperLiterature {

    /**
     *      страницы
     * */
    private int pages;

    /**
     *      илюстратор
     * */
    private String Illustrator;

    /**
     *      конструктор с двумя параметрами(для родительского класса)
     * */
    public Comics (final String name, final float price){
        super(name, price);
    }

    /**
     *      конструктор с двумя параметрами
     * */
    public Comics(final String Illustrator, final int pages){
        super();
        this.Illustrator = Illustrator;
        this.pages = pages;
    }

    /**
     *      конструктор для заполнения всех полей
     * */
    public Comics(final String name, final float price, final String Illustrator, final int pages){
        this(name, price);
        this.Illustrator = Illustrator;
        this.pages = pages;
    }

    /**
     *      конструктор по умолчанию
     * */
    public Comics(){
        this(null, 0);
    }

    /**
     *      получение страниц
     * */
    public int getPages() {
        return pages;
    }

    /**
     *      получение иллюстратора
     * */
    public String getIllustrator() {
        return Illustrator;
    }

    /**
     *      сеттер для страниц
     * */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     *      сеттер для иллюстратора
     * */
    public void setIllustrator(String illustrator) {
        this.Illustrator = illustrator;
    }

    /**
     *      преобразование в строку
     * */
    @Override
    public String toString(){
        return super.toString()+ "|\t"+ pages + " pages, Illustrator: "+ Illustrator;
    }


}
