import Exceptions.ElementDoesntExistException;
import Exceptions.IndexIsOutOfBoundsException;
import Exceptions.IndexIsTakenException;
import Exceptions.StringListIsFullException;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import service.StringListImpl;

import java.util.Arrays;


public class StringListImplTest {
        private final StringListImpl out = new StringListImpl(4);

    private final String[] array = {
            "one", "two", "three",
            "four", "five",
            "six", "seven", "eight",
            "nine","ten"
    };



        @Test
        public void shouldAddAString() {
            String expected = array[1];
            String actual = out.add("two");

            Assertions.assertEquals(expected, actual);

            int sizeExpected = 1;
            int actualSize = out.size();
            Assertions.assertEquals(sizeExpected, actualSize);

            String expected2 = array[1];
            String actual2 = out.add(1, "two");

            Assertions.assertEquals(expected2, actual2);
        }

        @Test
        public void shouldCorrectlySetElement() {
            out.add(array[0]);

            String expected = array[1];
            String actualSet = out.set(0, array[1]);

            Assertions.assertEquals(expected, actualSet);
        }

    @Test
    public void shouldCorrectlyRemoveElement() {
        out.add(array[8]);
        out.add(array[9]);

        String expected = array[8];

        String actualRemoveString = out.remove(array[8]);
        Assertions.assertEquals(expected, actualRemoveString);

        int sizeExpected = 1;
        int actualSize = out.size();
        Assertions.assertEquals(sizeExpected, actualSize);


        String expectedIndex = array[9];
        String actualRemovedByIndex = out.remove(0);
        Assertions.assertEquals(expectedIndex, actualRemovedByIndex);

    }


        @Test
        public void shouldShowIfContains() {
            boolean expected = true;
            out.add(array[0]);
            out.add(array[2]);
            boolean actual = out.contains("one");

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldCorrectlyReturnIndexOfElement() {
            out.add(array[0]);
            int expectedIfContains = 0;
            int expectedIfDoesntContain = -1;

            int actualContains = out.indexOf(array[0]);
            int actualDoesntContain = out.indexOf(array[1]);

            Assertions.assertEquals(expectedIfContains, actualContains);
            Assertions.assertEquals(expectedIfDoesntContain, actualDoesntContain);
        }

        @Test
        public void shouldCorrectlyReturnLastIndexOfElement() {
            out.add(array[0]);
            out.add(array[3]);
            out.add(array[4]);


            int expectedIfContains = 2;
            int expectedIfDoesntContain = -1;

            int actualContains = out.lastIndexOf(array[4]);
            int actualDoesntContain = out.lastIndexOf(array[1]);

            Assertions.assertEquals(expectedIfContains, actualContains);
            Assertions.assertEquals(expectedIfDoesntContain, actualDoesntContain);
        }

        @Test
        public void shouldCorrectlyGetElement() {
            out.add(array[0]);
            out.add(array[3]);

            String expected = array[3];
            String actual = out.get(1);

            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldCorrectlyCompare() {
            out.add(array[0]);
            out.add(array[2]);

            StringListImpl test = new StringListImpl(4);
            test.add(array[0]);
            test.add(array[2]);

            boolean expected = true;
            boolean actual = out.equals(test);

            Assertions.assertEquals(expected, actual);
            test.add(array[5]);

            boolean expectedNotEqual = false;
            boolean actualNotEqual = out.equals(test);

            Assertions.assertEquals(expectedNotEqual, actualNotEqual);
        }

        @Test
        public void shouldReturnActualSize() {
            out.add(array[0]);
            out.add(array[3]);

            int expected = 2;
            int actual = out.size();
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldCheckIfEmpty() {
            boolean expectedIfEmpty = true;
            boolean actualIfEmpty = out.isEmpty();

            Assertions.assertEquals(expectedIfEmpty, actualIfEmpty);

            out.add(array[9]);

            boolean expectedIfNotEmpty = false;
            boolean actualIfNotEmpty = out.isEmpty();

            Assertions.assertEquals(expectedIfNotEmpty, actualIfNotEmpty);
        }
        @Test
        public void shouldCorrectlyClear() {
            out.add(array[0]);
            out.add(array[3]);

            out.clear();
            boolean expectedIfEmpty = true;
            boolean actualIfEmpty = out.isEmpty();
            Assertions.assertEquals(expectedIfEmpty, actualIfEmpty);
        }

        @Test
        public void shouldReturnArray(){
            out.add(array[0]);
            out.add(array[2]);
            String [] expected = new String[]{array[0], array[2], null, null};
            String[] actual = out.toArray();
            Assertions.assertTrue(Arrays.equals(expected, actual));

        }

        @Test
        public void shouldThrowEDEEWhenItemIsNotFound() {
            out.add(array[3]);


            Assertions.assertThrows(ElementDoesntExistException.class, () -> out.remove("colder"));
            out.remove(0);
            Assertions.assertThrows(ElementDoesntExistException.class, () -> out.clear());

        }

        @Test
        public void shouldThrowIAEWhenStringIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.add(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.add(0, null));

            out.add(0, array[3]);
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.set(0, null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.remove(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.contains(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.indexOf(null));
            Assertions.assertThrows(IllegalArgumentException.class, () -> out.lastIndexOf(null));

        }

        @Test
        public void shouldThrowIOOBIfOutOfRange() {
            int wrongIndex = -1;

            Assertions.assertThrows(IndexIsOutOfBoundsException.class, () -> out.set(wrongIndex, array[0]));

            out.add(array[3]);
            out.add(array[4]);
            int indexOutOfActualSize = 3;
            Assertions.assertThrows(IndexIsOutOfBoundsException.class, () -> out.add(indexOutOfActualSize, array[2]));
            Assertions.assertThrows(IndexIsOutOfBoundsException.class, () -> out.remove(indexOutOfActualSize));
            Assertions.assertThrows(IndexIsOutOfBoundsException.class, () -> out.remove(wrongIndex));
            Assertions.assertThrows(IndexIsOutOfBoundsException.class, () -> out.get(indexOutOfActualSize));
            Assertions.assertThrows(IndexIsOutOfBoundsException.class, () -> out.get(wrongIndex));

        }

        @Test
        public void shouldThrowIITEIfIndexIsTaken() {
            out.add(0, array[3]);
            Assertions.assertThrows(IndexIsTakenException.class, () -> out.add(0, array[1]));
        }



    }


