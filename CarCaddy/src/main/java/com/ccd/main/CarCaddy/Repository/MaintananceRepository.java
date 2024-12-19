package com.ccd.main.CarCaddy.Repository;

import com.ccd.main.CarCaddy.model.Maintainance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface MaintananceRepository extends JpaRepository<Maintainance, Integer> {

}
