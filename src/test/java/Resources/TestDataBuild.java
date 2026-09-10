package Resources;

import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;

import java.util.ArrayList;

public class TestDataBuild {

    public AddPlace addPlacePayLoad(String name, String language,String address){

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        AddPlace p = new AddPlace();
        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        p.setLocation(l);
        p.setAccuracy(50);
        p.setName(name);
        p.setPhone_number("(+91) 983 893 3937");
        p.setAddress(address);
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        p.setTypes(myList);
        p.setWebsite("http://google.com");
        p.setLanguage(language);
        return p;
    }
    public String deletePlacePayload(String place_id) {

        return "{\n" +
                "    \"place_id\": \"" + place_id + "\"\n" +
                "}";
    }

}
