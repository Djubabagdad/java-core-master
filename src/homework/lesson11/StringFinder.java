package homework.lesson11;

public class StringFinder {
    private static String a = "Object-oriented programming blabla";
    private static char str = (char) 34;
    private static char dot = (char) 46;
    private static String [] array = {"Object-oriented programming",
            " is a programming language model organized around objects rather than " + str + "actions" + str + " and data rather than logic" + dot +
            " Object-oriented programming blabla", ". Object-oriented programming bla."};
    public static void main(String[] args) {
        System.out.print(array[0]);
        printArray(array);
        System.out.print(array[2]);
    }
    private static void printArray(String ... array){
        for(int i = 0; i<array.length; i++ ){
                if(array[i].contains(a)){
                    StringBuilder arr = new StringBuilder(array[i]);
                    arr.delete(109,135);
                    arr.insert(109,"OP");
                    System.out.print(arr);
            }
        }
    }
}
