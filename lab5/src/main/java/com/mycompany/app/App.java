package com.mycompany.app;

import java.util.*;

public class App {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Map<String, String> language = new HashMap<String, String>() {{
        put("Polish", "Poland");
        put("German", "Germany");
    }};

    float add_numbers(float number1, float number2){
        return number1 + number2;
    }

    String join_strings(String string1, String string2){
        return string1 + string2;
    }

    char get_letter_from_alphabet(int number){
        return alphabet.charAt(number);
    }

    boolean return_provided_bool(boolean bool){
        return bool;
    }

    byte[] ammount_of_bytes(String string){
        return string.getBytes();
    }

    double float_to_double(float float_number){
        return (double)float_number;
    }

    String get_country(String find){
        String to_return = "Not Found";

        if(language.containsKey(find)){
            to_return = language.get(find);
        }

        return to_return;
    }
}