package UniLabs.Lab2.BookShop.Realizations;

import UniLabs.Lab2.BookShop.Interfaces.IPaperLit;

/**
 *      класс контейнера
 * */
public class Container<T extends IPaperLit> {
    /**
     * поле массива
     */
    private T[] array;

    public int  getLength(){
        return  array.length;
    }

    /**
     * конструктор с параметрами
     */
    public Container(T[] array) {
        this.array = array;
    }
    public Container(int l){
        this.array = (T[]) new Object[l];
    }
    /**
     * конструктор по умолчанию
     */
    public Container() {
        T[] array = null;

    }

    /**
     * получить элемент по индексу
     */
    public T getByIndex(final int index) {
        if (array.length > 0 && (index < array.length && index >= 0)) {
            return array[index];
        } else {
            return null;
        }
    }

    /**
     * вставка(в конец)
     */
    public void Add(final T element) throws ContainerException {
        if(array == null){
            try{
                AddByIndex(element, 0);
            }catch(ContainerException c){
                throw new ContainerException(c);
            }

        }
        else AddByIndex(element, array.length - 1);

    }

    /**
     * вставка по индексу
     */
    public void AddByIndex(final T elem, final int index) throws ContainerException  {
        T[] buffer = null;
        // создаем новый массив
        if (array != null) {
            buffer = (T[]) new Object[array.length + 1];

            // предусматриваем варианты
            // когда индекс выходит за
            // рамки массива
            if (index < 0 || index >= array.length)
                throw new ContainerException(index);
            // заполняем новый массив
            for (int i = 0; i < index; i++)
                buffer[i] = array[i];
            buffer[index] = elem;
            for (int i = index; i < array.length; i++)
                buffer[i + 1] = array[i];
        } else {
            buffer = (T[]) new Object[1];
            buffer[0] = elem;
        }

        // сохраняем новый массив
        array = buffer;
    }

    /**
     * удаление из конца
     */
    public void Delete() throws ContainerException {
        if (array != null)
            try{
                Delete(array.length - 1);
            }catch (ContainerException c){
                throw new ContainerException(c);
            }

    }

    /**
     * удаление по индексу
     */
    public void Delete(final int index) throws ContainerException{
        // создаем новый массив
        T[] buffer = (T[]) new Object[array.length - 1];

        // предусматриваем варианты
        // когда индекс выходит за
        // рамки массива
        if (index < 0 || index >= array.length)
            throw new ContainerException(index);
        // заполняем новый массив
        for (int i = 0; i < index; i++)
            buffer[i] = array[i];
        for (int i = index + 1; i < array.length; i++)
            buffer[i - 1] = array[i];
        // сохраняем новый массив
        array = buffer;
    }
    public void SetByIndex(int index, T element) throws ContainerException{
        // предусматриваем варианты
        // когда индекс выходит за
        // рамки массива
        if (index < 0 || index >= array.length)
            throw new ContainerException(index);
        if (array == null)
            try{
                AddByIndex(element, 0);
            } catch(ContainerException c){
                throw new ContainerException(c);
            }
        else {
            array[index] = element;
        }

    }    /**
     * печать массива
     */
    public void Print() {

        for (T variable : array )
        {
            System.out.println(variable);
        }
    }

    /**
     * обмен элементов по индексу
     */
    protected void Swap(final int index1, final int index2) {
        T buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }

    /**
     * зануление полей класса, триггеринг gc()
     */
    public void Clear() {
        array = null;
    }

    /**
     * сортировка
     * AscDesc - true - возростающий порядок
     * AscDesc - false - нисходящий порядок
     */
    public void Sort(boolean AscDesc) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                float p1 = array[j].getPrice(),
                      p2 = array[j + 1].getPrice();
                if ((AscDesc && p1 > p2) || (!AscDesc && p1 < p2))
                    Swap(j, j + 1);
            }
        }

    }
}
