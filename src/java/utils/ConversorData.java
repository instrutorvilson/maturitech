/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Calendar;

/**
 *
 * @author entra21
 */
public class ConversorData {
    public static java.sql.Date conv(Calendar d){
       java.sql.Date data = new java.sql.Date(d.getTime().getTime());
       return data;
    }
}
