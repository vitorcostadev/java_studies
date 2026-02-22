package src.streams.domain;

import java.util.Objects;

public class LightNovel {
    private String title;
    private Double price;

    public LightNovel(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        LightNovel that = (LightNovel) object;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}
