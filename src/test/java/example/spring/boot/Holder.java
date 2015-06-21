package example.spring.boot;

public interface Holder<T> {

    T get();

    T set(T object);
}
