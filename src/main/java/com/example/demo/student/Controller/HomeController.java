package com.example.demo.student.Controller;

import com.example.demo.student.Dto.HomeDto;
import com.example.demo.student.Entity.Home;
import com.example.demo.student.Entity.Student;
import com.example.demo.student.Repository.HomeRepository;
import com.example.demo.student.Repository.StudentRepository;
import com.example.demo.student.Service.HomeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private HomeRepository homeRepository;

    private Long count = Long.valueOf(0);

    @GetMapping(path = "/home")
    public List<Home> getHomes(){ return homeService.getHomes();}

    @PostMapping
    public void postHome(@RequestBody @Valid HomeDto homeDto){
        Home home = new Home();
        home = modelMapper.map(homeDto,Home.class);
        List<Student> availableStudents = studentRepository.checkForAvailableStudent(count);
        if (availableStudents.isEmpty()) {
            throw new IllegalStateException("No available students to place in home, " +
                    "please place new student and try again");
        }
        else{
            Optional<Home> homeOptional = homeRepository.findByState_City(home.getState(),home.getCity());
            if(homeOptional.isEmpty()){count++;}
            home.setStudent(availableStudents.get(0));
            homeService.addHome(home);}
        }


    @DeleteMapping(path = "/{homeId}")
    public void deleteHome(@PathVariable("homeId") Long homeId){
        homeService.deleteHome(homeId);
    }

    @PutMapping(path = "/{homeId}/")
    public void putHome(
            @PathVariable("homeId") Long homeId,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String city){
        homeService.updateHome(homeId,state,city);}
}
