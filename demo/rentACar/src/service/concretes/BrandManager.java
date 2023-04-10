package service.concretes;

import entities.Brand;
import repository.InMemoryBrand;
import service.abstracts.BrandService;

import java.util.List;

public class BrandManager implements BrandService {

    private InMemoryBrand inMemoryBrand;

    public BrandManager(InMemoryBrand inMemoryBrand) {
        this.inMemoryBrand = inMemoryBrand;
    }


    @Override
    public List<Brand> getAll() {
        return inMemoryBrand.getAll();
    }

    @Override
    public Brand getById(int brandId) {
        checkIfBrandExists(brandId);
        return inMemoryBrand.findById(brandId).orElseThrow();
    }

    @Override
    public Brand getByName(String brandName) {
        checkIfBrandNameLengthValid(brandName);
        checkIfBrandExists(brandName);
        return inMemoryBrand.findByName(brandName).orElseThrow();
    }

    @Override
    public void add(Brand brand) {
        checkIfBrandNameLengthValid(brand.getName());
        checkIfBrandNameExists(brand.getName());
        inMemoryBrand.add(brand);
    }

    @Override
    public void update(int brandId, Brand updateBrand) {
        checkIfBrandExists(brandId);
        checkIfBrandNameLengthValid(updateBrand.getName());
        inMemoryBrand.update(brandId,updateBrand);
    }

    @Override
    public void delete(int brandId) {
        checkIfBrandExists(brandId);
        inMemoryBrand.delete(brandId);
    }


    private void checkIfBrandExists(int brandId){
        if(inMemoryBrand.findById(brandId).isEmpty())
            throw new RuntimeException(brandId+" numaralı brand bulunamadı");
    }
    private void checkIfBrandExists(String brandName){
        if(inMemoryBrand.findByName(brandName).isEmpty())
            throw new RuntimeException(brandName+" isimli brand bulunamadı");
    }
    private void checkIfBrandNameExists(String brandName){
        if(inMemoryBrand.findByName(brandName).isPresent())
            throw  new RuntimeException((brandName+" isimli brand zaten mevcuttur"));
    }
    private void checkIfBrandNameLengthValid(String brandName){
        if(brandName.length()<2)
            throw  new RuntimeException((brandName+" brand ismi en az 2 harften oluşmalıdır."));
    }
}
