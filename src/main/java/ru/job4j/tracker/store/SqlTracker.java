package ru.job4j.tracker.store;

import ru.job4j.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public SqlTracker() {

    }

    public SqlTracker(Connection connection) {
        cn = connection;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private Item getItemByResultSet(ResultSet rs) throws SQLException{
            return new Item(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getTimestamp("created").toLocalDateTime());
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st =
                     cn.prepareStatement("INSERT INTO items(name, created) values(?, ?);",
                             Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            st.execute();
            try (ResultSet keys = st.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement st =
                     cn.prepareStatement("UPDATE items SET name=?, created=? WHERE id=?;")) {
            st.setString(1, item.getName());
            st.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            st.setInt(3, id);
            rsl = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement st =
                     cn.prepareStatement("DELETE FROM items WHERE id=?;")) {
            st.setInt(1, id);
            rsl = st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (Statement st = cn.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM items;")) {
            while (resultSet.next()) {
                rsl.add(getItemByResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement st =
                     cn.prepareStatement("SELECT * FROM items WHERE name=?;")) {
            st.setString(1, key);
            try (ResultSet resultSet = st.executeQuery()) {
                while (resultSet.next()) {
                    rsl.add(getItemByResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try (PreparedStatement st =
                     cn.prepareStatement("SELECT * FROM items WHERE id=?;")) {
            st.setInt(1, id);
            try (ResultSet resultSet = st.executeQuery()) {
                if (resultSet.next()) {
                    rsl = getItemByResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}