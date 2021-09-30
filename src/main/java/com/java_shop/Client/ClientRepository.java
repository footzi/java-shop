package com.java_shop.Client;

import com.java_shop.DbConnection.DBConnectionInput;
import com.java_shop.DbConnection.DbConnection;
import com.java_shop.DbConnection.DbConnectionResult;

import java.sql.SQLException;

public class ClientRepository {
    public static Client add(Client client) throws SQLException {
        // todo Заменить на более короткую строку
        String query = "INSERT INTO clients (name, surname, address, phone) VALUES (" + "'" + client.getName() + "', '" + client.getSurname() + "', '" + client.getAddress() + "', '" + client.getPhone() + "')";

        int newClientId = DbConnection.executeUpdate(query);

        client.setId(newClientId);

        return client;
    }

    public static boolean getIsAddedByPhone(String phone) throws SQLException {
        String query = "SELECT * FROM clients WHERE phone = '" + phone + "'";

        DBConnectionInput input = new DBConnectionInput().addField("client_id", "int");
        DbConnectionResult result = DbConnection.executeQuery(query, input);


        return result.getFieldInt("client_id") != 0;
    }

    public static Client getById(int id) throws SQLException {
        String query = "SELECT * FROM clients WHERE client_id = " + id;

        DBConnectionInput input = new DBConnectionInput()
                .addField("client_id", "int")
                .addField("name", "string")
                .addField("surname", "string")
                .addField("address", "string")
                .addField("phone", "string");
        DbConnectionResult result = DbConnection.executeQuery(query, input);

        int clientId = result.getFieldInt("client_id");
        String name = result.getFieldString("name");
        String surname = result.getFieldString("surname");
        String address = result.getFieldString("address");
        String phone = result.getFieldString("phone");

        return new Client(clientId, name, surname, address, phone);
    }
}
