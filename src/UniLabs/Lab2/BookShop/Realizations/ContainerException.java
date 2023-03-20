package UniLabs.Lab2.BookShop.Realizations;

public class ContainerException extends Exception{
    private int exceptionValue;
    public ContainerException(final int ind){
        exceptionValue = ind;
    }
    public String toString(){
        return this.getClass().getName()+":\t"+ Float.toString(exceptionValue);
    }

}
