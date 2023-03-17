package UniLabs.Lab2.BookShop.Interfaces;

public interface IComics extends IPaperLit {
    /**
     *      получение страниц
     * */
    int getPages() ;

    /**
     *      получение иллюстратора
     * */
    String getIllustrator();

    /**
     *      сеттер для страниц
     * */
    void setPages(int pages);

    /**
     *      сеттер для иллюстратора
     * */
    void setIllustrator(String illustrator);

    /**
     *      преобразование в строку
     * */
    @Override
    String toString();


}