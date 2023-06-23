package service;


import Exceptions.ElementDoesntExistException;
import Exceptions.IndexIsOutOfBoundsException;
import Exceptions.IndexIsTakenException;
import Exceptions.StringListIsFullException;

public class StringListImpl implements StringList {
    private String[] arrayString;
    private int size;
    private int counter;

    public StringListImpl(int size) {
        this.size = size;
        arrayString = new String[size];
        counter = 0;

    }

    @Override
    public String[] getStringList() {
        return new String[0];
    }

    @Override
    public String add(String item) {
        checkIfNull(item);
        if ((counter) == this.size) {
            throw new StringListIsFullException();
        } else {
            arrayString[counter] = item;
            counter++;
        }
        return item ;
    }

    @Override
    public String add(int index, String item) {
        checkIfNull(item);
        if (index < 0 || index > counter)
            throw new IndexIsOutOfBoundsException();
        else if (arrayString[index] != null) {
            throw new IndexIsTakenException();
        } else
            arrayString[index] = item;

        return arrayString[index];
    }

    @Override
    public String set(int index, String item) {
        checkIfNull(item);

        if (index > size() || index > this.size || index < 0)
            throw new IndexIsOutOfBoundsException();
        arrayString[index] = item;

        return arrayString[index];
    }

    @Override
    public String remove(String item) {
        checkIfNull(item);


        if (!(contains(item)))
            throw new ElementDoesntExistException();
        else {
            remove(indexOf(item));
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String removed;
        if ( index > counter || (index<0))
            throw new IndexIsOutOfBoundsException();
        else {
            removed = arrayString[index];
            for (int i = index; i <= counter; i++) {
                arrayString[i] = arrayString[i + 1];
            }
            counter--;
        }
        return removed;
    }

    @Override
    public boolean contains(String item) {
        checkIfNull(item);

        boolean result = false;

        for (int i = 0; i < counter; i++) {
            if (arrayString[i].equals(item)) {
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public int indexOf(String item) {
        checkIfNull(item);


        int result = -1;
        for (int i = 0; i < counter; i++) {
            if (arrayString[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(String item) {
        checkIfNull(item);

        int result = -1;
        for (int i = counter-1; i >= 0; i--) {
            if (arrayString[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index > counter)
            throw new IndexIsOutOfBoundsException();

        return arrayString[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        String[] otherArray = otherList.toArray();

        for (int i = 0; i < otherList.size(); i++) {
            if (!(otherArray[i].equals(arrayString[i]))) {
                return false;
            }

        }

        return true;
    }

    @Override
    public int size() {
        return (counter );
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        if (counter==0)
            throw new ElementDoesntExistException();
        for (int i = 0; i <= counter; i++) {
            remove(i);
        }


    }

    @Override
    public String[] toArray() {
        return arrayString.clone();
    }

    private void checkIfNull(String item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }
}
