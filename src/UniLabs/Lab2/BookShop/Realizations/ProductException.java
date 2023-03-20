package UniLabs.Lab2.BookShop.Realizations;

public class ProductException extends Exception{
    private float exceptionValue;
    public ProductException(final float a){
        exceptionValue = a;
    }
    public String toString(){
        return this.getClass().getName()+":\t"+ Float.toString(exceptionValue);
    }
}
