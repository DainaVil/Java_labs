package Task7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        var text = "Скажи-ка, дядя, ведь недаром Москва, спаленная пожаром, Французу отдана? Ведь были ж схватки боевые, Да, говорят, еще какие! Недаром помнит вся Россия Про день Бородина! ";
        DictionaryMap(text);
    }

    public static void DictionaryMap(String text){
        text = text.toLowerCase();

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            if(c >= 'а' && c <= 'я'){
                map.compute(c, (character, integer) -> integer == null ? 1 : integer + 1);
            }
        }

        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o2, o1) -> Integer.compare(o1.getValue(), o2.getValue()));
        System.out.println("Буква / Частота");
        for(Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }
    }
}
