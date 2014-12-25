package kodou.service;

import java.util.List;

/**
 * The base interface for services
 */
public interface Service<T> {

    public T insert(T object);
    public T read();
    public T update(T object);
    public void delete(T object);
    public List<T> readAll();

}
