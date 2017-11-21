package database;

import models.Ingredient;

import java.sql.*;

public class IngredientRepo {


public Connection connect()throws SQLException, ClassNotFoundException {
    Connection c = null;
    Class.forName("org.postgresql.Driver");

    c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/Marioscucina");

    return c;
}


public void save(Ingredient ingredient){

    try {
        Connection c = connect();

        PreparedStatement preparedStatement = c.prepareStatement(
                "INSERT INTO INGREDIENTS(NAME,PRICE,AMOUNT) VALUES(?,?,?)");

        preparedStatement.setString(1, ingredient.getName());
        preparedStatement.setDouble(2, ingredient.getPrice());
        preparedStatement.setInt(3, ingredient.getAmount());

        preparedStatement.executeUpdate();
        preparedStatement.close();
        c.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}

    public void showAll(){

        try {
            Connection c = connect();

            Statement statement = c.createStatement();
                ResultSet resultSet= statement.executeQuery("SELECT * FROM ingredients");

while (resultSet.next()){
    String name = resultSet.getString("name");
    double price = resultSet.getDouble("price");
    int amount = resultSet.getInt("amount");
    System.out.println("Name :" + name );
    System.out.println("Price :" + price );
    System.out.println("Amount :" + amount );
}

            resultSet.close();
            statement.close();
            c.commit();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


}

}
