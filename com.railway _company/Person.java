public class Person {
    private int id;
    private long nationalId;
    private String name;
    private int age;
    //constructor using id
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    //constructor using national id
    public Person(String name, int age, long nationalId) {
        this.nationalId = nationalId;
        this.name = name;
        this.age = age;
    }
    
    // other attrubites
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public long getNationalId() {
        return nationalId;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
