package service.abstracts;

import entities.Brand;

import java.util.List;

public interface BrandService {

    List<Brand> getAll();
    Brand  getById(int brandId);
    Brand  getByName(String brandName);
    void add(Brand brand);
    void update(int brandId, Brand updateBrand);
    void delete(int brandId);

}
