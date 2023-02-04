package Trump;

import java.util.*;

public class Test {
    public static void main(String[] arg) throws Exception {
        int sizea = 123123;
        int size = String.valueOf(sizea).length();
        String ID = String.valueOf(1111);
        int spaceI = size-ID.length();
        String spaceO = String.format("%"+spaceI+"s","");
        System.out.println("ID: " + spaceO + ID +" ");

    }
}
class TestClass{
    String a;
    int b;
    TestClass(String z, int x){a=z; b=x;}
}


