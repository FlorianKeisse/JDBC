package service;

import data.ContinentDAO;
import model.Continent;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ContinentService {

    private ContinentDAO continentDAO;
    private Scanner keyboard = new Scanner(System.in);

    public ContinentService() throws SQLException {
        continentDAO = new ContinentDAO();
    }

    public void showAllContinents() throws SQLException {
//        continentDAO.getAllContinents().forEach(System.out::println);
        List<Continent> continentList = continentDAO.getAllContinents();
        for (Continent c : continentList) {
            System.out.println(c);
        }
    }

    public void showContinentById() throws SQLException {

        System.out.println("Enter an Id: ");

        int id = keyboard.nextInt();

        Continent continent = continentDAO.getContinentById(id);

        System.out.println(continent);

    }

    public void insertContinent() throws SQLException {
        System.out.println("Give name of the continent");
        String continentName = keyboard.nextLine();
        Continent continent = new Continent(continentName);
        continentDAO.addContinent(continent);
    }


    public void updateAContinent() throws SQLException {
        showAllContinents();

        System.out.println("choose the id you wanna change.");
        int originalId = keyboard.nextInt();
        Continent continent = continentDAO.getContinentById(originalId);

        System.out.println("Type in new name if you wanna change it. Press '0' to leave");
        String newName = keyboard.next();
        if (!newName.equals(0)) continent.setName(newName);

        continentDAO.updateContinent(continent);
    }

    public void deleteContinent() throws SQLException {
        showAllContinents();
        System.out.println("Choose the ID of which continent to delete.");
        int originalId = keyboard.nextInt();
        Continent continent = continentDAO.getContinentById(originalId);
        continentDAO.deleteContinent(continent);
    }
}
//TODO fill in all methods needed

