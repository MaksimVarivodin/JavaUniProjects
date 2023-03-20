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
    public T getByIndex(final int index) throws ContainerException {
        if (index < 0 || index >=  array.length) {
            throw new  ContainerException(index);
        } else
            return array[index];

    }

    /**
     * вставка(в конец)
     */
    public void Add(final T element) throws ContainerException {
        if(array == null){
                AddByIndex(element, 0);
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
            buffer = (T[]) new IPaperLit[array.length + 1];

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
            buffer = (T[]) new IPaperLit[1];
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
            Delete(array.length - 1);

    }

    /**
     * удаление по индексу
     */
    public void Delete(final int index) throws ContainerException{
        // создаем новый массив
        T[] buffer = (T[]) new IPaperLit[array.length - 1];

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
                AddByIndex(element, 0);
        else {
            array[index] = element;
        }

    }    /**
     * печать массива
     */
    public void Print() {
        if(array == null)
            System.out.println("Array is Empty");
        else
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
