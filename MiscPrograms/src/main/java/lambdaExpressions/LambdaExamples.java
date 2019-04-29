package lambdaExpressions;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

@FunctionalInterface
interface test1 {

    public void running();

}

interface test2 {
    public void add(int a, int b);
}

public class LambdaExamples {

    public static void main(String args[]) {

        // without lambda expressions
        test1 withoutLambda = new test1() {

            @Override
            public void running() {
                System.out.println("working");

            }
        };

        // With lambda expressions
        test1 withLambda = () -> {
            System.out.println("working");
        };

        withLambda.running();
// ####################################################################################################3
        test2 beforeLambda = new test2() {

            @Override
            public void add(int a, int b) {

                System.out.println(a + b);
            }
        };

        test2 dd = (int a, int b) -> {
            System.out.println(a + b);
        };

        dd.add(10, 20);
//###############################################################################################33333
        Runnable run = () -> {
            System.out.println("running");
        };
        new Thread(run).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("running");

            }
        });

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        ArrayList<String> ss = new ArrayList<String>();
        ss.add("a");
        ss.add("accs");
        ss.add("asfas");

        
//        ss.stream().filter(a -> {
//            if (a.startsWith("a")) {
//                return true;
//            } else {
//                return false;
//            }
//        }).forEach(a -> System.out.println(a));
//
//         int s=20;
//       ss.stream().flatMap(a -> {
//           
//           ArrayList<Integer> ff = new ArrayList<>();
//            for(int i=0;i<a.length();i++) {
//                ff.add(i);
//            }
//            
//            System.out.println(s);
//            return ff.stream();
//        }).forEach(a-> System.out.println(a));
             
//       ss.stream().mapToInt(a -> {
//            return a.length();
//        }).forEach(e->System.out.println(e));
//    }
    
//    ss.stream().collect(Collectors.toMap(a->a, a->a.length())).forEach(;
        ss.stream().flatMap(a -> {
            ArrayList<Integer> ff = new ArrayList<>();
            for(int i=0;i<a.length();i++) {
                ff.add(i);
            }
            return ff.stream();
        }).forEach(a-> System.out.println(a));

    }
}
