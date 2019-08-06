public class ProjectTest {
    public static void main(String[] args) {
        Project project = new Project();
        Project project2 = new Project("project2");
        Project project3 = new Project("project3", "its good idea");

        System.out.println(project.elevatorPitch());
        System.out.println(project2.elevatorPitch());
        System.out.println(project3.elevatorPitch());
    }

}