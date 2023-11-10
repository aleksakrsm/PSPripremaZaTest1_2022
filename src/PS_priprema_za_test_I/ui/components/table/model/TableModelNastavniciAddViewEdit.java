/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PS_priprema_za_test_I.ui.components.table.model;

import PS_priprema_za_test_I.domain.Nastavnik;
import PS_priprema_za_test_I.domain.Zvanje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleks
 */
public class TableModelNastavniciAddViewEdit extends AbstractTableModel {

    private List<Nastavnik> nastavnici;
    private boolean isRowAdded = false;
    private boolean isRowValid = false;
    private int lastAddedIndex = -1;
    private int lastEditedIndex = -1;
    public TableModelNastavniciAddViewEdit(List<Nastavnik> nastavnici) {
        this.nastavnici = nastavnici;
    }

    @Override
    public int getRowCount() {
        return nastavnici.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nastavnik n = nastavnici.get(rowIndex);
        switch (columnIndex) {
            case 0: return n.getId();
            case 1: return n.getIme();
            case 2: return n.getPrezime();
            case 3: return n.getZvanje();
            default: return "n/a";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(rowIndex == (nastavnici.size()-1) && isLastAddedValid() && isLastEditedValid())
            return true;
        if(nastavnici.get(rowIndex).getZvanje().getNaziv().equalsIgnoreCase("redovni profesor")){
            if(columnIndex == 2||columnIndex==1)
                return true;
            else
                return false;
        }
        else return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Nastavnik n = nastavnici.get(rowIndex);
        switch (columnIndex) {
//            case 0:  n.setId((Long)aValue); break;
            case 1:  n.setIme((String)aValue);break;
            case 2:  n.setPrezime((String)aValue);break;
//            case 3:  n.setZvanje((Zvanje)aValue);break;
            default: return;
        }
        lastEditedIndex = rowIndex;
    }
    public List<Nastavnik> getNastavniciFromModel(){
        return nastavnici;
    }
    public void addRow(){
        Nastavnik n = new Nastavnik("", "", null);
        nastavnici.add(n);
        isRowAdded = true;
        lastAddedIndex = nastavnici.indexOf(n);
        fireTableDataChanged();
    }
    public boolean isLastAddedValid(){
        if(lastAddedIndex==-1)return true;
        return true;
    }

    private boolean isLastEditedValid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
