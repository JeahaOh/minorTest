package bitcamp.java110.cms.control;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class Hell{
    @RequestMapping("hell")
    public void hello(Scanner keyIn) {
        System.out.println("\nWhat the Hell..");
    }
}
