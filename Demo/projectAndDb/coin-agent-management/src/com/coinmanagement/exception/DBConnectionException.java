/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coinmanagement.exception;

/**
 *
 * @author Kazi Nasir Uddin Oly
 */
public class DBConnectionException extends Exception{

    public DBConnectionException(String message, Throwable ex){
        super(message, ex);
    }
    
    public DBConnectionException(Throwable ex) {
        super(ex);
    }
    
}
