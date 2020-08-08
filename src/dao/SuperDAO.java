package dao;

import entity.Company;

import java.util.List;

public interface SuperDAO {
     List<Object> getAll();
     Object get(Object pk);
     boolean save(Object object);
     boolean delete(Object pk);
     boolean update(Object object);
}
