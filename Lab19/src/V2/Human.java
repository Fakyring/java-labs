package V2;

import java.util.Random;

public class Human {
    private String name;
    public Head Head = new Head();
    public Leg Leg = new Leg();
    public Hand Hand = new Hand();

    private boolean is_alive = true, gender;

    public Human(String n) {
        name = n;
        gender = new Random().nextBoolean();
    }

    public Human(String n, boolean g) {
        name = n;
        gender = g;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public boolean getStatus() {
        return is_alive;
    }

    public void setStatus(boolean status) {
        is_alive = status;
    }

    @Override
    public String toString() {
        return name + " {" +
                "alive=" + is_alive +
                ", gender=" + (gender == true ? "male" : "female") +
                '}';
    }

    public class Head {
        private int eyes, ears;
        private boolean nose, mouth, hairs;
        private String hair_color;

        public Head() {
            eyes = 2;
            ears = 2;
            nose = true;
            mouth = true;
            hairs = true;
            hair_color = "Black";
        }

        public int getEyes() {
            return eyes;
        }

        public int getEars() {
            return ears;
        }

        public String getHair_color() {
            return hair_color;
        }

        public void setEars(int ears) {
            this.ears = ears;
        }

        public void setEyes(int eyes) {
            this.eyes = eyes;
        }

        public void setHair_color(String hair_color) {
            this.hair_color = hair_color;
        }

        public void setHairs(boolean hairs) {
            this.hairs = hairs;
        }

        public void setMouth(boolean mouth) {
            this.mouth = mouth;
        }

        public void setNose(boolean nose) {
            this.nose = nose;
        }

        @Override
        public String toString() {
            return "Head {" +
                    "eyes=" + eyes +
                    ", ears=" + ears +
                    ", nose=" + nose +
                    ", mouth=" + mouth +
                    ", hairs=" + hairs +
                    ", hair_color='" + hair_color + '\'' +
                    '}';
        }
    }

    public class Leg {
        private int fingers = 5;

        public int getFingers() {
            return fingers;
        }

        public void setFingers(int fingers) {
            this.fingers = fingers;
        }

        @Override
        public String toString() {
            return "Leg {" +
                    "fingers=" + fingers +
                    '}';
        }
    }

    public class Hand {
        private int fingers = 5;

        public int getFingers() {
            return fingers;
        }

        public void setFingers(int fingers) {
            this.fingers = fingers;
        }

        @Override
        public String toString() {
            return "Hand {" +
                    "fingers=" + fingers +
                    '}';
        }
    }
}