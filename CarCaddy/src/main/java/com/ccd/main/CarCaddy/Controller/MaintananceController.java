package com.ccd.main.CarCaddy.Controller;

import com.ccd.main.CarCaddy.Service.MaintananceService;
import com.ccd.main.CarCaddy.model.Maintainance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaintananceController {
    @Autowired
    MaintananceService maintananceService;
    //getting all maintenance records
    @GetMapping("/getAllMaintenance")
    public List<Maintainance>getAllMaintenance(){
        List<Maintainance>list= maintananceService.getAllMaintenance();
        return list;
    }
    //Getting specific maintenance by the maintenance Id
    @PostMapping("/create")
    public String createMaintenance(@RequestBody Maintainance maintainance) {
        System.out.println("Received data: " + maintainance); // Log incoming data
        maintananceService.createMaintenance(maintainance);
        return "Data gets added Successfully";
    }
}
