package service.abstracts;

import entities.Model;

import java.util.List;

public interface ModelService {

    List<Model> getAll();
    Model getById(int modelId);
    Model getByName(String modelName);
    void add(Model model);
    void update(int modelId, Model updateModel);
    void delete(int modelId);

}
