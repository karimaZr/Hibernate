
package ma.project.dao;

import java.util.List;


public interface IDao <T>{
   boolean create(T O);
   boolean update(T O);
   boolean delete(T o);
   List<T> getAll();
   T getById(int id);
    
}
