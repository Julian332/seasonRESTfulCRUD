package com.trs.restfulcrud.web;

import com.trs.restfulcrud.pojo.Criminal;
import com.trs.restfulcrud.service.CriminalService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: TODO
 * Project: seasonRESTfulCRUD
 *
 * @author : Julian
 * Create Time:2019/12/4 10:39
 */
@RestController
@Controller
public class CriminalController {
    private final CriminalService criminalService;

    public CriminalController(CriminalService criminalService) {
        this.criminalService = criminalService;
    }

    @PostMapping(value = "/criminals")
    public Object save(Criminal criminal) {
        return criminalService.save(criminal);
    }

    @PutMapping(value = "/criminals/{id}")
    public Object update(Criminal criminal, @PathVariable Long id) {

        return criminalService.update(criminal);
    }

    @GetMapping(value = "/criminals/{id}")
    public Criminal findById(@PathVariable Long id) {
        return criminalService.findById(id);
    }

    @DeleteMapping(value = "/criminals/{id}")
    public Object deleteById(@PathVariable Long id) {
        return criminalService.deleteById(id);
    }

    @GetMapping(value = "criminals")
    public List<Criminal> findAll() {
        return criminalService.findAll();
    }

}
