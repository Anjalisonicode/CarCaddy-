package com.ccd.main.CarCaddy.Service;

import ch.qos.logback.core.model.Model;
import com.ccd.main.CarCaddy.Repository.MaintananceRepository;
import com.ccd.main.CarCaddy.model.Maintainance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MaintananceService {
    @Autowired
    MaintananceRepository maintananceRepository;
    public List<Maintainance> getAllMaintenance(){
        return maintananceRepository.findAll();

    }
    public void createMaintenance(Maintainance maintainance){

        maintananceRepository.save(maintainance);
    }

    public Maintainance getById(Integer id) {
       Optional<Maintainance>maintainance= maintananceRepository.findById(id);
       return maintainance.orElseThrow(()->new RuntimeException("This Particular maintenance is not fount please try with another"));
    }
    public void deleteMaintenance(Integer id) {
        try {
            maintananceRepository.deleteById(id); // Deletes the maintenance record by ID
        } catch (Exception e) {
            throw new RuntimeException("Error deleting the maintenance record", e);
        }
    }
    public void updateMaintenance(Maintainance record) {
        try {
            maintananceRepository.save(record); // Save the updated record
        } catch (Exception e) {
            throw new RuntimeException("Error updating the maintenance record", e);
        }
    }
    // Get a record by ID
    public Maintainance getMaintenanceById(Integer id) {
        return maintananceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Maintenance record not found for ID: " + id));
    }

    // Update a record


}
