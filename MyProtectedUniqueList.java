import java.util.*;

public class MyProtectedUniqueList<T> implements Iterable<T>{
    private List<T> words;
    private T password;
    private MyProtectedUniqueListIterator myProtectedUniqueListIterator = new MyProtectedUniqueListIterator(this);

    public MyProtectedUniqueList(T password) {
        this.password = password;
        this.words = new ArrayList<T>();
    }

    public void add(T word, T password) throws WrongInput, WrongPassword {
        if(checkPassword(password)) {
            if(word == null || word.equals("")) {
                throw new WrongInput("wrong input");
            }
            if(!this.words.contains(word)) {
                this.words.add(word);
            }
        }
        else {
            throw new WrongPassword("wrong password");
        }
    }

    public void remove(T word, T password) throws WrongInput, WrongPassword {
        if(checkPassword(password)) {
            if(word == null || word.equals("")) {
                throw new WrongInput("wrong input");
            }
            if(this.words.contains(word)) {
                this.words.remove(word);
            }
        }
        else {
            throw new WrongPassword("wrong password");
        }
    }

    public void removeAt(int index) throws WrongIndex, WrongPassword {
        if(checkPassword(this.password)) {
            if(index < 0 || index > this.words.size()) {
                throw new WrongIndex("wrong index");
            }
            this.words.remove(index);
        }
        else {
            throw new WrongPassword("wrong password");
        }
    }

    public void clear(T password) throws WrongPassword {
        if(checkPassword(password)) {
            this.words.clear();
        }
        else {
            throw new WrongPassword("wrong password");
        }
    }

    public void sort(T password) throws WrongPassword {
        if(checkPassword(password)) {
            Collections.sort(this.words, new Comparator<T>() {
                @Override
                public int compare(T string1, T string2) {
                    //return string1.compareTo(string2); // you told me to move on, put in comment for compilation
                    return 0;// just for compilation
                }
            });
        }
        else {
            throw new WrongPassword("wrong password");
        }
    }

    private boolean checkPassword(T password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "MyProtectedUniqueList{" +
                "words=" + this.words +
                ", key='" + this.password + '\'' +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return this.myProtectedUniqueListIterator;
    }

    private class  MyProtectedUniqueListIterator implements Iterator<T> {
        private MyProtectedUniqueList<T> list;
        private int index;

        public MyProtectedUniqueListIterator(MyProtectedUniqueList list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (this.index < list.words.size());
        }

        @Override
        public T next() {
            return list.words.get(index++);
        }
    }
}

class WrongInput extends Exception {
    public WrongInput(String msg) {
        super(msg);
    }
}

class WrongIndex extends Exception {
    public WrongIndex(String msg) {
        super(msg);
    }
}

class WrongPassword extends Exception {
    public WrongPassword(String msg) {
        super(msg);
    }
}


