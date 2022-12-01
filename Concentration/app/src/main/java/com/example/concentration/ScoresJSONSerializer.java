package com.example.concentration;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.*;

import java.io.IOException;
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

    public void saveNames(ArrayList<String> names, ArrayList<String> scores) throws JSONException, IOException {
        JSONArray nameArray = new JSONArray();
        JSONArray scoreArray = new JSONArray();
        for (int i=0; i<scores.size(); i++){
            nameArray.put(names.get(i));
            scoreArray.put(scores.get(i));
        }
        //write file to disk

        Writer writer = null;
        try{
            OutputStream out = mContext.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(nameArray.toString());
            writer.write(scoreArray.toString());
        } finally {
            if (writer != null)
                writer.close();
        }

    }

}
