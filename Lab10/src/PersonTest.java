public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Nikita");
        person.setPatronymic("Sergeevich");
        person.setSurname("Semyannikov");
        System.out.println(person.getFIO());
        person.setName("");
        System.out.println(person.getFIO());
        person.setPatronymic("");
        System.out.println(person.getFIO());
    }
}