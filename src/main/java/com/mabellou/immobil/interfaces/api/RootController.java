package com.mabellou.immobil.interfaces.api;

import com.mabellou.immobil.application.HomeService;
import com.mabellou.immobil.application.command.CreateHomeCommand;
import com.mabellou.immobil.application.representation.HomeDto;
import com.mabellou.immobil.domain.model.Home;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class RootController {

    private HomeService homeService;

    public RootController(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping("/home")
    public ResponseEntity createHome(@RequestBody CreateHomeCommand command) {
        Long id = homeService.createHome(command);
        URI location = getUriLocationFromId(id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/home/{id}")
    public ResponseEntity<HomeDto> getHome(
            @PathVariable("id") Long id
    ) {
        return homeService.getHome(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private URI getUriLocationFromId(Long id) {
        return ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(id)
                    .toUri();
    }
}
