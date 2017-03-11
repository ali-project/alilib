package alilibs;

import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by 闲道人阿力 on 2016/7/13.
 */
public class AliSqlite {
    Connection conn;
    Statement stat;

    public AliSqlite(String dburl) throws Exception {
        conn =
                DriverManager.getConnection("jdbc:sqlite:" + dburl);
        stat = conn.createStatement();
    }

    public void insert(String table, Object[] args) throws Exception {
        String pam = "";
        for(int i=0;i<args.length;i++)
        {
            pam += "?";
            if(i<args.length-1){
                pam += ",";
            }


        }


        String sql = "insert into "+table+" values ("+pam+");";

        PreparedStatement prep = conn.prepareStatement(sql);
//        System.out.println(sql);
        for(int i=0;i<args.length;i++)
        {

            if(args[i]==null){
                //prep.setObject(i+1,null);

            }

            else if(args[i].getClass().toString().contains("String")){
                prep.setString(i+1, (String)args[i]);

            }else if(args[i].getClass().toString().contains("Integer")){
                prep.setInt(i+1, (Integer)args[i]);

            }else if(args[i].getClass().toString().contains("Double")){
                prep.setDouble(i+1, (Double) args[i]);

            }else if(args[i].getClass().toString().contains("Boolean")){
                prep.setBoolean(i+1, (Boolean)args[i]);

            }


        }

        prep.addBatch();



        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

    }



    public ResultSet query(String table,String condition) throws Exception {

        if(condition!=null && !condition .trim().equals(""))
        {
            condition = "where "+condition ;
        }else {
            condition = "";
        }


        ResultSet rs = stat.executeQuery("select * from "+table+" "+condition+";");
        return rs ;

    }



    public void close()
    {

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public boolean delete(String table,String where) throws Exception {
        String sql = "delete from "+table+" where " + where ;
        AliLog.println(sql);
        return stat.execute(sql);



    }




    public boolean update(String table,Map values,String where) throws Exception {
        Set keys = values.keySet();
        Iterator i = keys.iterator();
        String pam = "";
        while (i.hasNext())
        {

            if(pam.length()>0) pam += ",";

            String x = i.next()+"" ;

            if(values.get(x).getClass().toString().contains("String")){
//                AliLog.println(x+" = '"+values.get(x)+"'");
                pam += x+" = '"+values.get(x)+"'" ;
            }else{
//                AliLog.println(x+" = "+values.get(x));
                pam += x+" = "+values.get(x);
            }



        }
        String sql = "update "+table+" set "+pam +" where " + where ;
        AliLog.println(sql);
        return stat.execute(sql);




    }



}
