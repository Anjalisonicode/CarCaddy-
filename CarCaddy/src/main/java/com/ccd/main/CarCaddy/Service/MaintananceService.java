package com.ccd.main.CarCaddy.Service;

import com.ccd.main.CarCaddy.Repository.MaintananceRepository;
import com.ccd.main.CarCaddy.model.Maintainance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
