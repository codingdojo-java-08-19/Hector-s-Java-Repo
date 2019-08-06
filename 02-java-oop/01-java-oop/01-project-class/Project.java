public class Project {
    private String name;
    private String discription;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }

    public String elevatorPitch() {
        return String.format("Project name-%s : Discription-%s", name, discription);
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

}