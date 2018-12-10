package aas86.service;

import aas86.dao.ClientDao;
import aas86.model.Account;
import aas86.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


@Service
public class ServiceClient {

    @Autowired
    private ClientDao clientDao;

    public LinkedList<Client> getAllClients()  {
        return clientDao.getAllClients();
    }

    public void addClient(String name){
        clientDao.addClient(name);
    }

    public LinkedList<Account> getClientAccounts(String name){
        return clientDao.getClientAccounts(name);
    }
}
