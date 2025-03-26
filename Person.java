public abstract class Person {
    String name;
    String email;

    public Person(String name, String email){
        this.name=name;
        this.email=email;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
     public void displayDetails(){
        System.out.println("\nName: "+name);
        System.out.println("Email: "+email);
     }
}
