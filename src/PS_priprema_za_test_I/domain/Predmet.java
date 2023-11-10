/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PS_priprema_za_test_I.domain;

/**
 *
 * @author aleks
 */
public class Predmet {
    private Long id;
    private String naziv;
    private int espb;

    public Predmet() {
    }

    public Predmet(Long id, String naziv, int espb) {
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
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
    
}
