package com.example.concentration;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.*;

import java.io.BufferedReader;
import java.io.File;
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
    private File scoreFile;

    public ScoresJSONSerializer(Context c, String f){
        mContext = c;
        mFileName = f;
        scoreFile = mContext.getFilesDir();

            /* This logic will check whether the file
             * exists or not. If the file is not found
             * at the specified location it would create
             * a new file*/

    }

    public void saveScores(ArrayList<ScoreTracker> scores) throws JSONException, IOException {
        JSONArray array = new JSONArray();
        for (ScoreTracker s : scores){
            array.put(s.toJSON());
        }
        //write file to disk
        //TEST
        try{
            FileOutputStream writerTest = new FileOutputStream(new File(scoreFile, mFileName));
            writerTest.write(mFileName.getBytes());
            writerTest.close();
            System.out.println("Wrote to file");
        } catch (Exception e){
            e.printStackTrace();
        }

        //TEST END



        Writer writer = null;
        try{
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
            Log.d(TAG, "scores saved successfully");
        } finally {
            if (writer != null)
                writer.close();
        }

    }

    public ArrayList<ScoreTracker> loadScores() throws IOException, JSONException{
        ArrayList<ScoreTracker> scores = new ArrayList<ScoreTracker>();
        BufferedReader reader = null;
        try{
            //Open and read file into StringBuilder
            InputStream in = mContext.openFileInput(mFileName);
            reader = new BufferedReader(new InputStreamReader(in));

            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null){
                //line breaks omitted and irrelevant
                jsonString.append(line);
            }
            //Parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            //Build the array of scores from JSONObjects
            for (int i=0; i< array.length(); i++){
                scores.add(new ScoreTracker(array.getJSONObject(i)));
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
