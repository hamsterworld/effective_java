package effective.java.item18.ch1;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 그래서 전달 class ,forwarding class,wrapper class , decorator pattern 이라고도한다.
 */
public class ForwardingSet<E> implements Set<E> {

    //Set 의 기능은 기능대로 사용하는 중이다.
    private final Set<E> s;


    public ForwardingSet(Set<E> s) {
        this.s = s;
    }

    // 아래처럼 구현체는 s로 전달하고있다.
    @Override
    public int size() {
        int size = s.size();
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = s.isEmpty();
        return empty;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return s.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> c) {
        return s.addAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
