package aas86.controller;

import aas86.dto.ClientDto;
import aas86.model.Account;
import aas86.model.Client;
import aas86.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedList;


@Controller
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    private ServiceClient serviceClient;

    @RequestMapping(value = "/allClients", method = RequestMethod.GET)
    public String getAllClients(Model model) {
        LinkedList<Client> list = serviceClient.getAllClients();
        model.addAttribute("clientList", list);
        return "index";
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    @ResponseBody
    public void addClient(@RequestBody ClientDto client) {
        System.out.println(client);
        serviceClient.addClient(client.getName());
    }

    @RequestMapping(value = "/getAccounts", method = RequestMethod.GET)
    // @ResponseBody

    public String getAccounts(Model model,
                              @RequestParam String name) {
        System.out.println(name);
        LinkedList<Account> list = serviceClient.getClientAccounts(name);
        list.stream().forEach(x -> System.out.println(x.getOwnerName() + x.getMoney()));

        model.addAttribute("accountList", list);
        return "accounts";

    }



}

