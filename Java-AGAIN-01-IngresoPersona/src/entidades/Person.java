package entidades;

public class Person {
    // private int id;
    private String name;
    private String lastName;
    private char genre;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String role;
    private String ic;

    // public Person(int id, String name, String lastName, char genre, int age,
    // String address, String phone, String email,
    // String password, String role, String ic) {
    // this.name = name;
    // this.lastName = lastName;
    // this.genre = Character.toUpperCase(genre);
    // this.age = age;
    // this.address = address;
    // this.phone = phone;
    // this.email = email;
    // this.password = password;
    // this.role = role;
    // this.ic = ic;
    // }
    public Person(String name, String lastName, char genre, int age, String address, String phone, String email,
            String password, String role, String ic) {
        this.name = name;
        this.lastName = lastName;
        this.genre = Character.toUpperCase(genre);
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.ic = ic;
    }

    // public int getId() {
    // return id;
    // }

    // public void setId(int id) {
    // this.id = id;
    // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    // @Override
    // public String toString() {
    // return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ",
    // genre=" + genre + ", age=" + age
    // + ", address=" + address + ", phone=" + phone + ", email=" + email + ",
    // password=" + password
    // + ", role=" + role + ", ic=" + ic + "]";
    // }
    @Override
    public String toString() {
        return "Person [name=" + name + ", lastName=" + lastName + ", genre=" + genre + ", age=" + age
                + ", address=" + address + ", phone=" + phone + ", email=" + email + ", password=" + password
                + ", role=" + role + ", ic=" + ic + "]";
    }

}
