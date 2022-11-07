public class Complex {
    private int real, image;

    public Complex() {
    }

    public Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public String toString() {
        return real + String.format(" + %.0f", (float) image).toString() + "i";
    }
}