package by.academy.it.pojos2;

public class Car {
    private Integer cid;
    private String brand;
    private String model;
    private Integer year;
    private Integer carAge;

    public Car() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCarAge() {
        return carAge;
    }

    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (getCid() != null ? !getCid().equals(car.getCid()) : car.getCid() != null) return false;
        if (getBrand() != null ? !getBrand().equals(car.getBrand()) : car.getBrand() != null) return false;
        if (getModel() != null ? !getModel().equals(car.getModel()) : car.getModel() != null) return false;
        return getYear() != null ? getYear().equals(car.getYear()) : car.getYear() == null;

    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "cid=" + cid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", carAge=" + carAge +
                '}';
    }
}
