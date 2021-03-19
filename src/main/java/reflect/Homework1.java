package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .map(Method::getName).sorted().forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .map(Method::getName).sorted().distinct()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(a -> a.getParameterCount()>= 2 && Arrays.stream(a.getParameterTypes())
                        .allMatch(param -> param == Arrays.stream(a.getParameterTypes()).findFirst().get()))
                .sorted(Comparator.comparing(a -> a.getName())).forEach(System.out::println);

    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .sorted(Comparator.comparing(b -> b.getReturnType().getName()))
                .map(b -> b.getReturnType().getName()).distinct()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(c -> Arrays.stream(c.getParameterTypes())
                        .anyMatch(param ->param == boolean.class))
                .sorted(Comparator.comparing(c ->c.getName()))
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(d -> Arrays.stream(d.getParameterTypes())
                        .allMatch(param -> param == int.class))
                .sorted(Comparator.comparing(d -> d.getName()))
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .map( e -> e.getName()).max(Comparator.comparingInt( e -> e.length())).get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .filter(f -> f.getModifiers() == Modifier.PUBLIC)
                .map(f -> f.getName())
                .max(Comparator.comparingInt(f -> f.length())).get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .mapToInt( g -> g.getParameterCount()).summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .mapToInt( h -> h.getParameterCount()).max().getAsInt();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(java.lang.String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(i -> i.getParameterCount())).get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(java.lang.String.class.getDeclaredMethods()).flatMap(j -> Arrays.stream(j.getParameterTypes())).distinct().sorted(Comparator.comparing(param -> param.getName())).forEach(System.out::println);
    }

}
