package UniLabs.Lab2.BookShop.Interfaces;

import UniLabs.Lab2.BookShop.Realizations.ProductException;

public interface IPaperLit {
    /**
     *      геттер цены
     * */
    float getPrice();
    /**
     *      геттер имени
     * */
    String getName();
    /**
     *      сеттер имени
     * */
    void setName(String name);

    /**
     *      сеттер цены
     * */
    void setPrice(float price) throws ProductException;
    /**
     *      преобразование в строку
     * */
    @Override
    String toString();
}
