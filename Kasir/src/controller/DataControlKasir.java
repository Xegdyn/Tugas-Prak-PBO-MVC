/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.List;
import DAOdataksr.DataKsrDAO;
import DAOimplements.KasirImplements;
import model.*;
import view.KasirView;

public class DataControlKasir {
    KasirView frame;
    KasirImplements impl;
    List<DataKsr> ks;
    
    public DataControlKasir(KasirView frame){
        this.frame = frame;
        impl = new DataKsrDAO();
        ks = impl.getAll();
    }

    public void isitabel(){
        ks = impl.getAll();
        ModelTabel mp = new ModelTabel(ks);
        frame.getTabelDataBarang().setModel(mp);
    }
    
    public void addtabel(){
        DataKsr ks = new DataKsr();
        ks.setNama(frame.getJformbarang().getText());
        ks.setHarga(frame.getJformharga().getText());
        ks.setJumlah(Integer.parseInt(frame.getJformkuantitas().getText()));
        ks.setId(Integer.parseInt(frame.getJformid().getText()));
        
    }
   public void updatestock(){
        DataKsr ks = new DataKsr();
        ks.setId(Integer.parseInt(frame.getJformid().getText()));
        ks.setJumlah(Integer.parseInt(frame.getJformstock().getText()));
        impl.pengembalian(ks);
    }
   
   public void penjualan(){
       DataPenjualan ks = new DataPenjualan();
       ks.setId(Integer.parseInt(frame.getJformid().getText()));
       ks.setJumlah(Integer.parseInt(frame.getJformkuantitas().getText()));
       ks.setNama(frame.getJformbarang().getText());
       ks.setHarga(frame.getJformharga().getText());
       ks.setTotal(Integer.parseInt(frame.getStt().getText()));
       impl.penjualan(ks);
   }
    
}
