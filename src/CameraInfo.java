public class CameraInfo {
    private int city;
    private int maxSpeed;
    private CarInfo[] cars;    
    
    public CameraInfo(int city, int maxSpeed, CarInfo[] cars) {
        this.city = city;
        this.maxSpeed = maxSpeed;
        this.cars = cars;
    }
    
    public int getCity() {
        return city;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }    
    
    public boolean allGood(int maxSpeed) {
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i].illegal(maxSpeed)) { // Assuming illegal returns a boolean
                return false; // Return false if any car is illegal
            }
        }
        return true; // All cars are good
    }
}
