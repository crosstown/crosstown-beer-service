package net.fernandosimon.crosstownbeerservice.web.controller;

import net.fernandosimon.crosstownbeerservice.web.model.BeerDTO;
import net.fernandosimon.crosstownbeerservice.web.model.BeerPagedList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author developer
 * @date 2019-08-19
 * @time 22:29
 */
@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody BeerDTO beerDTO) {
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
