package UniLabs.Lab2.BookShop.Interfaces;

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
    void setPrice(float price);
    /**
     *      преобразование в строку
     * */
    @Override
    String toString();
}
