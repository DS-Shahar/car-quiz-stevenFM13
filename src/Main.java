public class Main {
    public static void main(String[] args) {
        CarInfo[] cars1 = new CarInfo[2];
        cars1[0] = new CarInfo("c10", true, 90);
        cars1[1] = new CarInfo("c11", false, 120);

        CarInfo[] cars2 = new CarInfo[2];
        cars2[0] = new CarInfo("c20", false, 45);
        cars2[1] = new CarInfo("c21", false, 50);

        CameraInfo[] cameras = new CameraInfo[2];
        cameras[0] = new CameraInfo(12, 110, cars1);
        cameras[1] = new CameraInfo(12, 50, cars2);

        int good = legalCities(cameras,20);
        System.out.println("Legal cities count: " + good);
    }

    public static int legalCities(CameraInfo[] cameras, int MaxSpeed) {
        int count = 0;

        // Assuming that the city numbers are in the range of 0-99
        for (int city = 0; city < 100; city++) {
            boolean flag = false; // Start assuming there are no cameras in this city

            for (int j = 0; j < cameras.length; j++) {
                if (cameras[j].getCity() == city) {
                    if (!cameras[j].allGood(20)) { // If not all cars are good
                        flag = false; // Mark as illegal if any cars are bad
                    }
                    break; // No need to check more cameras for this city
                }
            }

            if (flag) {
                count++; // Increment count for legal cities only if there are cameras
            }
        }
        return count; // Return the count of legal cities
    }
}
