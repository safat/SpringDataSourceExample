package net.therap.dao;

import net.therap.domain.Client;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 11:24 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ClientDao {
    public List<Client> getClientList();
}
