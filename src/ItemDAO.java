package dao;

import model.Item;
import java.util.List;

/**
 * DAO Interface defining CRUD operations for inventory items.
 */
public interface ItemDAO {
    void addItem(Item item);
    List<Item> getAllItems();
    void updateItem(Item item);
    void deleteItem(int id);
}
