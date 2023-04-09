package UniLabs.Lab3.BookShop.Interfaces;

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


}
