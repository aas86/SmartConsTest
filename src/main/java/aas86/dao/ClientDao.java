package aas86.dao;

import aas86.model.Account;
import aas86.model.Client;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;

@Repository
public class ClientDao {

    private final String user = "postgres";
    private final String password = "root";

    public LinkedList<Client> getAllClients() {
        LinkedList<Client> clientsList = new LinkedList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", user, password);
            Statement st = null;
            st = connection.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("SELECT * FROM clients");
            while (rs.next()) {
                Client client = new Client(rs.getInt("id"), rs.getString("name"));
                clientsList.add(client);
            }
            rs.close();
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientsList;
    }

    public void addClient(String name) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", user, password);
            Statement st = null;
            st = connection.createStatement();
            String queryString = "INSERT INTO clients(name)VALUES('" + name + "')";
            //System.out.println(queryString);
            st.executeUpdate(queryString);
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Account> getClientAccounts(String name) {
        LinkedList<Account> accountsList = new LinkedList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", user, password);
            Statement st = null;
            st = connection.createStatement();
            ResultSet rs = null;
            String queryString = "SELECT name, money FROM clients" +
                    " JOIN accounts" +
                    " ON accounts.client_id = clients.id" +
                    " WHERE name = " + "'" + name + "'";

            //System.out.println(queryString);
            rs = st.executeQuery(queryString);
            while (rs.next()) {
                Account account = new Account(rs.getString("name"), rs.getInt("money"));
                accountsList.add(account);
            }
            rs.close();
            st.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountsList;
    }
}



