package database;

import models.Ingredient;

import java.sql.*;
import java.util.ArrayList;

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



public ArrayList<Ingredient> showAll(){

    ArrayList<Ingredient> allIngredients = new ArrayList<>();

        try {
            Connection c = connect();

            Statement statement = c.createStatement();
                ResultSet resultSet= statement.executeQuery("SELECT * FROM ingredients");

while (resultSet.next()){
    String name = resultSet.getString("name");
    double price = resultSet.getDouble("price");
    int amount = resultSet.getInt("amount");
    int id = resultSet.getInt("id");

    Ingredient ingredient = new Ingredient(id, name, price, amount);

    allIngredients.add(ingredient);
}
            resultSet.close();
            statement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return allIngredients;


}

public void updateIngredientName(int id, String name){
    try {
        Connection c = connect();

        PreparedStatement preparedStatement = c.prepareStatement(
                "UPDATE INGREDIENTS SET(NAME,PRICE,AMOUNT)=(?,price, amount)WHERE id=?");

        preparedStatement.setString(1, name);
        preparedStatement.setDouble(2, id);


        preparedStatement.executeUpdate();
        preparedStatement.close();
        c.close();
    } catch (SQLException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

}



public void updateIngredientPrice(int id, double price){
        try {
            Connection c = connect();

            PreparedStatement preparedStatement = c.prepareStatement(
                    "UPDATE INGREDIENTS SET(NAME,PRICE,AMOUNT)=(name,?, amount)WHERE id=?");

            preparedStatement.setDouble(1, price);
            preparedStatement.setDouble(2, id);


            preparedStatement.executeUpdate();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

}


public void updateIngredientAmount(int id, int amount){
        try {
            Connection c = connect();

            PreparedStatement preparedStatement = c.prepareStatement(
                    "UPDATE INGREDIENTS SET(NAME,PRICE,AMOUNT)=(name,price, ?)WHERE id=?");

            preparedStatement.setInt(1, amount);
            preparedStatement.setDouble(2, id);


            preparedStatement.executeUpdate();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteIngredient(int id){
        try {
            Connection c = connect();

            PreparedStatement preparedStatement = c.prepareStatement(
                    "DELETE FROM INGREDIENTS WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}
