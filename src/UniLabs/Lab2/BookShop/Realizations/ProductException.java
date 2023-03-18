package UniLabs.Lab2.BookShop.Realizations;

public class ProductException extends Exception{
    private float exceptionValue;
    public ProductException(final float a){
        exceptionValue = a;
    }
    public ProductException(final int a){
        exceptionValue = (float)a;
    }
    public ProductException(final ProductException p){
        this.exceptionValue = p.exceptionValue;
    }
    public String toString(){
        return this.getClass().getName()+":\t"+ Float.toString(exceptionValue);
    }
}
