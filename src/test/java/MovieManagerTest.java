import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();

    @Test
    public void addZeroFilms() {

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneFilm() {

        manager.add("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addSomeFilms() {

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        String[] expected = {"Film 1", "Film 2", "Film 3"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsBelowLimit() {

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsEqualsLimit() {

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        String[] expected = {"Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsAfterAddZeroFilms() {
        MovieManager manager = new MovieManager(6);

        String[] expected = {};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsAfterAddOneFilm() {
        MovieManager manager = new MovieManager(6);

        manager.add("Film 1");

        String[] expected = {"Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsEqualsNewLimit() {
        MovieManager manager = new MovieManager(6);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsBelowNewLimit() {
        MovieManager manager = new MovieManager(7);

        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2", "Film 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }


}