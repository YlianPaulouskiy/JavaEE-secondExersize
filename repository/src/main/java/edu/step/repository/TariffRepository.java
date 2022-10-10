package edu.step.repository;

import edu.step.entity.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Long> {

    Tariff findByPriceBetweenAndMinutesBetweenAndMegabytesBetween(Double priceFrom, Double priceTo, Integer minutesFrom, Integer minutesTo, Integer megabytesFrom, Integer megabytesTo);

}
