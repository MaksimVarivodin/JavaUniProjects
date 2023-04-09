package UniLabs.Lab3.BookShop.Interfaces;

public interface IBook extends IPaperLit {
    /**
     *      геттер страниц
     * */
    int getPages() ;

    /**
     *      геттер кол-ства слов
     * */
    int getWords() ;

    /**
     *      геттер ФИО
     */
    String getAuthorName() ;

    /**
     *      сеттер ФИО
     * */
    void setAuthorName(String authorName) ;

    /**
     *      сеттер страниц
     * */
    void setPages(int pages) ;

    /**
     *      сеттер кол-ства слов
     * */
    void setWords(int words) ;


}
