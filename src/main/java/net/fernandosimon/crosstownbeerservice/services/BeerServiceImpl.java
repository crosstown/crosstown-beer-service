package net.fernandosimon.crosstownbeerservice.services;

import lombok.RequiredArgsConstructor;
import net.fernandosimon.crosstownbeerservice.domain.Beer;
import net.fernandosimon.crosstownbeerservice.repositories.BeerRepository;
import net.fernandosimon.crosstownbeerservice.web.controller.NotFoundException;
import net.fernandosimon.crosstownbeerservice.web.mappers.BeerMapper;
import net.fernandosimon.crosstownbeerservice.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-29
 * @time 10:09
 */
@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDTO getById(UUID beerId) {
        return beerMapper.beerToBeerDTO(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO dto) {
        return beerMapper.beerToBeerDTO(beerRepository.save(beerMapper.beerDTOToBeer(dto)));
    }

    @Override
    public BeerDTO updateBeer(UUID beerId, BeerDTO dto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(dto.getBeerName());
        beer.setBeerStyle(dto.getBeerStyle().name());
        beer.setPrice(dto.getPrice());
        beer.setUpc(dto.getUpc());

        return beerMapper.beerToBeerDTO(beerRepository.save(beer));
    }
}
