package dao;

import entity.Company;

import java.util.List;

public interface SuperDAO {
     List<Object> getAll();
     Object get(String pk);
     boolean save(Object object);
     boolean delete(String pk);
     boolean update(Object object);
}
