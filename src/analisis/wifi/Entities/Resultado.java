/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.wifi.Entities;

/**
 *
 * @author joel
 */
public class Resultado {
    public Router AP;
    public Station device;
    
    public void Resultado(){
    AP= new Router();
    device=new Station();
    }
    
    
}
