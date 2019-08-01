package mainProject.daoClasses;

import mainProject.jdbc.AbstractDAO;
import mainProject.jdbc.ConnectorDB;
import mainProject.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDAO<Integer, User> {

    public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String SQL_SELECT_USER_PASSWORD =
            "SELECT * FROM users where password=?";
    public static final String SQL_SELECT_USER_LOGIN =
            "SELECT * FROM users where login=?";
    public static final String SQL_SELECT_USER_ID =
            "SELECT * FROM users WHERE id=?";

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectorDB.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (rs.next()) {
                int id = rs.getInt(1);
                String password = rs.getString(3);
                String login = rs.getString(2);
                users.add(new User(id, password, login));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public User findEntityById(Integer id) {
        User user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_ID)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString(2);
                user = new User(id, name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User findEntityByLoginAndPassword(String login, String password) {
        User user = null;
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(SQL_SELECT_USER_LOGIN);
             PreparedStatement statement1 = connection.prepareStatement(SQL_SELECT_USER_PASSWORD)) {
            statement1.setString(1, password);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                password = rs.getString(3);
                user = new User(login, password);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }

    @Override
    public User update(User entity) {
        return null;
    }
}
