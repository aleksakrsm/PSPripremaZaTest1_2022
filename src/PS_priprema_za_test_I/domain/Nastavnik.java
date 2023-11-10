/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PS_priprema_za_test_I.domain;

/**
 *
 * @author aleks
 */
public class Nastavnik {
    private Long id;
    private String ime;
    private String prezime;
    private Zvanje zvanje;

    public Nastavnik() {
    }

    public Nastavnik(String ime, String prezime, Zvanje zvanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }
    
    public Nastavnik(Long id, String ime, String prezime, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " je " + zvanje ;
    }
//    public boolean validate(){
//        if()
//    }
    
}
