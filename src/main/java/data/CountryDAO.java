package data;

import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {

    private Connection connection ;

    public CountryDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }


    public Country getCountryById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM Country WHERE id = "+id+";";
        ResultSet resultSet = statement.executeQuery(select);
        Country country = null;
        while (resultSet.next())
           country = new Country(resultSet.getInt("Id"),resultSet.getString("name"),resultSet.getInt("continentID"));
        return country;
    }

    public List<Country> getAllCountries() throws SQLException {
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM Country;";
        ResultSet resultSet = statement.executeQuery(select);
        List<Country> countryList = new ArrayList<Country>();
        while (resultSet.next()){
            Country country =
                    new Country(resultSet.getInt("Id"),resultSet.getString("name"),resultSet.getInt("continentID"));
            countryList.add(country);
        }
        return countryList;
    }


    public void addCountry(Country country) throws SQLException {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Country (name, continentID) VALUES (?,?);");
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getContinentId());
            preparedStatement.execute();
    }

    public void updateCountry(Country country, int id) throws SQLException {
        Statement statement = connection.createStatement();
        PreparedStatement preparedStatement =
                connection.prepareStatement("Update Country SET name= ?, continentID =?, id = ? WHERE id = ?;");
        preparedStatement.setString(1, country.getName());
        preparedStatement.setInt(2, country.getContinentId());
        preparedStatement.setInt(3, country.getId());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();

    }
    public void deleteCountry(Country country) throws SQLException {
        Statement statement = connection.createStatement();
        String delete= "Delete FROM Country WHERE id = "+country.getId()+";";
        statement.executeUpdate(delete);
    }
}
