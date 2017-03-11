/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alilibs;


import java.sql.*;
import java.util.*;

/**
 *
 * @author Ali
 */

public class ReadAccessFile {

   public static void main(String[] args) {

       //readFileACCESS("adsffasd");



    }

    /**
     * TODO : 读取文件access
     * @param filePath
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Map> readFileACCESS(String filePath)   {
        List<Map> maplist= new ArrayList();
        Properties prop = new Properties();
        prop.put("charSet", "gb2312");                //这里是解决中文乱码
        prop.put("user", "");
        prop.put("password", "");
        String  url="jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ="+filePath;   //文件地址
        PreparedStatement ps=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn= DriverManager.getConnection(url,prop);
            stmt = (Statement)conn.createStatement();

            rs=stmt.executeQuery("select * from Chinese");
            ResultSetMetaData data=rs.getMetaData();

            while(rs.next()) {
                Map map= new HashMap();
                for(int i = 1 ; i<= data.getColumnCount() ; i++){
                    String columnName =data.getColumnName(i);    //列名
                    String  columnValue= rs.getString(i);
                    map.put(columnName, columnValue);
                }
                maplist.add(map);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return maplist;
    }

}
