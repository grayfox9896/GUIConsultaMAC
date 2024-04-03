/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.wifi;


import analisis.wifi.Entities.Router;
import analisis.wifi.Entities.Station;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
    import java.sql.DriverManager;
import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.InflaterInputStream;

public class ConnectionLite {
    
    
         public static List<Router> getCountClientsByAP(){
        List<Router> res= new  ArrayList<Router>();
        Router resAux;
    try{    
            Connection conn= DriverManager.getConnection("jdbc:sqlite:MAC.db");
            Statement sentencia= conn.createStatement();            
           ResultSet resulQuery= sentencia.executeQuery("select r.Nombre, R.MAC, count(s.mac) as Clients,(select company from vendors where substr(r.mac,1,length(mac))=mac) as Vendor from Routers r inner join Stations s on (r.mac=s.MAC_AP) group by s.MAC_AP order by count(s.mac) desc");
            while(resulQuery.next()){
               resAux= new Router();
               resAux.Router_MAC= resulQuery.getString("MAC");
               resAux.helperInt=resulQuery.getInt("Clients");
               resAux.Router_Nombre=resulQuery.getString("Nombre");
               resAux.Router_Vendor=resulQuery.getString("Vendor");
               res.add(resAux);               
           }
        }
        catch(Exception ex){
            Logger.getLogger(ConnectionLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    return res;
    }
    
    
     public static List<Station> searchDeviceInMultipleAP(){
        List<Station> res= new  ArrayList<Station>();
        Station resAux;
    try{    
            Connection conn= DriverManager.getConnection("jdbc:sqlite:MAC.db");
            Statement sentencia= conn.createStatement();            
           ResultSet resulQuery= sentencia.executeQuery("select s.mac,count(s.mac) as APs, (select company from vendors where substr(s.mac,1,length(mac))=mac) as Vendor  from Stations s group by s.mac having count(s.mac)>1 order by 2 desc");
            while(resulQuery.next()){
               resAux= new Station();
               resAux.Device_MAC= resulQuery.getString("MAC");
               resAux.helperInt=resulQuery.getInt("APs");
               resAux.Station_Vendor=resulQuery.getString("Vendor");                                           
               res.add(resAux);               
           }
        }
        catch(Exception ex){
            Logger.getLogger(ConnectionLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    return res;
    }
             public static List<Router> getAsociatedClientToAP(String RouterMAC,String RouterName){
        List<Router> res= new  ArrayList<Router>();
        Router resAux;
    try{    
        PreparedStatement sentencia;
            Connection conn= DriverManager.getConnection("jdbc:sqlite:MAC.db");
            if(RouterMAC.length()>0){
            sentencia= conn.prepareStatement("select r.MAC,fecha , (select company from vendors where substr(r.mac,1,length(mac))=mac) as Vendor,(select nombre from routers where mac=r.MAC_AP) as Router_Name from Stations r where MAC_AP=?");  
            sentencia.setString(1, RouterMAC);
            }else
            {
            sentencia= conn.prepareStatement("select s.MAC,s.fecha,(select company from vendors where substr(s.mac,1,length(mac))=mac) as Vendor,r.nombre as Router_name  from Stations s inner join Routers r on (r.MAC=s.MAC_AP) where r.Nombre like ?");  
            sentencia.setString(1, "%"+RouterName+"%");
            }
            
           ResultSet resulQuery= sentencia.executeQuery();
            while(resulQuery.next()){
               resAux= new Router();
               resAux.Router_MAC= resulQuery.getString("MAC");
               resAux.Router_Nombre=resulQuery.getString("Router_Name");
               resAux.Router_Vendor=resulQuery.getString("Vendor");
               resAux.Fecha=resulQuery.getString("Fecha");                              
               res.add(resAux);               
           }
        }
        catch(Exception ex){
            Logger.getLogger(ConnectionLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    return res;
    }
    
     
     ///devuelve Router, pero en realidad son estaciones
        public static List<Router> getRelatedNetworks(String RouterMAC,String RouterName){
        List<Router> res= new  ArrayList<Router>();
        Router resAux;
    try{    
        PreparedStatement sentencia;
            Connection conn= DriverManager.getConnection("jdbc:sqlite:MAC.db");
            if(RouterMAC.length()>0){
            sentencia= conn.prepareStatement("select DISTINCT r.MAC MAC_ROUTER,r.Nombre ROUTER_NOMBRE,(select company from vendors where substr(r.mac,1,length(mac))=mac) as Vendor from Routers r  where mac in (select MAC_AP from Stations where mac in (select s.MAC from Stations s inner join Routers r on (r.MAC=s.MAC_AP) where r.MAC=?))");  
            sentencia.setString(1, RouterMAC);
            }else
            {
            sentencia= conn.prepareStatement("select DISTINCT r.MAC MAC_ROUTER,r.Nombre ROUTER_NOMBRE,(select company from vendors where substr(r.mac,1,length(mac))=mac) as Vendor from Routers r  where mac in (select MAC_AP from Stations where mac in (select s.MAC from Stations s inner join Routers r on (r.MAC=s.MAC_AP) where r.Nombre like ?))");  
            sentencia.setString(1, "%"+RouterName+"%");
            }
            
           ResultSet resulQuery= sentencia.executeQuery();
            while(resulQuery.next()){
               resAux= new Router();
               resAux.Router_MAC= resulQuery.getString("MAC_ROUTER");
               resAux.Router_Nombre=resulQuery.getString("ROUTER_NOMBRE");
               resAux.Router_Vendor=resulQuery.getString("Vendor");                            
               res.add(resAux);               
           }
        }
        catch(Exception ex){
            Logger.getLogger(ConnectionLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    return res;
    }
    
    public static List<Router> searchDeviceInDB(String macDevice){
        List<Router> res= new  ArrayList<Router>();
        Router resAux;
    try{    
            Connection conn= DriverManager.getConnection("jdbc:sqlite:MAC.db");
            PreparedStatement sentencia= conn.prepareStatement("select r.MAC as MAC,r.Nombre,s.Fecha, (select company from vendors where substr(r.mac,1,length(mac))=mac) as Vendor from Stations s inner join Routers r on (s.MAC_AP=r.MAC) where s.MAC=?");  
            sentencia.setString(1, macDevice);
           ResultSet resulQuery= sentencia.executeQuery();
            while(resulQuery.next()){
               resAux= new Router();
               resAux.Router_MAC= resulQuery.getString("MAC");
               resAux.Router_Nombre=resulQuery.getString("Nombre");
               resAux.Router_Vendor=resulQuery.getString("Vendor");
               resAux.Fecha=resulQuery.getString("Fecha");                              
               res.add(resAux);               
           }
        }
        catch(Exception ex){
            Logger.getLogger(ConnectionLite.class.getName()).log(Level.SEVERE, null, ex);
        }
    return res;
    }
    
//    public static List<Requerimiento> GetRequerimientos(){
//        List<Requerimiento> res= new ArrayList<Requerimiento>();
//        Requerimiento resAux;
//        try {                        
//            Connection conn= DriverManager.getConnection("jdbc:sqlite:Requerimientos.db");
//            Statement sentencia= conn.createStatement();           
//           ResultSet resulQuery= sentencia.executeQuery("select * from requerimientos order by orderR desc");            
//           
//           while(resulQuery.next()){
//               resAux= new Requerimiento();
//               resAux.Orden= resulQuery.getInt("orderR");
//               resAux.Id=resulQuery.getInt("red_id");
//               resAux.Status=resulQuery.getInt("status");
//               resAux.Desc=resulQuery.getString("Desc");               
//               resAux.Inicio=resulQuery.getString("inicio");
//               resAux.Fin=resulQuery.getString("termino");
//               res.add(resAux);               
//           }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionLite.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return res;
//    }
    

    
}
