package net.therap.service;

import net.therap.dao.ProductServiceDao;
import net.therap.domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/18/14
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
@org.springframework.stereotype.Service
@Transactional
public class CompanyProductService {

    @Autowired
    private ProductServiceDao productServiceDao;

    public List<Service> getProductServiceList(){
        return productServiceDao.getProductServiceList();
    }
}
