package com.example.demo.student.Controller;

import com.example.demo.student.Dto.HomeDto;
import com.example.demo.student.Entity.Home;
import com.example.demo.student.Service.HomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private  ModelMapper modelMapper;

    @GetMapping(path = "/home")
    public List<Home> getHomes(){ return homeService.getHomes();}

    @PostMapping
    public void postHome(@RequestBody @Valid HomeDto homeDto){
        Home home = new Home();
        home = modelMapper.map(homeDto,Home.class);
        homeService.addHome(home);}

    @DeleteMapping(path = "{homeId}")
    public void deleteHome(@PathVariable("{homeId}") Long homeId){
        homeService.deleteHome(homeId);
    }

    @PutMapping(path = "{homeId}")
    public void putHome(
            @PathVariable("{homeId}") Long homeId,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city){
        homeService.updateHome(homeId,state,city);}

}
