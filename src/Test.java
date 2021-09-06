import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args){
        String s = "[ \n" +
                " { \n" +
                "  \"event_id\": 2, \n" +
                "  \"order_id\": 2, \n" +
                "  \"item_id\": 1, \n" +
                "  \"count\": 3, \n" +
                "  \"return_count\": 1, \n" +
                "  \"status\": \"OK\" \n" +
                " }, \n" +
                " { \n" +
                "  \"event_id\": 1, \n" +
                "  \"order_id\": 1, \n" +
                "  \"item_id\": 1, \n" +
                "  \"count\": 2, \n" +
                "  \"return_count\": 0, \n" +
                "  \"status\": \"OK\" \n" +
                " }, \n" +
                " { \n" +
                "  \"event_id\": 3, \n" +
                "  \"order_id\": 3, \n" +
                "  \"item_id\": 1, \n" +
                "  \"count\": 2, \n" +
                "  \"return_count\": 2, \n" +
                "  \"status\": \"OK\" \n" +
                " } \n" +
                "]";

        Object obj = JSONValue.parse(s);
        JSONArray array = (JSONArray)obj;
        //System.out.println(array);

        JSONArray sortedJsonArray = new JSONArray();

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        for (int i = 0; i < array.size(); i++) {
            jsonValues.add((JSONObject) array.get(i));
        }
        System.out.println(jsonValues);
        Collections.sort( jsonValues, new Comparator<JSONObject>() {

            @Override
            public int compare(JSONObject a, JSONObject b) {
                Integer valA = (Integer) a.get("order_id");
                Integer valB = (Integer) b.get("order_id");


                return valA - valB;
                //if you want to change the sort order, simply use the following:
                //return -valA.compareTo(valB);
            }
        });

        for (int i = 0; i < array.size(); i++) {
           // sortedJsonArray.put(jsonValues.get(i));
        }


    }
}
