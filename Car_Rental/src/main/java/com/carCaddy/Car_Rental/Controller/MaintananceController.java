package com.carCaddy.Car_Rental.Controller;


import com.carCaddy.Car_Rental.Model.Maintainance;
import com.carCaddy.Car_Rental.Repository.MaintananceRepository;
import com.carCaddy.Car_Rental.Service.MaintananceService;
import com.carCaddy.Car_Rental.exception.InvalidEntityException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String saveMaintenanceRecord(@Valid @ModelAttribute("record") Maintainance record, BindingResult result, Model model) {
        System.out.println("Postmappping controller is runningggg.............");
        if (result.hasErrors()) {
            // Return the same form with errors

            return "create-maintenance";
        }
        try {
            maintananceService.createMaintenance(record);
        } catch (InvalidEntityException ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "create-maintenance";
        }

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
        // model.addAttribute("successMessage", "Maintenance record deleted successfully!");
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
        //record.setMaintenance_Id(id); // Ensure the correct ID is set for updating
        maintananceService.updateMaintenance(record); // Call service to update the record
        // model.addAttribute("successMessage", "Maintenance record updated successfully!");
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