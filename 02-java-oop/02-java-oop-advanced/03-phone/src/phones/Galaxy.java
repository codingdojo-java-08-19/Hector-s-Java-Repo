package phones;

public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "Galaxy"+versionNumber+" says "+ ringTone;
    }
    @Override
    public String unlock() {
        return "Galaxy"+versionNumber+" unlocked via fingerprint...the state is watching you";
    }
    @Override
    public void displayInfo() {
    	System.out.println("Galaxy"+versionNumber+" battery:" +String.format("%d", batteryPercentage)+" Carrier:"+carrier);
    }
}

