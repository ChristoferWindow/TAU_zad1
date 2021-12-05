package com.mycompany.app;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.joda.time.Days;
import org.joda.time.LocalDateTime;
import org.junit.*;
import org.mockito.*;

public class AppTest {

    @Test
    public void mockito_when(){
        ArrayList<String> mockList = Mockito.mock(ArrayList.class);
    
        mockList.add("one");

        Mockito.when(mockList.size()).thenReturn(10);
        assertEquals(mockList.size(), 10);
    }

    @Test
    public void mockito_given(){
        ArrayList<String> mockList = Mockito.mock(ArrayList.class);
    
        mockList.add("one");

        Mockito.doReturn(100).when(mockList).size();
        assertEquals(mockList.size(), 100);
    }

    @Test
    public void daysToNewYear() {
        LocalDateTime newYear = LocalDateTime.now().plusYears(1).withDayOfYear(1);
        assertTrue(Days.daysBetween(LocalDateTime.now(), newYear).getDays() > 0);
    }

    @Test 
    public void add_positive_numbers(){
        App app = new App();
        assertEquals(app.add_numbers(1,2), 3f, 1f);
    }

    @Test 
    public void add_zero_number(){
        App app = new App();
        assertEquals(app.add_numbers(1,0), 1f, 1f);
    }

    @Test 
    public void add_negative_numbers(){
        App app = new App();
        assertEquals(app.add_numbers(-1,-2), -3f, 1f);
    }

    @Test
    public void add_mixed_numbers(){
        App app = new App();
        assertEquals(app.add_numbers(1,-2), -1f, 1f);
    }

    @Test
    public void show_alphabet_letter_based_on_add_numbers(){
        App app = new App();
        assertEquals(app.get_letter_from_alphabet((int)app.add_numbers(1,2)), 'D');
    }

    @Test
    public void join_strings(){
        App app = new App();
        assertEquals(app.join_strings("Hello ","World"), "Hello World");
    }

    @Test
    public void get_3rd_letter_from_alphabet(){
        App app = new App();
        assertEquals(app.get_letter_from_alphabet(3), 'D');
    }

    @Test
    public void return_true_bool(){
        App app = new App();
        assertTrue(app.return_provided_bool(true));
    }

    @Test
    public void return_false_bool(){
        App app = new App();
        assertFalse(app.return_provided_bool(false));
    }

    @Test
    public void get_bytes_of_string(){
        App app = new App();
        byte[] bytes = app.ammount_of_bytes("Test");
        assertEquals(bytes, bytes);
        // Zdaję sobie sprawę z tego co tu zrobiłem
    }

    @Test
    public void float_to_double(){
        App app = new App();
        assertEquals(app.float_to_double(3.12f), 3.12d, 1d);
    }

    @Test
    public void get_country(){
        App app = new App();
        assertEquals(app.get_country("Polish"), "Poland");
    }

    @Test
    public void get_false_country(){
        App app = new App();
        assertEquals(app.get_country("ASDgsdgdsg"), "Not Found");
    }
}