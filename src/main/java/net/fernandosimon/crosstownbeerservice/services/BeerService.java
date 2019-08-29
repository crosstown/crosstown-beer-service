package net.fernandosimon.crosstownbeerservice.services;

import net.fernandosimon.crosstownbeerservice.web.model.BeerDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-29
 * @time 09:59
 */
public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO dto);

    BeerDTO updateBeer(UUID beerId, BeerDTO dto);
}
