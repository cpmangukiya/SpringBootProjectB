package org.example.problems.experiments;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.DoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MainClass{

    final String key = getKey();

    public MainClass() {
       // this.key = value;
    }

    //{this.key = "value";getKey();}

    public String getKey() {
        return key;
    }

    public static void mainStudent(String[] args) throws IOException {
        System.out.println("Holla");

        MySingletonClass mySingletonClass = MySingletonClass.getMySingletonObject();
        System.out.println(mySingletonClass.getA());
        mySingletonClass.setA(2);


        MySingletonClass mySingletonClass2 = MySingletonClass.getMySingletonObject();
        System.out.println(mySingletonClass2.getA());

        Student student1 = new Student();
        student1.setName("Monika");
        student1.setAge(25);

        Student student2 = new Student();
        student2.setName("Monika");
        student2.setAge(25);

        student2 = student1;

        String m1 = new String("Monika");
        String m2 = "Monika";
        // m1 == m2; // false
        // m1.equals(m2); //true

        System.out.println("Are both students same ?");
        System.out.println(student1.equals(student2));

        System.out.println();
        System.out.println("Comparable");
        // Comparable
        ArrayList arrayList = new ArrayList<Animal>();
        arrayList.add(new Animal("Dog",4));
        arrayList.add(new Animal("Bird", 2));
        arrayList.add(new Animal("Cow",4));
        arrayList.add(new Animal("Human", 2));

        Collections.sort(arrayList);

        Iterator iterator = arrayList.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        System.out.println();
        System.out.println("Comparator");
        // Comparator

        Collections.sort(arrayList, new MyAnimalComparator());

        iterator = arrayList.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        ArrayList<Students> obj = new ArrayList<Students>();
        obj.add(new Students(1,"Moni",25));
        obj.add(new Students(2,"Chintz",29));
        obj.add(new Students(3,"Mahi",24));
        obj.add(new Students(4,"Chintu",27));
        Collections.sort(obj);
        for(Students st:obj){
            System.out.println(st.rollNo+ " " + st.name + " " + st.age);
        }
        Comparator<Students> cm1= Comparator.comparing(Students::getName);
        Collections.sort(obj,cm1);
        System.out.println("Sorting by Name");
        for(Students st: obj){
            System.out.println(st.rollNo+" "+st.name+" "+st.age);
        }

        final Students students = new Students(1,"Moni",25);
        students.setAge(1);
    }

    public static void main222(String[] args) throws InterruptedException, ExecutionException {
        Thread t1 = new Thread(() -> {System.out.println("thread is running");});
        t1.start();
        t1.interrupt();
        Thread.interrupted();
        t1.isInterrupted();
        //wait();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> { System.out.println("print") ;});
        System.out.println(executorService.submit(() -> { return 3 * 2;}).get());
        executorService.execute(() -> { System.out.println("print") ;});

        System.out.println(new MainClass().getKey());
    }

    public static void mainFuture(String[] args) {
        FutureExecutors futureExecutors = new FutureExecutors();
        Future<Integer> integerFuture = futureExecutors.doSomething(10);
        integerFuture.isDone();
        try {
            integerFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        integerFuture.cancel(true);
        integerFuture.isCancelled();
    }

    public static void mainSpliterator(String[] args) throws IOException {

        new ArrayList<>(new ArrayList<>());
        Collections.emptyList();

        //Integer list splitter
        Spliterator<Integer> integerSpliterator1 = Arrays.asList(1, 4, 9, 1, 5 ,9).spliterator();
        Spliterator<Integer> integerSpliterator2 = integerSpliterator1.trySplit();
        Spliterator<Integer> integerSpliterator3 = integerSpliterator2.trySplit();

        new Thread(() -> new SpliteratorTask(integerSpliterator1).call()).start();
        new Thread(() -> new SpliteratorTask(integerSpliterator2).call()).start();
        new Thread(() -> new SpliteratorTask(integerSpliterator3).call()).start();

//        new SpliteratorTask(integerSpliterator1).call();
//        new SpliteratorTask(integerSpliterator2).call();
//        new SpliteratorTask(integerSpliterator3).call();

        System.out.println("integerSpliterator1: " + integerSpliterator1.estimateSize());
        System.out.println("integerSpliterator2: " + integerSpliterator2.estimateSize());
        System.out.println("integerSpliterator3: " + integerSpliterator3.estimateSize());

        //Bulk file reads and process
        Spliterator<Path> spliterator1 = Files.newDirectoryStream(Paths.get("C:\\Users\\chint\\Downloads\\PDFs")).spliterator();
        Spliterator<Path> spliterator2 = spliterator1.trySplit();
        Spliterator<Path> spliterator3 = spliterator2.trySplit();
        Spliterator<Path> spliterator4 = spliterator3.trySplit();

        StreamSupport.stream(spliterator1, false).parallel().forEach(path -> {System.out.println("spliterator1 " + path.toString());});
        StreamSupport.stream(spliterator2, false).parallel().forEach(path -> {System.out.println("spliterator2 " + path.toString());});
        StreamSupport.stream(spliterator3, false).parallel().forEach(path -> {System.out.println("spliterator3 " + path.toString());});
        StreamSupport.stream(spliterator4, false).parallel().forEach(path -> {System.out.println("spliterator4 " + path.toString());});

        System.out.println("spliterator1: " + spliterator1.estimateSize());
        System.out.println("spliterator2: " + spliterator2.estimateSize());
        System.out.println("spliterator3: " + spliterator3.estimateSize());
        System.out.println("spliterator4: " + spliterator4.estimateSize());
    }

    public static void main2(String[] args) {
        DoubleFunction<Object> doubleFunction = value -> new Object();
        DoubleFunction<Object> doubleFunction2 = value -> 1;

        List list = new ArrayList();

        List<String> result = Stream.of("a" , "b")
                .collect(Collectors.toCollection(LinkedList::new));

        Map map = new ConcurrentSkipListMap<String, String>();

        System.out.println(new ArrayList<>(Arrays.asList("b","a")).equals(new ArrayList<>(Arrays.asList("b","a"))));
        System.out.println(new ArrayList<>(Arrays.asList("b","a")).equals(new ArrayList<>(Arrays.asList("a","b"))));
        System.out.println(new HashSet<>(Arrays.asList("b","a")).equals(new HashSet<>(Arrays.asList("b","a"))));
        System.out.println(new HashSet<>(Arrays.asList("a","b")).equals(new HashSet<>(Arrays.asList("b","a"))));

        //Stream.of("a" , "b")
          //      .collect(Collectors.toCollection(() -> Collections.unmodifiableList(Arrays.asList("a"))));
            // Throws run time UnsupportedOperationException
    }

    public static void main(String[] args) {
        synchronized (MainClass.class) {

        }
        //synchronized (this) {        }
        synchronized (new MainClass()) {

        }
    }

    public void main3333(String[] args) {
        synchronized (MainClass.class) {

        }
        synchronized (this) {

        }
        synchronized (new MainClass()) {

        }
    }

}

