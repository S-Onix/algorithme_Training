package src.programmers;

import java.util.Arrays;

public class Lv2PhoneBook {
    public boolean solution(String[] phone_book) {
        // 여기에 코드를 작성하세요
       Arrays.sort(phone_book);

       for(int i = 0 ; i < phone_book.length-1 ; i++) {
           if(phone_book[i+1].startsWith(phone_book[i])) {
               return false;
           }
       }
        return true;
    }
}
