package abstraction_interfaces.assigment_problems;

public class SkylineDeliveryFleet {

    static abstract class Drone {
        protected String id;

        public Drone(String id) {
            this.id = id;
        }

        public abstract String fly();
    }

    interface Trackable {
        String getLocation();
    }

    static class DeliveryDrone extends Drone implements Trackable {
        public DeliveryDrone(String id) {
            super(id);
        }

        @Override
        public String fly() {
            return id + " flying to deliver";
        }

        @Override
        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    static class ScoutDrone extends Drone {
        public ScoutDrone(String id) {
            super(id);
        }

        @Override
        public String fly() {
            return id + " scouting area";
        }
    }

    static class GroundRobot implements Trackable {
        private String id;

        public GroundRobot(String id) {
            this.id = id;
        }

        @Override
        public String getLocation() {
            return id + " at Sector 4";
        }
    }

    static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable t = (Trackable) o;
            return t.getLocation();
        }
        return "Tracking not available";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        System.out.println(getLocationIfTrackable(d));

        ScoutDrone s = new ScoutDrone("SC-1");
        System.out.println(getLocationIfTrackable(s));

        GroundRobot g = new GroundRobot("GR-1");
        System.out.println(getLocationIfTrackable(g));
    }
}
