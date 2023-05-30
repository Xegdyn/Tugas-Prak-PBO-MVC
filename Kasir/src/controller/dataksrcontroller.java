package controller;
import java.util.List;
import DAOdataksr.DataKsrDAO;
import DAOimplements.KasirImplements;
import javax.swing.JOptionPane;
import model.*;
import view.AdminView;

public class DataKsrController {
    AdminView frame;
    KasirImplements impl;
    List<DataKsr> ks;
    
    public DataKsrController(AdminView frame){
        this.frame = frame;
        impl = new DataKsrDAO();
        ks = impl.getAll();
    }

    public void isitabel(){
        ks = impl.getAll();
        ModelTabel mp = new ModelTabel(ks);
        frame.getTabelDataksr().setModel(mp);
    }
    
    public void insert(){
        DataKsr ks = new DataKsr();
        ks.setNama(frame.getJTxtnama().getText());
        ks.setHarga(frame.getJTxtharga().getText());
        ks.setJumlah(Integer.parseInt(frame.getJTxtjumlah().getText()));
        impl.insert(ks);
        
    }
    
    public void update(){
        DataKsr ks = new DataKsr();
        ks.setNama(frame.getJTxtnama().getText());
        ks.setHarga(frame.getJTxtharga().getText());
        ks.setJumlah(Integer.parseInt(frame.getJTxtjumlah().getText()));
        ks.setId(Integer.parseInt(frame.getJTxtid().getText()));
        impl.update(ks);
    }
    
    public void delete(){
        int id = Integer.parseInt(frame.getJTxtid().getText());
        impl.delete(id);
    }
    
}
