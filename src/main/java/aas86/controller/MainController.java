package aas86.controller;

import aas86.model.Account;
import aas86.model.Client;
import aas86.service.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

/**
 * Created by 437-5 on 06.12.2018.
 */
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
    public void addClient(@RequestBody String name){
        String substring = name.substring(9, name.length() - 2);
        serviceClient.addClient(substring);
    }

    @RequestMapping(value = "/getAccounts", method = RequestMethod.POST)
  //  @ResponseBody
    public void getAccounts(@RequestBody String name){
        //System.out.println(name);
        String substring = name.substring(9, name.length() - 2);
        //System.out.println(substring);
        LinkedList<Account> list = serviceClient.getClientAccounts();
        list.stream().forEach(x -> System.out.println(x.getOwnerName() + x.getMoney()));
        }

    }

