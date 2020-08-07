package dao;

import entity.Item;

import java.util.List;

public interface ItemDAO {
    public List<Item> getAllItems();
    public  Item getItem(String itemCode);
    public  boolean saveItem(Item item);
    public  boolean deleteItem(String itemId);
    public  boolean updateItem(Item item);



}
