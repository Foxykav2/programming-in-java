package agh.ii.prinjava.proj2;


import java.util.*;
import java.util.stream.Collectors;
import agh.ii.prinjava.proj2.model.Movie;
import agh.ii.prinjava.proj2.utils.Utils;
import agh.ii.prinjava.proj2.dal.ImdbTop250;


import static agh.ii.prinjava.proj2.dal.ImdbTop250.movies;

interface PlayWithMovies {

    /**
     * Returns the movies (only titles) directed (or co-directed) by a given director
     */
    static Set<String> ex01(String director) {
        return movies()
                .map(movies -> movies.stream()
                .filter(movie ->  movie.directors().contains(director))
                        .map(Movie::title)
                        .collect(Collectors.toSet()))
                        .orElse(Set.of());

    }

    /**
     * Returns the movies (only titles) in which an actor played
     */
    static Set<String> ex02(String actor) {

        return movies()
                .map(movies -> movies.stream()
                .filter(movie -> movie.actors().contains(actor))
                        .map(Movie::title)
                        .collect(Collectors.toSet()))
                .orElse(Set.of());
    }

    /**
     * Returns the number of movies per director (as a map)
     */
    static Map<String, Long> ex03() {
        List<Movie> movies= ImdbTop250.movies().orElseThrow();
        return movies.stream()
                .flatMap(movie -> movie.directors().stream())
                        .collect(Collectors.groupingBy(director->director,Collectors.counting()));



    }

    /**
     * Returns the 10 directors with the most films on the list
     */
    static Map<String, Long> ex04() {
        Map <String, Long> directormap= ex03();

        return directormap
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) made by each of the 10 directors found in {@link PlayWithMovies#ex04 ex04}
     */
    static Map<String, Set<String>> ex05() {
        Set<String> listDirectors = ex04().keySet();
        List<Movie> movies = ImdbTop250.movies().orElseThrow();

        return movies.stream().flatMap(movie -> Utils.oneToManyByDirector(movie).stream())
                .map(movie -> {
                    if(listDirectors.contains(movie.directors().get(0))) {
                        List<String> titleAndDirector = new ArrayList<String>();
                        titleAndDirector.add(movie.title());
                        titleAndDirector.add(movie.directors().get(0));
                        return titleAndDirector;
                    }
                    else{
                        return new ArrayList<String>();
                    }
                })
                .filter(movie -> !movie.isEmpty())
                .collect(Collectors.groupingBy(titleAndDirector -> titleAndDirector.get(1),
                        Collectors.mapping(titleAndDirector -> titleAndDirector.get(0), Collectors.toSet())
                ));
    }

    /**
     * Returns the number of movies per actor (as a map)
     */
    static Map<String, Long> ex06() {
        List<Movie> movies = ImdbTop250.movies().orElseThrow();

        return movies.stream()
                .flatMap(movie -> movie.actors().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()));
    }
    /**
     * Returns the 9 actors with the most films on the list
     */
    static Map<String, Long> ex07() {

        List<Movie> movies = ImdbTop250.movies().orElseThrow();

        return movies.stream()
                .flatMap(movie -> movie.actors().stream())
                .collect(Collectors.groupingBy(actor -> actor, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(9)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) of each of the 9 actors from {@link PlayWithMovies#ex07 ex07}
     */
    static Map<String, Set<String>> ex08() {

        List<Movie> movies = ImdbTop250.movies().orElseThrow();

        Map<String, Set<String>> moviesByActor = ex07().keySet().stream()

                .collect(Collectors.toMap(
                        actor -> actor,
                        actor -> movies.stream()
                                .filter(movie -> movie.actors().contains(actor))
                                .map(Movie::title)
                                .collect(Collectors.toSet())
                ));

        return moviesByActor;

    }

    /**
     * Returns the 5 most frequent actor partnerships (i.e., appearing together most often)
     */
    static Map<String, Long> ex09() {
        List<Movie> movies = ImdbTop250.movies().orElseThrow();

        Map<String, Long> partnerships = movies.stream()
                .map(Movie::actors)
                .flatMap(actors -> Utils.orderedPairsFrom(actors).stream())
                .collect(Collectors.groupingBy(pair -> pair, Collectors.counting()));

        return partnerships.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Returns the movies (only titles) of each of the 5 most frequent actor partnerships
     */
    static Map<String, Set<String>> ex10() {

        List<Movie> movies = ImdbTop250.movies().orElseThrow();

        Map<String, Set<String>> moviesByPairDuo = ex09().keySet().stream()
                .collect(Collectors.toMap(
                        actor -> actor,

                        actor -> movies.stream()
                                .filter(movie -> Utils.oneToManyByActorDuo(movie).contains(actor))
                                .map(Movie::title)
                                .collect(Collectors.toSet())
                ));
        return moviesByPairDuo;
    }

}

