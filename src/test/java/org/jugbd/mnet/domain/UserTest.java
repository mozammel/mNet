package org.jugbd.mnet.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class UserTest {
    private static Validator validator;

    @BeforeClass
    public static void setUp() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test_userShouldValid() {

        User user = new User("Bazlur", "Asdf#42D");

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        assertEquals(0, constraintViolations.size());
    }
}