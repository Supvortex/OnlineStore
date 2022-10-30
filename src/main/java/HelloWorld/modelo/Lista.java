package HelloWorld.modelo;
import java.util.ArrayList;
import java.util.Iterator;

public class Lista<T> implements Iterable<T>{
    protected ArrayList<T> Listaa;
    public Lista() {
        Listaa = new ArrayList<>();
    }
    public int size() {
        return this.Listaa.size();
    }
    public void add(T t) {
        this.Listaa.add(t);
    }
    public void remove(T t) {
        this.Listaa.remove(t);
    }
    public T get(int position) {
        return this.Listaa.get(position);
    }
    public void clear() {
        this.Listaa.clear();
    }
    public boolean isEmpty() {
        return this.Listaa.isEmpty();
    }
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrLista = new ArrayList<>(Listaa);
        return arrLista;
    }
    @Override
    public Iterator<T> iterator() {
        return this.Listaa.iterator();
    }
}
