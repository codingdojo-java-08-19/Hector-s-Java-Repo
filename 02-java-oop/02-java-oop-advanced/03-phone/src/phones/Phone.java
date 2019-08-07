package phones;

public abstract class Phone {
	//had to change these to protected?
    protected String versionNumber;
    protected int batteryPercentage;
    protected String carrier;
    protected String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // abstract met for children
    public abstract void displayInfo();
}
