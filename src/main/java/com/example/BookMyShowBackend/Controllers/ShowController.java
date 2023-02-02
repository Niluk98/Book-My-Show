package com.example.BookMyShowBackend.Controllers;


import com.example.BookMyShowBackend.DTO.ShowRequestDTO;
import com.example.BookMyShowBackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public String addShow(@RequestBody ShowRequestDTO showRequestDTO){
         return showService.addShow(showRequestDTO);
    }
}
