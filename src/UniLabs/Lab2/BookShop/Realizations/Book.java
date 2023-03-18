package UniLabs.Lab2.BookShop.Realizations;

import UniLabs.Lab2.BookShop.Interfaces.IBook;

/**
 *      книга (печатная)
 * */
public class Book extends PaperLiterature implements IBook  {

    /**
     *      поле страниц
     * */
    private int pages;

    /**
     *      поле количества слов
     * */
    private int words;

    /**
     *      поле ФИО автора
     * */
    private String authorName;

   /**
    *       конструктор с 5-ю параметрами
    * */
    public Book(final String name, final float price, final int pages, final int words, final String authorName) throws ProductException{
        /*
        *
        * в этот конструктор заход происходит из любого другого конструктора в классе,
        * что позволяет расссчитывать статические поля без отдельного метода
        *
        * */
        try{
            super.setName(name);
            super.setPrice(price);
        }catch (ProductException p){
            throw new ProductException(p);
        }

        this.pages= pages;
        this.words = words;
        this.authorName = authorName;
    }

    /**
     *      конструктор с 3-мя параметрами
     * */

    /**
     *      конструктор по умолчанию
     * */
    public Book (){
    }


    /**
     *      геттер страниц
     * */
    public int getPages() {
        return pages;
    }

    /**
     *      геттер кол-ства слов
     * */
    public int getWords() {
        return words;
    }

    /**
     *      геттер ФИО
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     *      сеттер ФИО
     * */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     *      сеттер страниц
     * */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     *      сеттер кол-ства слов
     * */
    public void setWords(int words) {
        this.words = words;
    }

    /**
     *      преобразование в строку
     * */
    @Override
    public String toString(){ return super.toString() +"|\t" + pages+ " pages, "+ words + " words, Author: "+ authorName;};

}
