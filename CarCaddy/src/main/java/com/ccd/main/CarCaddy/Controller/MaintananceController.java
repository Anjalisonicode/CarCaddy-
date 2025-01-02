package com.ccd.main.CarCaddy.Controller;


import com.ccd.main.CarCaddy.Repository.MaintananceRepository;
import com.ccd.main.CarCaddy.Service.MaintananceService;
import com.ccd.main.CarCaddy.model.Maintainance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;
import java.util.List;

    @Controller
public class MaintananceController {
    @Autowired
    MaintananceService maintananceService;

    @Autowired
    MaintananceRepository maintananceRepository;


    @GetMapping("/maintenance")
    public String showMaintenanceForm(Model model) {
        model.addAttribute("record", new Maintainance());
        System.out.println("Code is running , REQUEST IS CAME HERE.............");
        return "create-maintenance";
    }

    @PostMapping("/maintenance")
    public String saveMaintenanceRecord(@ModelAttribute Maintainance record, Model model) {
        System.out.println("Postmappping controller is runningggg.............");
//        try {
            //  maintananceRepository.save(record);
            maintananceService.createMaintenance(record);
            // model.addAttribute("successMessage", "Maintenance record saved successfully!");
//        } catch (Exception e) {
            //model.addAttribute("errorMessage", "Failed to save maintenance record.");
//        }
        return "redirect:/maintenance/list";
    }

    @GetMapping("/maintenance/list")
    public String viewMaintenanceRecords(Model model) {
        model.addAttribute("records", maintananceService.getAllMaintenance());
        return "view-maintenance"; // No redirect needed, render the template directly
    }
    @GetMapping("/maintenance/delete/{id}")
    public String deleteMaintenanceRecord(@PathVariable("id") Integer id, Model model) {
//        try {
            maintananceService.deleteMaintenance(id); // Call the service to delete the record
            model.addAttribute("successMessage", "Maintenance record deleted successfully!");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Failed to delete maintenance record.");
//        }
        return "redirect:/maintenance/list"; // Redirect to the maintenance list page
    }
    @GetMapping("/maintenance/edit/{id}")
    public String showEditMaintenanceForm(@PathVariable("id") Integer id, Model model) {
       // try {
            Maintainance record = maintananceService.getMaintenanceById(id); // Get the record by ID
            model.addAttribute("record", record);
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Record not found.");
//        }
        return "edit-maintenance"; // Return the edit form view
    }

    // Handle Update Submission
    @PostMapping("/maintenance/edit/{id}")
    public String updateMaintenanceRecord(@PathVariable("id") Integer id, @ModelAttribute Maintainance record, Model model) {
       // try {
            record.setMaintenance_Id(id); // Ensure the correct ID is set for updating
            maintananceService.updateMaintenance(record); // Call service to update the record
            model.addAttribute("successMessage", "Maintenance record updated successfully!");
//        } catch (Exception e) {
//            model.addAttribute("errorMessage", "Failed to update maintenance record.");
//        }
        return "redirect:/maintenance/list"; // Redirect to list page after updating
    }
//    @RequestMapping(value ="/about", method = RequestMethod.GET)
//    public String about(){
//        System.out.println("Testing/.........................the Code ....THANK YOU...");
//        return "aboutPage";
//    }

}
