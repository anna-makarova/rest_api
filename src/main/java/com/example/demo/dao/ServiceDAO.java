package com.example.demo.dao;

import com.example.demo.model.Service;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceDAO {
    private static int PEOPLE_COUNT;
    private List<Service> services;

    {
        services = new ArrayList<>();
        services.add(new Service(++PEOPLE_COUNT, "Первичный прием терапевта", 132,"Первичный осмотр терапевта для выявления проблемы и назначения лечения",1800));
        services.add(new Service(++PEOPLE_COUNT, "Повторный прием терапевта", 132,"Повторный осмотр для корректировки лечения",1200));
        services.add(new Service(++PEOPLE_COUNT, "Рентген", 15,"Рентген легких проводится с целью выявления заболеваний легких",800));
        services.add(new Service(++PEOPLE_COUNT, "УЗИ", 28,"Ультро-звуковая диагностика", 1200));
    }

    public List<Service> index() {
        return services;
    }

    public Service show(int id) {
        return services.stream().filter(services -> services.getId() == id).findAny().orElse(null);
    }

    public void save(Service service) {
        service.setId(++PEOPLE_COUNT);
        services.add(service);
    }

    public void update(int id, Service updateService) {
        Service serviceToBeUpdated = show(id);
        serviceToBeUpdated.setName(updateService.getName());
        serviceToBeUpdated.setCabinet(updateService.getCabinet());
        serviceToBeUpdated.setDescription(updateService.getDescription());
        serviceToBeUpdated.setCost(updateService.getCost());
    }

    public void delete(int id) {
        services.removeIf(r ->r.getId() == id);
    }
}
