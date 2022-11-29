package HelloWorld.modelo;
import java.util.ArrayList;
import java.util.Iterator;

public class Lista<T> implements Iterable<T>{
    public void addAll (Lista<T> lista) {
        for(T element : lista){
            this.Lista.add(element);
        }
    }
    protected ArrayList<T> Lista;
    public Lista() {
        Lista = new ArrayList<>();
    }
    public int size() {
        return this.Lista.size();
    }
    public void add(T t) {
        this.Lista.add(t);
    }
    public void remove(T t) {
        this.Lista.remove(t);
    }
    public T get(int position) {
        return this.Lista.get(position);
    }
    public void clear() {
        this.Lista.clear();
    }
    public boolean isEmpty() {
        return this.Lista.isEmpty();
    }
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrLista = new ArrayList<>(Lista);
        return arrLista;
    }
    @Override
    public Iterator<T> iterator() {
        return this.Lista.iterator();
    }
}
