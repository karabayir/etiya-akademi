package repository;

import entities.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryModel {

    List<Model> models = new ArrayList<>();

    public List<Model> getAll(){
        return models;
    }
    public void add(Model model){
        models.add(model);
        System.out.println(model.getName()+" isimli model eklendi");
    }

    public void update(int modelId, Model updateModel){
        Model model = findById(modelId).orElseThrow();
        models.set(models.indexOf(model),updateModel);
        System.out.println(modelId+" numaralı model güncellendi");
    }

    public void delete(int modelId){
        Model model = findById(modelId).orElseThrow();
        models.remove(model);
        System.out.println(modelId+" numaralı model kaldırıldı");
    }


    public Optional<Model>  findById(int modelId){
        return  models.stream()
                .filter(m -> m.getId() == modelId)
                .findAny();
    }
    public Optional<Model> findByName(String name){
        return models.stream()
                .filter(m -> m.getName().equals(name))
                .findAny();
    }

}
