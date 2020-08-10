package SQLite_Adapter;

import java.util.List;

public interface IDatabaseHandler {

    public void addZd(Zd zd);
    public Zd getZd(int id);
    public Zd getZd(String name);
    public List<String> getZdNotClear(String name);
    public List<Zd> getAllZd();
    public int getZdCount();
    public int updateZd(Zd zd);
    public void deleteZd(Zd zd);
    public void deleteAll();

}