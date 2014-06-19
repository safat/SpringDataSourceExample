package net.therap.controller;

import net.therap.domain.Client;
import net.therap.domain.Company;
import net.therap.domain.Service;
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


    @RequestMapping (value = "/addCompany", method = RequestMethod.GET)
    public String insertCompany(ModelMap modelMap) {
        Company company = new Company();
        company.setName("company 5");
        company.setAddress("address of company 5");

        List<Client> clientList = new ArrayList();

        Client client = new Client();
        client.setName("client 8");
        client.setAddress("address of client 8");
        clientList.add(client);

        client = new Client();
        client.setName("client 9");
        client.setAddress("address of client 9");
        clientList.add(client);

        company.setClientList(clientList);

        companyService.insertCompany(company);

        return "employeeInsertSuccess";
    }

    @RequestMapping (value = "/deleteCompany", method = RequestMethod.GET)
    public String deleteCompany(ModelMap modelMap) {
        companyService.deleteCompanyById(8);
        return "redirect:/companies";
    }


    @RequestMapping (value = "/companies", method = RequestMethod.GET)
    public String showCompanyList(ModelMap modelMap) {
        modelMap.addAttribute("list", getCompanyListString(companyService.getCompanyList()));
        return "companies";
    }


    @RequestMapping (value = "/company", method = RequestMethod.GET)
    public String getCompanyById(ModelMap modelMap) {
        modelMap.addAttribute("list", companyService.getCompanyById(1).toString());
        return "companies";
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

            tmp += "</br> services : </br>" ;
            for (Service service : comp.getServices()){
                tmp += "-->"+service.getServiceName()+"</br>";
            }

            tmp += "</br>";

        }

        return tmp;
    }
}
