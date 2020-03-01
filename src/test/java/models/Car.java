package models;

public class Car {
    private final String vehicle;
    private final String model;
    private final String bodyType;
    private final String fuelType;
    private final String enginePower;
    private final String engine;
    private final String engineModel;

    public Car(String vehicle, String model, String bodyType, String fuelType, String enginePower, String engine,
               String engineModel) {
        this.vehicle = vehicle;
        this.model = model;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
        this.enginePower = enginePower;
        this.engine = engine;
        this.engineModel = engineModel;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getModel() {
        return model;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public String getEngine() {
        return engine;
    }

    public String getEngineModel() {
        return engineModel;
    }
}
