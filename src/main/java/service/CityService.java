package service;

import data.CityDAO;
import data.CountryDAO;
import model.City;
import model.Country;

import java.sql.SQLException;
import java.util.Locale;
import java.util.Scanner;

public class CityService {

    private CountryDAO countryDAO;
    private CityDAO cityDAO;
    private Scanner keyboard = new Scanner(System.in);

    public CityService() throws SQLException {
        cityDAO = new CityDAO();
    }

    public void showAllCities() throws SQLException {
        cityDAO.getAllCities().forEach(System.out::println);
    }

    public void showContinentById() throws SQLException {

        System.out.println("Enter an Id: ");

        int id = keyboard.nextInt();

        City city = cityDAO.getCityById(id);

        System.out.println(city);


    }

    public void insertACity() throws SQLException {
        System.out.println("Give name of the city");
        String name = keyboard.nextLine();
        System.out.println("Give id of the City");
        Country country = null;
        City city = new City(name,country);
        cityDAO.addCity(city);
    }


    public void updateACity() throws SQLException {
        showAllCities();

        System.out.println("choose the id you wanna change.");
        int originalId = keyboard.nextInt();
        City city = cityDAO.getCityById(originalId);

        System.out.println("Type in new name if you wanna change it. Press '0' to leave");
        String newName = keyboard.next();
        if (!newName.equals(0)) city.setName(newName);

        System.out.println("Change the continentId, NA if you don't wanna change");
       String cityId = keyboard.next();
       if (!cityId.toUpperCase(Locale.ROOT).equals("0")){
          city = cityDAO.getCityById(Integer.parseInt(cityId));
       }
        cityDAO.updateCity(city);


    }

    public void deleteCity() throws SQLException {
       showAllCities();
        System.out.println("Choose the ID of which continent to delete.");
        int originalId = keyboard.nextInt();
        City city = cityDAO.getCityById(originalId);
        cityDAO.deleteCity(city);
    }
}
