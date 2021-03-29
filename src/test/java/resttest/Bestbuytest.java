package resttest;

import Basepackage.Baseclass;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Bestbuytest extends Baseclass {

    @DisplayName("get method of rest api")
    @Test
    public void getMethod(){

        given()
                .when()
                .get().then().log().body();

    }


    @DisplayName("find method")
    @Test
    public void findMethod(){
        ValidatableResponse resp = given().when().get("http://localhost:3030/stores").then();

         /* To get a single daya based on index */
     //   String name = resp.extract().path("data[0].name");

      //  System.out.println(name);


        /* get data with find method */

        Map<String,?> data = resp.extract().path("data.find{it.name=='Burnsville'}");
       System.out.println(data.toString());

        /* To get data with find from inner json */




    }


    @DisplayName("get data with findAll() from inner json")
    @Test
    public void getFromInner(){
        ValidatableResponse resp = given().when().get().then();

    List<Map<String,?>> data =  resp.extract().path("data.findAll{it.state == 'MN' && it.zip == '55113'}");
            System.out.println(data);
    for(Map<String,?>d1:data){
        System.out.println(d1);
    }


    }


    @DisplayName("data from max id")
    @Test
    public void getDataMax(){

        ValidatableResponse resp = given().when().get().then();
         Map<String,?> dataMax =  resp.extract().path("data.max{it.id}");
         System.out.println(dataMax);
    }


    @DisplayName("data from min id")
    @Test
    public void getMinData(){
        ValidatableResponse resp = given().when().get().then();
        Map<String,?> dataMax =  resp.extract().path("data.min{it.id}");
        System.out.println(dataMax);
    }


}
