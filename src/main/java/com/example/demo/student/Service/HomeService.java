package com.example.demo.student.Service;

import com.example.demo.student.Entity.Home;
import com.example.demo.student.Repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HomeService {

    @Autowired
    private HomeRepository homeRepository;

    public List<Home> getHomes(){
        return homeRepository.findAll();
    }

    public void addHome(Home home){
        homeRepository.save(home);
    }

    public void deleteHome(Long homeId){
        Optional<Home> homeOptional = homeRepository.findById(homeId);
        if(homeOptional.isEmpty()){
            throw new IllegalStateException("There is no home with this Id");
        }
        homeRepository.deleteById(homeId);
    }

    @Transactional
    public void updateHome(Long homeId, String homeState, String homeCity){
        Home home = homeRepository.findById(homeId).orElseThrow(
                () ->new IllegalStateException("No home with this Id"));
        home.setState(homeState);
        home.setCity(homeCity);
    }


}
