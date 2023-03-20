package UniLabs.Lab2.BookShop.Realizations;

import UniLabs.Lab2.BookShop.Interfaces.IComics;

/**
 *      комиксы
 * */
public class Comics extends PaperLiterature implements IComics {

    /**
     *      страницы
     * */
    private int pages;

    /**
     *      илюстратор
     * */
    private String Illustrator;




    /**
     *      конструктор для заполнения всех полей
     * */
    public Comics(final String name, final float price, final String Illustrator, final int pages)throws ProductException{

        super.setPrice(price);
        super.setName(name);
        this.Illustrator = Illustrator;
        this.pages = pages;
    }

    /**
     *      конструктор по умолчанию
     * */
    public Comics(){}

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
