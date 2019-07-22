package mainProject.daoClasses;

import jdbc.AbstractDAO;
import jdbc.ConnectorDB;
import mainProject.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends AbstractDAO<Integer, Category> {

    public static final String SQL_SELECT_ALL_CATEGORIES = "SELECT * FROM category";
    public static final String SQL_SELECT_CATEGORY_NAME =
            "SELECT * FROM category WHERE name=?";
    public static final String SQL_SELECT_CATEGORY_ID =
            "SELECT * FROM category WHERE id=?";

    @Override
    public List<Category> findAll() {
        List<Category> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_CATEGORIES);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                users.add(new Category(name, id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public Category findEntityById(Integer id) {
        Category category = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_CATEGORY_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                category = new Category(name, id);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

//    public Category findNameofEntityById(Integer id) {
//        Category category = null;
//        try (Connection connection = ConnectorDB.getConnection();
//             PreparedStatement statement =
//                     connection.prepareStatement(SQL_SELECT_CATEGORY_ID)) {
//            statement.setInt(1, id);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                String name = rs.getString(2);
//                category = new Category(name, id);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return category;
//    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(Category entity) {
        return false;
    }

    @Override
    public boolean create(Category entity) {
        return false;
    }

    @Override
    public Category update(Category entity) {
        return null;
    }
}
