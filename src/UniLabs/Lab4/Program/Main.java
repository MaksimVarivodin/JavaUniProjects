package UniLabs.Lab4.Program;

import UniLabs.Lab4.BookShop.Realizations.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    /**
     *      мейн
     * */
    public static void main(String[] args) {

        BookShopConsoleUI ui = new BookShopConsoleUI();
        try{
            // основная функция работы интерфейса программы
            ui.SelectAction();
        }catch (ProductException p){
            System.out.println(p);
        }catch (ContainerException c){
            System.out.println(c);
        }catch (FileNotFoundException e) {
            System.out.println("File not found : "+ e);
            throw new RuntimeException(e);
        } catch (IOException ioe) {
            System.out.println("Error while writing data : "+ ioe);
            ioe.printStackTrace();
        }catch (ClassNotFoundException classntf){
            System.out.println(classntf);
        }


    }
}