package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabel extends AbstractTableModel{
    List<DataKsr> ks;
    public ModelTabel(List<DataKsr>ks){
        this.ks = ks;
    }
    
    @Override
    public int getRowCount() {
        return ks.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "HARGA";
            case 3:
                return "JUMLAH";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return ks.get(row).getId();
            case 1:
                return ks.get(row).getNama();
            case 2:
                return ks.get(row).getHarga();
            case 3:
                return ks.get(row).getJumlah();
            default:
                return null;
        }
    }
    
}
