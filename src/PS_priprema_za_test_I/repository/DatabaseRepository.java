/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PS_priprema_za_test_I.repository;

import PS_priprema_za_test_I.domain.Nastavnik;
import PS_priprema_za_test_I.domain.Zvanje;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class DatabaseRepository {

    private Connection connection;

    public DatabaseRepository() {
    }

    public List<Zvanje> getAllZvanja() throws SQLException {
        try {
            List<Zvanje> zvanja = new ArrayList<>();
            String url = "jdbc:mysql://127.0.0.1/studentska_sluzba";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            Statement s = connection.createStatement();
            String query = "SELECT * FROM zvanje";
            ResultSet rs = s.executeQuery(query);
            Zvanje zvanje = null;
            while (rs.next()) {
                zvanje = new Zvanje(rs.getLong("id"), rs.getString("naziv"));
                zvanja.add(zvanje);
            }
            rs.close();
            s.close();
            connection.close();
            return zvanja;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public List<Nastavnik> getAllNastavnici() throws SQLException {
        try {
            List<Nastavnik> nastavnici = new ArrayList<>();
            String url = "jdbc:mysql://127.0.0.1/studentska_sluzba";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            Statement s = connection.createStatement();
            String query = "SELECT n.id, n.ime,n.prezime,z.id,z.naziv FROM "
                    + "nastavnik AS n INNER JOIN zvanje AS z ON n.zvanje_id=z.id";
            ResultSet rs = s.executeQuery(query);
            Nastavnik nastavnik = null;
            while (rs.next()) {
                nastavnik = new Nastavnik(rs.getLong("n.id"), rs.getString("n.ime"),
                        rs.getString("n.prezime"), new Zvanje(rs.getLong("z.id"), rs.getString("z.naziv")));
                nastavnici.add(nastavnik);
            }
            rs.close();
            s.close();
            connection.close();
            return nastavnici;
        } catch (SQLException ex) {
            throw ex;
        }
    }


    public Long addNastavnik(Nastavnik nastavnik) throws SQLException {
        try {
            Long id = null;
            String url = "jdbc:mysql://127.0.0.1/studentska_sluzba";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            String query = "INSERT INTO nastavnik(ime,prezime,zvanje_id) VALUES (?,?,?) ";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nastavnik.getIme());
            ps.setString(2, nastavnik.getPrezime());
            ps.setLong(3, nastavnik.getZvanje().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
            ps.close();
            connection.close();
            return id;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void updateNastavnik(Long oldId, Nastavnik nastavnik) throws SQLException {
        try {
            String url = "jdbc:mysql://127.0.0.1/studentska_sluzba";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            String query = "UPDATE nastavnik SET id = ?, ime = ?, prezime = ?, zvanje_id = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, nastavnik.getId());
            ps.setString(2, nastavnik.getIme());
            ps.setString(3, nastavnik.getPrezime());
            ps.setLong(4, nastavnik.getZvanje().getId());
            ps.setLong(5, oldId);
            ps.executeUpdate();
            
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            throw ex;
        }

    }

    public void deleteNastavnik(Nastavnik nastavnik) throws SQLException {
        try {
            String url = "jdbc:mysql://127.0.0.1/studentska_sluzba";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
            String query = "DELETE FROM nastavnik WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, nastavnik.getId());
            ps.executeUpdate();
            
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            throw ex;
        }
    }

}
