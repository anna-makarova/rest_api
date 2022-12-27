package com.example.demo.controller;

import com.example.demo.dao.ServiceDAO;
import com.example.demo.model.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {

    private final ServiceDAO serviceDAO;

    public ServiceController(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    @GetMapping()
    public List<Service> index() {
        return serviceDAO.index();
    }

    @GetMapping("/{id}")
    public Service show(@PathVariable("id")int id) {
        return serviceDAO.show(id);
    }

//    @GetMapping("/new")
//    public String newResident(Model model) {
//        model.addAttribute("resident", new Resident());
//        return "new";
//    }

    @PostMapping()
    public void create(@RequestBody Service service) {
        serviceDAO.save(service);
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("resident", residentDAO.show(id));
//        return "edit";
//    }

    @PatchMapping("/{id}")
    public void update(@RequestBody Service service, @PathVariable("id") int id) {
        serviceDAO.update(id, service);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        serviceDAO.delete(id);
    }
}
