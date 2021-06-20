package com.ecommerce.tests;
 
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
 
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import static org.junit.jupiter.api.Assertions.*;
 
@DisplayName("JUnit 5 Dynamic Tests Example")
@RunWith(JUnitPlatform.class)
public class DynamicTests {
 
        @TestFactory
    Collection<DynamicTest> dynamicTests() {
        return Arrays.asList(
			DynamicTest.dynamicTest("simple dynamic test", () -> assertTrue(true)),
			DynamicTest.dynamicTest("My Executable Class", new MyExecutable()),
			DynamicTest.dynamicTest("Exception Executable", () -> {throw new Exception("Exception Example");}),
			DynamicTest.dynamicTest("simple dynamic test-2", () -> assertTrue(true))
        );
    }
 
}
 
 
class MyExecutable implements Executable {
 
        @Override
        public void execute() throws Throwable {
                System.out.println("Hello World!");
        }
 
}