package UniLabs.Lab3.BookShop.Realizations;

import UniLabs.Lab3.BookShop.Interfaces.IPaperLit;

import java.util.Enumeration;

import java.util.NoSuchElementException;

/**
 *      класс контейнера
 * */
public class Container<T extends IPaperLit> {
    /**
     * поле массива
     */
    private T[] array;
    class Enumerator implements Enumeration{
        private int position = array.length;

        @Override
        public boolean hasMoreElements()
        {
            return position > 0;
        }

        @Override
        public Object nextElement() throws NoSuchElementException
        {
            if(position == 0)
                throw new NoSuchElementException("Container");
            return array[--position];
        }


    }
    public Enumeration elements()
    {
        return new Enumerator();
    }
    public Enumeration PriceFilter(final float minPrice, final float maxPrice)
    {

        return new Enumeration(){
            Enumeration en = elements();
            int current = array.length;
            /**
             * тут мы ищем елементы которые входят в пределы
             * */
            @Override
            public boolean hasMoreElements()
            {
                while(en.hasMoreElements())
                {
                    T obj = (T)en.nextElement();
                    current--;
                    if(obj.getPrice() >= minPrice && obj.getPrice()<= maxPrice){
                        return true;
                    }
                }
                current = -1;
                return false;
            }
            /**
             * тут мы возвращаем елементы
             * */
            @Override
            public Object nextElement() throws NoSuchElementException
            {
                if(current == -1){
                    throw new NoSuchElementException("Container");
                }
                return array[current];
            }
        };
    }
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
            throw new ContainerException(index);
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
    public void AddByIndex(final T elem, final int index) throws ContainerException {
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
    public void Delete(final int index) throws ContainerException {
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
    public void SetByIndex(int index, T element) throws ContainerException {
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
