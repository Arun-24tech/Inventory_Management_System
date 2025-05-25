package dao;

import model.Item;
import util.DBConnection;
import java.sql.*;
import java.util.*;

/**
 * Implementation of DAO using JDBC and MySQL.
 */
public class ItemDAOImpl implements dao.ItemDAO {

    @Override
    public void addItem(Item item) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO items (name, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM items");
            while (rs.next()) {
                list.add(new Item(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void updateItem(Item item) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE items SET name=?, quantity=?, price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, item.getName());
            ps.setInt(2, item.getQuantity());
            ps.setDouble(3, item.getPrice());
            ps.setInt(4, item.getId());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void deleteItem(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM items WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }
}
