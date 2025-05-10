package controllers;

import dto.GetOwnerDto;
import dto.PatchOwnerDto;
import dto.PostOwnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import services.OwnersService;

@ComponentScan({"services"})
@RestController
public class OwnersController {

    @Autowired
    OwnersService service;

    @GetMapping(value = "/test")
    public String test() {
        return "Hello motherfucker";
    }

    @GetMapping(value = "/{id}")
    public GetOwnerDto get(@PathVariable int id) throws Exception {
        return service.get(id);
    }

    @PostMapping()
    public GetOwnerDto post(@RequestBody PostOwnerDto dto) {
        return service.post(dto);
    }

    @PatchMapping("/{id}")
    public GetOwnerDto patch(@PathVariable int id, @RequestBody PatchOwnerDto dto) throws Exception {
        return service.patch(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception {
        service.delete(id);
    }

}
