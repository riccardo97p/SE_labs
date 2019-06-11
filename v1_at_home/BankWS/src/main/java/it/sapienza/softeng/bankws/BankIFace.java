package it.sapienza.softeng.bankws;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.jws.WebService;

@WebService
public interface BankIFace {
    public String[] getOperationsByClientID(int ClientID);
    public String getOperationDetailsByID(int OpID);
}
