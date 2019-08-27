package net.fernandosimon.crosstownbeerservice.web.mappers;

import net.fernandosimon.crosstownbeerservice.domain.Beer;
import net.fernandosimon.crosstownbeerservice.web.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * @author developer
 * @date 2019-08-26
 * @time 19:35
 */
@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDTO BeerToBeerDTO(Beer beer);

    Beer BeerDTOToBeer(BeerDTO dto);


}
