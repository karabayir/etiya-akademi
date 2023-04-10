package service.concretes;

import entities.Model;
import repository.InMemoryModel;
import service.abstracts.ModelService;

import java.util.List;

public class ModelManager implements ModelService {

    private InMemoryModel inMemoryModel;

    public ModelManager(InMemoryModel inMemoryModel) {
        this.inMemoryModel = inMemoryModel;
    }

    @Override
    public List<Model> getAll() {
        return inMemoryModel.getAll();
    }

    @Override
    public Model getById(int modelId) {
        checkIfModelExists(modelId);
        return inMemoryModel.findById(modelId).orElseThrow();
    }

    @Override
    public Model getByName(String modelName) {
        checkIfModelNameLengthValid(modelName);
        checkIfModelExists(modelName);
        return inMemoryModel.findByName(modelName).orElseThrow();
    }

    @Override
    public void add(Model model) {
        checkIfModelNameExists(model.getName());
        checkIfModelNameLengthValid(model.getName());
         inMemoryModel.add(model);
    }

    @Override
    public void update(int modelId, Model updateModel) {
        checkIfModelExists(modelId);
        checkIfModelNameLengthValid(updateModel.getName());
        inMemoryModel.update(modelId,updateModel);
    }

    @Override
    public void delete(int modelId) {
        checkIfModelExists(modelId);
        inMemoryModel.delete(modelId);
    }

    private void checkIfModelExists(int modelId){
        if (inMemoryModel.findById(modelId).isEmpty())
            throw  new RuntimeException(modelId+" numaralı model bulunamadı");
    }
    private void checkIfModelExists(String modelName){
        if(inMemoryModel.findByName(modelName).isEmpty())
            throw  new RuntimeException(modelName+" isimli model bulunamadı");
    }

    private void checkIfModelNameExists(String modelName){
        if(inMemoryModel.findByName(modelName).isPresent())
            throw  new RuntimeException(modelName+" isimli model zaten mevcuttur");
    }
    private  void checkIfModelNameLengthValid(String modelName){
        if(modelName.length()<1)
            throw  new RuntimeException(modelName+" model ismi en az 1 harf ile oluşmalıdır");
    }
}
