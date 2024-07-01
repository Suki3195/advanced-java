package concepts;

public class ImmutableClassDemo {

    public static void main(String[] args) {
        ImmutableClass imm = new ImmutableClass("Sukirti",55000,27,
                new ImmutableClass.Department("IT",001));

        System.out.println("--- " + imm);
        
    }

}
