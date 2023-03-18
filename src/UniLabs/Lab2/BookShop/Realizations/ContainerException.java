package UniLabs.Lab2.BookShop.Realizations;

public class ContainerException extends Exception{
    private int exceptionValue;
    public ContainerException(final int ind){
        exceptionValue = ind;
    }
    public ContainerException(final float ind){
        exceptionValue = (int)ind;
    }
    public ContainerException(final ContainerException c){
        this.exceptionValue = c.exceptionValue;
    }
    public String toString(){
        return this.getClass().getName()+":\t"+ Float.toString(exceptionValue);
    }

}
