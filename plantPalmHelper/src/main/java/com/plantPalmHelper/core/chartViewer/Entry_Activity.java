package com.github.barteksc.sample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import SQLite_Adapter.DatabaseHandler;
import SQLite_Adapter.Zd;
import View_Adapter.ViewAdapterActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Entry_Activity extends AppCompatActivity {
    public static DatabaseHandler db;
    private VideoView video;
    private MyAsyncTask task;
    private Uri path;
    private HashMap<Integer, String[]> json_sql_converter = new HashMap<Integer, String[]>();
    private String[] val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_layout);
        db = new DatabaseHandler(this);
        video = (VideoView) findViewById(R.id.video_view);
        path = Uri.parse ("android.resource://com.github.barteksc.sample/raw/video");
        getSupportActionBar().hide();
        video.setVideoURI(path);
        Toast.makeText(getApplicationContext(), "Activity started", Toast.LENGTH_SHORT).show();
        video.start();
        task = new MyAsyncTask();
        task.execute();
        String text = "Some exception occur";
        try {
            text = task.get();
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
        }
        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Intent intent = new Intent(Entry_Activity.this, ViewAdapterActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
       finish();
    super.onPause();
}

    class MyAsyncTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... voids) {
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                        Toast.makeText(getApplicationContext(), "get response body", Toast.LENGTH_SHORT).show();
                        List<Post> posts = response.body();
                        for (Post post : posts) {
                            String[] row = {post.getZd_name(),
                                            post.getZd_location(),
                                            post.getZd_blok_number(),
                                            post.getSa_name(),
                                            post.getUso_name(),
                                            post.getCI_number(),
                                            post.getZd_hod(),
                                            post.getZd_modbus_speed(),
                                            post.getZd_modbus_number(),
                                            post.getZd_modbus_setting(),
                                            post.getZd_max_torque(),
                                            post.getZd_torque_for_close(),
                                            post.getZd_torque_for_start_open(),
                                            post.getZd_torque_for_open(),
                                            post.getZd_torque_for_start_close(),
                                            post.getZd_type(),
                                            post.getZd_time_to_sleep(),
                                            post.getZd_discrete_command(),
                                            post.getZd_open_position(),
                                            post.getZd_close_position(),
                                            post.getZd_dimens_x(),
                                            post.getZd_dimens_y(),
                                            post.getZd_pdf_main(),
                                            post.getZd_pdf_uso(),
                                            post.getZd_pdf_main_page(),
                                            post.getZd_pdf_uso_page(),
                                            post.getZd_redundant(),
                                            post.getZd_redundant_2()};
                            json_sql_converter.put(post.getId(),row);
                        }
                        db.deleteAll();
                        for (HashMap.Entry<Integer, String[]> entry: json_sql_converter.entrySet()){
                            val=entry.getValue();
                            db.addZd(new Zd(val[0],
                                            val[1],
                                            val[2],
                                            val[3],
                                            val[4],
                                            val[5],
                                            val[6],
                                            val[7],
                                            val[8],
                                            val[9],
                                            val[10],
                                            val[11],
                                            val[12],
                                            val[13],
                                            val[14],
                                            val[15],
                                            val[16],
                                            val[17],
                                            val[18],
                                            val[19],
                                            val[20],
                                            val[21],
                                            val[22],
                                            val[23],
                                            val[24],
                                            val[25],
                                            val[26],
                                            val[27]));
                        }
                        Toast.makeText(getApplicationContext(), "json to sqlite complete", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error occurred while getting request!", Toast.LENGTH_SHORT).show();

                        t.printStackTrace();
                    }
                });

        return "Async task complete";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}

}