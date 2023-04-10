package entities;

public class Car {

    private int id;
    private String plate;
    private int modelYear;
    private double dailyPrice;

    private  CarState carState;

    private  int modelId;

    private int brandId;


    public Car(int id, String plate, int modelYear, double dailyPrice, CarState carState, int modelId, int brandId) {
        this.id = id;
        this.plate = plate;
        this.modelYear = modelYear;
        this.dailyPrice = dailyPrice;
        this.carState = carState;
        this.modelId = modelId;
        this.brandId = brandId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
