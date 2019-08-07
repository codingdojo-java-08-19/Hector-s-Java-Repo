package phones;

public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return "iPhone"+versionNumber+" says "+ ringTone;
    }
    @Override
    public String unlock() {
        return "iPhone"+versionNumber+" unlocked via your face";
    }
    @Override
    public void displayInfo() {
    	System.out.println("iPhone"+versionNumber+" battery:" +String.format("%d", batteryPercentage)+" Carrier:"+carrier);
    }
}

