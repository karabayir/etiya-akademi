package repository;

import entities.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBrand {

    List<Brand> brands = new ArrayList<>();

    public List<Brand> getAll(){
        return brands;
    }

    public void add(Brand brand){
        brands.add(brand);
        System.out.println(brand.getId()+" numaralı brand eklendi");
    }

    public void update(int brandId, Brand updateBrand){
        Brand brand = findById(brandId).orElseThrow();
        brands.set(brands.indexOf(brand),updateBrand);
        System.out.println(brandId+" numaralı brand güncellendi");
    }

    public void delete(int brandId){
        Brand brand = findById(brandId).orElseThrow();
        brands.remove(brands.indexOf(brand));
        System.out.println(brandId+" numaralı brand kaldırıldı");
    }

    public Optional<Brand> findById(int brandId){
        return brands.stream()
                .filter(b -> b.getId() == brandId)
                .findAny();
    }

    public Optional<Brand> findByName(String brandName){
        return brands.stream()
                .filter(b -> b.getName().equals(brandName))
                .findAny();
    }
}
