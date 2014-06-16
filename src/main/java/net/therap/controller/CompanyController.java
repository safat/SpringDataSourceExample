package net.therap.controller;

import net.therap.domain.Client;
import net.therap.domain.Company;
import net.therap.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/16/14
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    @RequestMapping (value = "/insert", method = RequestMethod.GET)
    public String insertCompany(ModelMap modelMap) {
        Company company = new Company();
        company.setName("company 4");
        company.setAddress("address of company 4");

        List<Client> clientList = new ArrayList();

        Client client = new Client();
        client.setName("client 6");
        client.setAddress("address of client 6");
        clientList.add(client);

        client = new Client();
        client.setName("client 7");
        client.setAddress("address of client 7");
        clientList.add(client);

        company.setClientList(clientList);

        companyService.insertCompany(company);

        return "employeeInsertSuccess";
    }

    @RequestMapping (value = "/show", method = RequestMethod.GET)
    public String showCompanyList(ModelMap modelMap) {
        modelMap.addAttribute("list", getCompanyListString(companyService.getCompanyList()));
        return "showCompanies";
    }

    private String getCompanyListString(List<Company> companyList) {
        String tmp = "";
        for (Company comp : companyList) {
            tmp += "</br>";
            tmp += comp.toString() + "</br></br>\t";
            for (Client client : comp.getClientList()) {
                tmp += "-> ";
                tmp += client.toString() + "</br>";
            }
        }

        return tmp;
    }
}
