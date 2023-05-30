package DAOdataksr;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplements.KasirImplements;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataKsrDAO implements KasirImplements{
    Connection connection;
    final String select = "SELECT * FROM barang ORDER BY nama ASC";
    final String databeli = "SELECT * FROM penjualan";
    final String insert = "INSERT INTO barang (nama, harga, jumlah) VALUES (?, ?, ?);";
    final String update = "update barang set nama=?, harga=?, jumlah=? where id=?";
    final String delete = "delete from barang where id=?";
    final String pengembalian = "update barang set jumlah=? where id=?";
    final String penjualan ="INSERT INTO penjualan (id_barang, barang, jumlah, harga, total, waktu_pembelian) VALUES (?,?,?,?,?,NOW())";
    
    public DataKsrDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(DataKsr k) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, k.getNama());
            statement.setString(2, k.getHarga());
            statement.setInt(3, k.getJumlah());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                k.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(DataKsr k) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, k.getNama());
            statement.setString(2, k.getHarga());
            statement.setInt(3, k.getJumlah());
            statement.setInt(4, k.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataKsr> getAll() {
        List<DataKsr> ks = null;
        try{
            ks = new ArrayList<DataKsr>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                DataKsr kas = new DataKsr();
                kas.setId(rs.getInt("id"));
                kas.setNama(rs.getString("nama"));
                kas.setHarga(rs.getString("harga"));
                kas.setJumlah(rs.getInt("jumlah"));
                ks.add(kas);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataKsrDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ks;
    }

    @Override
    public void pengembalian(DataKsr k) {
       PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(pengembalian);
            statement.setInt(1, k.getJumlah());
            statement.setInt(2, k.getId());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void penjualan(DataPenjualan djual) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(penjualan);
            statement.setInt(1, djual.getId());
            statement.setString(2, djual.getNama());
            statement.setInt(3, djual.getJumlah());
            statement.setString(4, djual.getHarga());
            statement.setInt(5, djual.getTotal());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DataPenjualan> getData() {
        List<DataPenjualan> dp = null;
        try{
            dp = new ArrayList<DataPenjualan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(databeli);
            while(rs.next()){
                DataPenjualan dapem = new DataPenjualan();
                dapem.setId_barang(rs.getInt("id_barang"));
                dapem.setNama(rs.getString("barang"));
                dapem.setHarga(rs.getString("harga"));
                dapem.setJumlah(rs.getInt("jumlah"));
                dapem.setTotal(rs.getInt("total"));
                dapem.setWaktu(rs.getString("waktu_pembelian"));
                dp.add(dapem);
            }
        }catch(SQLException ex){
            Logger.getLogger(DataKsrDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
    
    
}
