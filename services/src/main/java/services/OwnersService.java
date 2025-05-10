package services;

import dto.GetOwnerDto;
import dto.PatchOwnerDto;
import dto.PostOwnerDto;
import entities.Cat;
import entities.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import repositories.OwnersRepository;


@ComponentScan("repositories")
@Service
public class OwnersService {
    @Autowired
    OwnersRepository repo;

    public GetOwnerDto get(int id) throws Exception {
        var opt = repo.findById(id);
        if (opt.isEmpty()) {
            throw new Exception(String.format("Not found owner with id [%d]", id));
        }
        return mapToGetDto(opt.get());
    }

    public GetOwnerDto post(PostOwnerDto dto) {
        return mapToGetDto(repo.save(mapFromPostDto(dto)));
    }

    public GetOwnerDto patch(int id, PatchOwnerDto dto) throws Exception {
        var opt = repo.findById(id);
        if (opt.isEmpty()) {
            throw new Exception(String.format("Not found owner with id [%d]", id));
        }
        var owner = mapFromPatchDto(dto);
        owner.setId(id);
        return mapToGetDto(repo.save(owner));
    }

    public void delete(int id) throws Exception {
        if (!repo.existsById(id)) {
            throw new Exception(String.format("Not found owner with id [%d]", id));
        }
        repo.deleteById(id);
    }


    private Owner mapFromPostDto(PostOwnerDto dto) {
        return new Owner(dto.name, dto.birthDate);
    }

    private Owner mapFromPatchDto(PatchOwnerDto dto) {
        return new Owner(dto.name, dto.birthDate);
    }


    private GetOwnerDto mapToGetDto(Owner owner) {
        return new GetOwnerDto(owner.getName(),
                owner.getBirthDate(),
                owner.getOwned()
                        .stream()
                        .map(Cat::getId).toList());
    }


}
