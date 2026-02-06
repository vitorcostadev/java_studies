package src.collections.domain;

public enum Severity {
    INFO(1, "Info"),
    WARN(2, "Warning"),
    ERROR(3, "Error");

    private int id;
    private String attrName;

    Severity(int id, String attrName) {
        this.id = id;
        this.attrName = attrName;
    }

    @Override
    public String toString() {
        return "Severity{" +
                "id=" + id +
                ", attrName='" + attrName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
}
