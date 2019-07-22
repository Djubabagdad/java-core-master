package mainProject.daoClasses;

import mainProject.jdbc.AbstractDAO;
import mainProject.jdbc.ConnectorDB;
import mainProject.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends AbstractDAO {

    public static final String SQL_SELECT_ALL_PRODUCT = "SELECT * FROM product";
    public static final String SQL_SELECT_PRODUCT_NAME =
            "SELECT * FROM product where name=?";
    public static final String SQL_SELECT_PRODUCT_RATE =
            "SELECT * FROM product where rate=?";
    public static final String SQL_SELECT_PRODUCT_PRICE =
            "SELECT * FROM product where price=?";
    public static final String SQL_SELECT_PRODUCT_CATEGORY_ID =
            "SELECT * FROM product where category_id=?";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_PRODUCT);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int categoryId = rs.getInt(3);
                double rate = rs.getDouble(4);
                int price = rs.getInt(5);
                products.add(new Product(id, categoryId, name, rate, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public Object findEntityById(Number id) {
        return null;
    }

    public List<Product> findEntityByCategoryId(int category) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_PRODUCT_CATEGORY_ID)) {
            statement.setInt(1, category);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                double rate = rs.getDouble(4);
                double price = rs.getDouble(5);
                products.add(new Product(category, name, rate, price));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    @Override
    public boolean delete(Number id) {
        return false;
    }

    @Override
    public boolean delete(Object entity) {
        return false;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public Object update(Object entity) {
        return null;
    }
}
