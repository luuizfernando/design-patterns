package behavioral.command;

/**
 * Role: Receiver
 *
 * Knows how to perform temperature changes.
 * Has no knowledge of the Command Pattern
 */
public class Thermostat {
    private Double temperatureCelsius;

    public Thermostat(Double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public Double getTemperatureCelsius() {
        return this.temperatureCelsius;
    }

    public void setTemperatureCelsius(Double temperatureCelsius) {
        System.out.println(
                "[Device] Thermostat: " + this.temperatureCelsius + " C -> " + temperatureCelsius + "C"
        );
        this.temperatureCelsius = temperatureCelsius;
    }
}