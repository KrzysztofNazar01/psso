
import java.sql.*;
import java.util.*;

class Database {
    public Database(String driver) {}//constructor
    public void close();
    public void Open(String url, String cat);
    public void reOpen();
    public String[] getTableNames();
    public String[] getTableMetaData();
    public String[] getColumnMetaData(String tablename);
    public String[] getColumnNames(String table);
    public String getColumnValue(String table, String columnName);
    public String getNextValue(String columnName);
    public Results Execute(String sql);
}

