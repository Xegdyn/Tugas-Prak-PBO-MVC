/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAOdataksr.DataKsrDAO;
import DAOimplements.KasirImplements;
import java.util.List;
import model.DataKsr;
import model.DataPenjualan;
import model.ModelTabel;
import model.ModelTabelPenjualan;
import view.PenjualanView;

/**
 *
 * @author hp
 */
public class DataControlPenjualan {
    PenjualanView frame;
    KasirImplements impl;
    List<DataPenjualan> ks;
    
    public DataControlPenjualan(PenjualanView frame){
        this.frame = frame;
        impl = new DataKsrDAO();
        ks = impl.getData();
    }

    public void isitabel(){
        ks = impl.getData();
        ModelTabelPenjualan mp = new ModelTabelPenjualan(ks);
        frame.getThetabels().setModel(mp);
    }
    
   
}
