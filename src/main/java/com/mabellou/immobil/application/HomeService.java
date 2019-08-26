package com.mabellou.immobil.application;

import com.mabellou.immobil.application.command.CreateHomeCommand;
import com.mabellou.immobil.application.representation.HomeDto;
import com.mabellou.immobil.application.representation.HomeDtoAssembler;
import com.mabellou.immobil.domain.model.Home;
import com.mabellou.immobil.domain.model.HomeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HomeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeService.class);

    private HomeRepository homeRepository;
    private HomeDtoAssembler homeDtoAssembler;

    public HomeService(HomeRepository homeRepository, HomeDtoAssembler homeDtoAssembler) {
        this.homeRepository = homeRepository;
        this.homeDtoAssembler = homeDtoAssembler;
    }

    public Long createHome(CreateHomeCommand command){
        Home home = new Home(command.url);
        homeRepository.save(home);
        LOGGER.info("Home created with id {}", home.getId());
        return home.getId();
    }

    public Optional<HomeDto> getHome(Long id){
        Optional<Home> homeOptional = homeRepository.findById(id);
        return homeOptional.map(home -> homeDtoAssembler.convert(home));
    }
}
