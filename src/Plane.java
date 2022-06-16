public class Plane {

    private float fuelLevel;
    private String pilotCallSign;
    private String squadNumber;

    private boolean flaps = true;
    private boolean landingGear = false;
    private boolean ejectionSystem = false;

    private boolean seatOccupation = true;

    public Plane() {
    }

    public Plane(float fuelLevel, String pilotCallSign, String squadNumber) {
        this.fuelLevel = fuelLevel;
        this.pilotCallSign = pilotCallSign;
        this.squadNumber = squadNumber;

        // Completa el código para cumplir con los requisitos.
    }

    public void generateF18(float fuel, String pilotName, String squad) {

        Plane avion = new Plane(fuel, pilotName, squad);

        System.out.println(avion);
    }

    public void toggleFlaps() {
        flaps = !flaps;
        if (flaps) {
            System.out.println("Subiendo flaps...");
        } else {
            System.out.println("Bajando flaps...");
        }

    }

    public void toggleLandingGear() {
        landingGear = !landingGear;
        if (landingGear) {
            System.out.println("Subiendo tren de aterrizaje...");
        } else {
            System.out.println("Bajando tren de aterrizaje...");
        }
    }

    public void ejectionSystem() {
        ejectionSystem = !ejectionSystem;

        if (ejectionSystem) {
            System.out.println("Armado el sistema de eyección");
        } else {
            System.out.println("Desarmado el sistema de eyección");
        }
    }

    public void setSeatOccupation(boolean pilotSeated) {

        if (ejectionSystem) {
            seatOccupation = pilotSeated;
            System.out.println("El piloto ha saltado del avion");
        } else {
            System.out.println("El sistema no esta armado");
        }
    }

    public String getFlaps() {
        if (flaps) {
            return "Arriba";
        } else {
            return "Abajo";
        }
    }

    public String getLandingGear() {
        if (landingGear) {
            return "Arriba";
        } else {
            return "Abajo";
        }
    }

    public String getEjectionSystem() {
        if (ejectionSystem) {
            return "Armado";
        } else {
            return "Desarmado";
        }
    }

    public String getSeatOccupation() {
        if (seatOccupation) {
            return "Verdadero";
        } else {
            return "Falso";
        }
    }

    @Override
    public String toString() {
        return "\t- - - - Plane - - - -\n" +
                "\n\t flaps -> " + this.getFlaps() +
                "\n\t landingGear -> " + this.getLandingGear() +
                "\n\t ejectionSystem -> " + this.getEjectionSystem() +
                "\n\t seatOccupation -> " + this.getSeatOccupation();
    }
}
