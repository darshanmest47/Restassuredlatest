package Basepackage;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


public class Baseclass {


    @BeforeAll
    @Test
    public static void baseTest(){

        baseURI = "http://localhost";
        basePath = "/stores";
        port = 3030;





    }
}
