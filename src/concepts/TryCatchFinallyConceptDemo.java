package concepts;

public class TryCatchFinallyConceptDemo {


    public static void main(String[] args) throws Exception {
        System.out.println(getName());
    }

    public static String getName() throws Exception{
        String name;
        try{
           int a = 12/0;
           name= "Exception";
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        finally {
            return "Sukirti";
        }

    }
}
