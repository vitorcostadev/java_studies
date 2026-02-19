package desafios.sistema.domain;

public class Address {
    private Integer number;
    private String city;
    private String road;

    public Integer getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getRoad() {
        return road;
    }

    @Override
    public String toString() {
        return "Address{" +
                "number=" + number +
                ", city='" + city + '\'' +
                ", road='" + road + '\'' +
                '}';
    }

    public Address(Integer number, String city, String road) {
        this.number = number;
        this.city = city;
        this.road = road;
    }
}
