package com.example.concentration;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class ScoresJSONSerializer {

    private Context mContext;
    private String mFileName;

    public ScoresJSONSerializer(Context c, String f){
        mContext = c;
        mFileName = f;

    }

    public void saveScores(ArrayList<ArrayList<ScoreTracker>> scores) throws JSONException, IOException {
        ArrayList<JSONArray> jsonArrays = new ArrayList<>();
        for(int i=0; i<scores.size(); i++) {
            JSONArray array = new JSONArray();
            for (ScoreTracker s : scores.get(i)) {
                array.put(s.toJSON());
            }
            jsonArrays.add(array);
        }
        //write file to disk

        Writer writer = null;
        try {
            FileOutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            for(int i=0; i<jsonArrays.size(); i++) {
                writer.write(jsonArrays.get(i).toString() + "\n");
            }
        } finally {
            if(writer != null)
                writer.close();
        }
        }


    public ArrayList<ArrayList<ScoreTracker>> loadScores() throws IOException, JSONException{
        ArrayList<ArrayList<ScoreTracker>> scores = new ArrayList<ArrayList<ScoreTracker>>();
        BufferedReader reader = null;
        try{
            //Open and read file into StringBuilder
            FileInputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));


            String line = null;
            while ((line = reader.readLine()) != null) {
                //line breaks omitted and irrelevant
                StringBuilder jsonString = new StringBuilder();
                jsonString.append(line);

                //Parse the JSON using JSONTokener
                JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
                //Build the array of scores from JSONObjects
                ArrayList<ScoreTracker> nextScores = new ArrayList<>();
                for (int i = 0; i < array.length(); i++) {
                    nextScores.add(new ScoreTracker(array.getJSONObject(i)));
                }
                scores.add(nextScores);

            }
        } catch (FileNotFoundException e){
            //Ignored, only happens when starting fresh
        } finally {
            if (reader != null)
                reader.close();
        }
        return scores;
    }

}
