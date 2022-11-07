public class Shirt {
    private String id, type, color, size;

    public Shirt(String shirt) {
        String[] strings = new String[4];
        strings = shirt.split(",");
        id = strings[0];
        type = strings[1];
        color = strings[2];
        size = strings[3];
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}