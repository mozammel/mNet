package org.jugbd.mnet.utils;

import org.jugbd.mnet.domain.Investigation;

import java.lang.reflect.Field;

/**
 * @author Bazlur Rahman Rokon
 * @date 12/27/14.
 */
public class Test {
    public static void main(String[] args) {
        Field[] fields = Investigation.class.getDeclaredFields();

        int count = 1;
        for (Field field : fields) {

            System.out.println("<tr>" +
                    "<td>" +
                    "" + field.getName() +
                    "</td>" +
                    "" +
                    "<td th:text=\"${investigation." + field.getName() + "}? ${investigation." + field.getName() + "}\">" +
                    "</td>" +
                    "</tr>");
            count++;

        }
        System.out.println(count);
    }
}
