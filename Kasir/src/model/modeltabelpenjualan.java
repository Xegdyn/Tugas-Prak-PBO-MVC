/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hp
 */
public class ModelTabelPenjualan extends AbstractTableModel {
    List<DataPenjualan> ks;
    public ModelTabelPenjualan(List<DataPenjualan>ks){
        this.ks = ks;
    }
    
    @Override
    public int getRowCount() {
        return ks.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID BARANG";
            case 1:
                return "NAMA";
            case 2:
                return "JUMLAH";
            case 3:
                return "HARGA";
            case 4:
                return "TOTAL";
            case 5:
                return "WAKTU PEMBELIAN";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
            switch(column){
            case 0:
                return ks.get(row).getId_barang();
            case 1:
                return ks.get(row).getNama();
            case 2:
                return ks.get(row).getJumlah();
            case 3:
                return ks.get(row).getHarga();
            case 4:
                return ks.get(row).getTotal();
            case 5:
                return ks.get(row).getWaktu();
            default:
                return null;
        }
    }
    
}
