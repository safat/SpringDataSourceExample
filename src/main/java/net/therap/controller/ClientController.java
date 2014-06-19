package net.therap.controller;

import net.therap.domain.Client;
import net.therap.domain.Company;
import net.therap.domain.Service;
import net.therap.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shakhawat.hossain
 * Date: 6/17/14
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping (value = "/clients", method = RequestMethod.GET)
    public String showCompanyList(ModelMap modelMap) {
        modelMap.addAttribute("clientList", getClientListString(clientService.getClientList()));
        return "clients";
    }

    private String getClientListString(List<Client> clientList) {
        String tmp = "";
        for (Client client : clientList) {
            tmp += "</br>####";
            tmp += client.toString() + "</br></br>\t";
            for (Company company : client.getCompanyList()) {
                tmp += "--> ";
                tmp += company.toString() + "</br>";
            }

            if(client.getServiceList().size() == 0) continue;

            tmp +="</br> <<----------------------- services ---------------------------------------------->></br>";
            for (Service service : client.getServiceList()){
                tmp += "------------>";
                tmp += service.getServiceName()+" </br>";
            }
        }

        return tmp;
    }

}