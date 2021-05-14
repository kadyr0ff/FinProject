package kz.iitu.FinProject.controller;


import kz.iitu.FinProject.model.City;
import kz.iitu.FinProject.repo.CityRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/cities")
public class CityController {

    private final CityRepo cityRepo;

    CityController(CityRepo cityRepo){
        this.cityRepo = cityRepo;
        if (cityRepo.count() <= 0) {
            ArrayList<City> cities = new ArrayList<>();
            cities.add(new City("Astana"));
            cities.add(new City("Almaty"));
            cities.add(new City("Shymkent"));
            cities.add(new City("Karaganda"));
            cities.add(new City("Pavlodar"));
            cities.add(new City("Atyrau"));
            cities.add(new City("Ust-Kamenogorsk"));
            cities.add(new City("Zhezkazgan"));
            cities.add(new City("Aktobe"));
            cityRepo.saveAll(cities);
        }
    }

}
