package UniLabs.Lab1;

/**
 *
 * класс контейнера
 *
 * */
public class Container<T> {
    /**
     *
     *      поле массива
     *
     * */
    private T[] array;

    public int length;

    /**
     *
     *      получить элемент по индексу
     *
     * */
    public T getByIndex(final int index){
        if(array.length > 0 && (index < array.length && index >= 0)){
            return array[index];
        } else {
            return null;
        }
    }

    /**
     *
     *      вставка(в конец)
     *
     *  */
    public void Add(final T element){
        AddByIndex(element, array.length);
    }

    /**
     *
     *      вставка по индексу
     *
     * */
    public void AddByIndex(final T elem, final int index){
        T[]buffer;
        // создаем новый массив
        if(array != null){
            buffer  = (T[]) new Object[array.length+ 1];
            int position = index;
            // предусматриваем варианты
            // когда индекс выходит за
            // рамки массива
            if(position < 0)
                position = 0;
            else if (position >= array.length){
                position = array.length;
            }
            // заполняем новый массив
            for(int i = 0; i< position; i++)
                buffer[i] = array[i];
            buffer[position] = elem;
            for(int i = position; i < array.length; i++)
                buffer[i+1] = array[i];
        }else {
            buffer = (T[]) new Object[1];
            buffer[0] = elem;
        }

        // сохраняем новый массив
        array = buffer;
        length = array.length;
        // триггерим сборщик муссора
        System.gc();
    }

    /**
     *
     *      удаление из конца
     *
     * */
    public void Delete(){
        Delete(array.length);
    }

    /**
     *
     *      удаление по индексу
     *
     * */
    public void Delete (final int index){
        // создаем новый массив
        T[]buffer  = (T[]) new Object[array.length - 1];
        int position = index;
        // предусматриваем варианты
        // когда индекс выходит за
        // рамки массива
        if(position < 0)
            position = 0;
        else if (position >= array.length){
            position = array.length - 1;
        }
        // заполняем новый массив
        for(int i = 0; i< position; i++)
            buffer[i] = array[i];
        for(int i = position+ 1; i < array.length; i++)
            buffer[i -1] = array[i];
        // сохраняем новый массив
        array = buffer;
        length = array.length;
        // триггерим сборщик муссора
        System.gc();
    }

    public void Print(){

        for (T variable: array
             ) {
            System.out.println(variable);
        }
    }
    public void Swap(T a, T b){
        T buffer = a;
        a = b;
        b = buffer;
    }
    public void Swap(final int index1, final int index2){
        T buffer = array[index1];
        array[index1] = array[index2];
        array[index2] = buffer;
    }
    public void Clear(){
        array = null;
        length = 0;
    }
}
