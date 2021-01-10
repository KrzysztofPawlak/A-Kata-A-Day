package kyu7;

// Mumbling

// This time no story, no theory. The examples below show you how to write function accum:
// accum("abcd") -> "A-Bb-Ccc-Dddd"
// accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
// accum("cwAt") -> "C-Ww-Aaa-Tttt"

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Accumul {

    public static String accum(String s) {
        return IntStream.range(1, s.length() + 1)
                .mapToObj(num -> (String.valueOf(s.charAt(num - 1)).repeat(num)))
                .map(r -> Character.toUpperCase(r.charAt(0)) + r.substring(1).toLowerCase())
                .collect(Collectors.joining("-"));
    }

    public static void main(String[] args) {
        System.out.println(Accumul.accum("ZpglnRxqenU"));
        System.out.println(Accumul.accum("NyffsGeyylB"));
        System.out.println(Accumul.accum("MjtkuBovqrU"));
        System.out.println(Accumul.accum("EvidjUnokmM"));
        System.out.println(Accumul.accum("HbideVbxncC"));
    }
}
