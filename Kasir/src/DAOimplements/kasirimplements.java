package DAOimplements;
import java.util.List;
import model.*;

public interface KasirImplements {
    public void insert(DataKsr k);
    public void update(DataKsr k);
    public void delete(int id);
    public List<DataKsr> getAll();
    public List<DataPenjualan> getData();
    public void pengembalian(DataKsr k);
    public void penjualan(DataPenjualan djual);
}
