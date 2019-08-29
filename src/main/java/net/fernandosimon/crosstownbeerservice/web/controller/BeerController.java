package net.fernandosimon.crosstownbeerservice.web.controller;

import lombok.RequiredArgsConstructor;
import net.fernandosimon.crosstownbeerservice.services.BeerService;
import net.fernandosimon.crosstownbeerservice.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-19
 * @time 22:29
 */
@RequiredArgsConstructor
@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDTO beerDTO) {
        return new ResponseEntity(beerService.saveNewBeer(beerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody @Validated BeerDTO beerDTO) {
        return new ResponseEntity(beerService.updateBeer(beerId, beerDTO), HttpStatus.NO_CONTENT);
    }
}
