public class Chair extends Furniture {
    private int legs, maxWeight;
    private String seatMaterial;
    private boolean isRolling;

    public Chair() {
        legs = 5;
        maxWeight = 150;
        seatMaterial = "Leather";
        isRolling = true;
    }

    public Chair(int l, int maxW, String sm, boolean isR) {
        legs = l;
        maxWeight = maxW;
        seatMaterial = sm;
        isRolling = isR;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getSeatMaterial() {
        return seatMaterial;
    }

    public void setSeatMaterial(String seatMaterial) {
        this.seatMaterial = seatMaterial;
    }

    public boolean isRolling() {
        return isRolling;
    }

    public void setRolling(boolean rolling) {
        isRolling = rolling;
    }

    @Override
    public String toString() {
        return "Chair {" +
                "legs=" + legs +
                ", isRolling=" + isRolling +
                ", maxWeight=" + maxWeight +
                ", main material='" + material + '\'' +
                ", seat material='" + seatMaterial + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", weight=" + weight +
                '}';
    }
}
