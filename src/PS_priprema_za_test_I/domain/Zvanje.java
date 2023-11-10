/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PS_priprema_za_test_I.domain;

import java.util.Objects;

/**
 *
 * @author aleks
 */
public class Zvanje {
    private Long id;
    private String naziv;

    public Zvanje(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
    }

    public Zvanje() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zvanje other = (Zvanje) obj;
        return Objects.equals(this.id, other.id);
    }
    
}
