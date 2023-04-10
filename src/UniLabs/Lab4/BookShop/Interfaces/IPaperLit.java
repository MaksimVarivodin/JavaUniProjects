package UniLabs.Lab4.BookShop.Interfaces;

import UniLabs.Lab4.BookShop.Realizations.ProductException;

import java.io.Serializable;

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
}
