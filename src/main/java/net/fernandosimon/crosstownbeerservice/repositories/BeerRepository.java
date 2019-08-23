package net.fernandosimon.crosstownbeerservice.repositories;

import net.fernandosimon.crosstownbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-22
 * @time 20:56
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
