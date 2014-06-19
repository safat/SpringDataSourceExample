package net.therap.service;

import net.therap.dao.ClientDao;
import net.therap.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class ClientService {

    @Autowired
    @Qualifier ("clientDaoJpa")
    ClientDao clientDao;

    public List<Client> getClientList() {
        return clientDao.getClientList();
    }
}
