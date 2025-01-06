package com.carCaddy.Car_Rental.Repository;

import com.carCaddy.Car_Rental.Model.Maintainance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintananceRepository extends JpaRepository<Maintainance, Integer> {
}
