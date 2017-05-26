package com.jets.mad.itischeduleapp.datalayer.Caching.Files;

import android.content.Context;

import com.jets.mad.itischeduleapp.AppController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalFile {

    private final String FILE_NAME ="com.jets.mad.itischeduleapp";

    public void saveIntoFile(String data){
        try {

            FileOutputStream fos = AppController.getInstance().openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(data.getBytes());
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readFromFile(){

        String data = null;

        try {

            FileInputStream fis = AppController.getInstance().openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
