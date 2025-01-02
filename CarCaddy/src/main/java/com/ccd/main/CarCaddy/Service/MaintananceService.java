package com.ccd.main.CarCaddy.Service;

import ch.qos.logback.core.model.Model;
import com.ccd.main.CarCaddy.Repository.MaintananceRepository;
import com.ccd.main.CarCaddy.exception.InvalidEntityException;
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
        if (maintainance == null || maintainance.getCar_id() == null) {
            throw new InvalidEntityException("Invalid maintenance record. Car ID is required.");
        }
        maintananceRepository.save(maintainance);
    }

    public Maintainance getById(Integer id) {
       Optional<Maintainance>maintainance= maintananceRepository.findById(id);
       return maintainance.orElseThrow(()->new InvalidEntityException("Maintenance record with ID " + id + " not found."));
    }
    public void deleteMaintenance(Integer id) {
        if (!maintananceRepository.existsById(id)) {
            throw new InvalidEntityException("Cannot delete record. Maintenance ID " + id + " not found.");
        }

            maintananceRepository.deleteById(id); // Deletes the maintenance record by Id
    }
    public void updateMaintenance(Maintainance record) {
        if (!maintananceRepository.existsById(record.getMaintenance_Id())) {
            throw new InvalidEntityException("Cannot update record. Maintenance ID " + record.getMaintenance_Id() + " not found.");
        }

            maintananceRepository.save(record); // Save the updated record
    }
    // Get a record by ID
    public Maintainance getMaintenanceById(Integer id) {
        return maintananceRepository.findById(id)
                .orElseThrow(() -> new InvalidEntityException("Maintenance record not found for ID: " + id));
    }

    // Update a record


}
