package db;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import dto.InputParamsDTO;

public class DBHelper {

    private static final String DB_ROOT = "https://test-d0d12-default-rtdb.firebaseio.com/";
    private static final String INDEX = "index";
    private static final String HISTORY_TABLE = "entries";
    private static final String META_TABLE = "metadata";
    private static final Logger logger = LogManager.getLogger(DBHelper.class);


/*
    public static void main(String[] args) throws IOException {
        DBHelper dbHelper = new DBHelper();
        System.out.println(dbHelper.getIndex());
        String response = dbHelper.readData("", HISTORY_TABLE).getRawBody();
        int mapStart = response.indexOf("{");
        response = response.substring(mapStart, response.length() -1);
        System.out.println(response);
        String [] map = response.split("\\},\\{");
        System.out.println();
    }

    public FirebaseResponse readData(String column, String table) {
        FirebaseResponse firebaseResponse = null;
        column = column == null ? "" : "/" + column;
        try {
            Firebase firebase = getFireBase(DB_ROOT + table + column);
            firebaseResponse = firebase.get();
        } catch (FirebaseException | UnsupportedEncodingException e) {
            logger.error("Database read error");
        } catch (NullPointerException ex) {
            logger.error("Couldnt get firebase");
        }
        return firebaseResponse;
    }

    private String getIndex() {
        FirebaseResponse firebaseResponse = readData(INDEX, META_TABLE);
        if(firebaseResponse != null) {
            return firebaseResponse.getRawBody();
        }
        return "-1";
    }

    public void writeData(InputParamsDTO inputParamsDTO) throws ExecutionException, InterruptedException {

        Firestore db = null;
        // Create a Map to store the data we want to set
        Map<String, Object> docData = new HashMap<>();
        docData.put("name", "Los Angeles");
        docData.put("state", "CA");
        docData.put("country", "USA");
        docData.put("regions", Arrays.asList("west_coast", "socal"));
// Add a new document (asynchronously) in collection "cities" with id "LA"
        ApiFuture<WriteResult> future = db.collection("cities").document("LA").set(docData);
// ...
// future.get() blocks on response
        System.out.println("Update time : " + future.get().getUpdateTime());


        String index = getIndex();
        writeData(index, inputParamsDTO, HISTORY_TABLE);
        updateIndex(index);
    }

    private void updateIndex(String index) {
        int newIndex = Integer.parseInt(index) + 1;
        writeData(INDEX, newIndex, META_TABLE);
    }

    public void writeData(String key, Object value, String table) {
        Firebase firebase = getFireBase(DB_ROOT + table);
        Map<String, Object> dataMap = new HashMap<>();//null;// getTable(HISTORY_TABLE);
        dataMap.put(key, value);
        try {
            FirebaseResponse response = firebase.put(dataMap);
        } catch (JacksonUtilityException | FirebaseException | UnsupportedEncodingException e) {
            logger.error("Database write error");
        } catch (NullPointerException ex) {
            logger.error("Couldn't get firebase");
        }
    }


    private Firebase getFireBase(String url) {
        try {
            return new Firebase(url);
        } catch (FirebaseException e) {
            logger.error("Database connection error");
        }
        return null;
    }*/

}
