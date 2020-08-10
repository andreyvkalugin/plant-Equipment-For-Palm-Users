package com.github.barteksc.sample;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import SQLite_Adapter.Zd;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class start_page extends AppCompatActivity {

   // private EditText DymXX;
    private String fullBody;
    private TextView importX;
    private TextView textView;
    private EditText editText3;
    private String DymXX;
    private EditText DymYY;
    private EditText ipp;
    private Button pushh;
    private Button find;
    private SharedPreferences sPref;
    private final String IP = "saved_text";
    private String fi;
    private Zd zdTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        importX = (TextView) findViewById(R.id.importX);
        textView = (TextView) findViewById(R.id.textView);
        //DymXX = (EditText) findViewById(R.id.EditDymX);
        //DymXX = getIntent().getStringExtra("my");
        fullBody = getIntent().getStringExtra("my");
        DymXX = delimiter(fullBody);
        DymYY = (EditText) findViewById(R.id.EditDymY);
        importX.setText(DymXX);
        ipp = (EditText) findViewById(R.id.ipp);
        editText3 = (EditText) findViewById(R.id.editText3);
        find = (Button) findViewById(R.id.find);
        //loadIP();
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NetworkService.BASE_URL = "http://" + ipp.getText().toString() + ":4000/";
                fi = editText3.getText().toString();
                //getAllpost();
                //getNeedPost();


                Thread w = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Zd zd = Entry_Activity.db.getZd(fi);
                        //List_for_zd2.zdMyInfo[0]=Integer.toString(zd.get_id());
                        List_for_zd.zdMyInfo[0]=zd.get_zd_name();
                        List_for_zd.zdMyInfo[1]=zd.get_zd_location();
                        List_for_zd.zdMyInfo[2]=zd.get_zd_blok_number();
                        List_for_zd.zdMyInfo[3]=zd.get_sa_name();
                        List_for_zd.zdMyInfo[4]=zd.get_uso_name();
                        List_for_zd.zdMyInfo[5]=zd.get_CI_number();
                        List_for_zd.zdMyInfo[6]=zd.get_zd_hod();
                        List_for_zd.zdMyInfo[7]=zd.get_zd_modbus_speed();
                        List_for_zd.zdMyInfo[8]=zd.get_zd_modbus_number();
                        List_for_zd.zdMyInfo[9]=zd.get_zd_modbus_setting();
                        List_for_zd.zdMyInfo[10]=zd.get_zd_max_torque();
                        List_for_zd.zdMyInfo[11]=zd.get_zd_torque_for_close();
                        List_for_zd.zdMyInfo[12]=zd.get_zd_torque_for_start_open();
                        List_for_zd.zdMyInfo[13]=zd.get_zd_torque_for_open();
                        List_for_zd.zdMyInfo[14]=zd.get_zd_torque_for_start_close();
                        List_for_zd.zdMyInfo[15]=zd.get_zd_type();
                        List_for_zd.zdMyInfo[16]=zd.get_zd_time_to_sleep();
                        List_for_zd.zdMyInfo[17]=zd.get_zd_discrete_command();
                        List_for_zd.zdMyInfo[18]=zd.get_zd_open_position();
                        List_for_zd.zdMyInfo[19]=zd.get_zd_close_position();
                        List_for_zd.zdMyInfo[20]=zd.get_zd_dimens_x();
                        List_for_zd.zdMyInfo[21]=zd.get_zd_dimens_y();
                        List_for_zd.zdMyInfo[22]=zd.get_zd_pdf_main();
                        List_for_zd.zdMyInfo[23]=zd.get_zd_pdf_uso();
                        List_for_zd.zdMyInfo[24]=zd.get_zd_pdf_main_page();
                        List_for_zd.zdMyInfo[25]=zd.get_zd_pdf_uso_page();
                        List_for_zd.zdMyInfo[26]=zd.get_zd_redundant();
                        List_for_zd.zdMyInfo[27]=zd.get_zd_redundant_2();
                    }
                });
                w.start();

                Intent intent = new Intent(start_page.this, List_for_zd.class);
                startActivity(intent);

            }
        });

    }

    private String delimiter(String fullBody) {
        String[] subStr;
        String delimeter = "//";
        subStr = fullBody.split(delimeter);
        for (int i=0; i <subStr.length; i++){
            textView.append(subStr[i] + "\n");
        }
        return subStr[0];

    }

    public void nextActivity (View v) {
        //NetworkService.BASE_URL = "http://" + ipp.getText().toString() + ":4000/";

        Post post = new Post (List_for_zd.zdMyInfo[0], List_for_zd.zdMyInfo[1], List_for_zd.zdMyInfo[2], List_for_zd.zdMyInfo[3]
                , List_for_zd.zdMyInfo[4]
                , List_for_zd.zdMyInfo[5]
                , List_for_zd.zdMyInfo[6]
                , List_for_zd.zdMyInfo[7]
                , List_for_zd.zdMyInfo[8]
                , List_for_zd.zdMyInfo[9]
                , List_for_zd.zdMyInfo[10]
                , List_for_zd.zdMyInfo[11]
                , List_for_zd.zdMyInfo[12]
                , List_for_zd.zdMyInfo[13]
                , List_for_zd.zdMyInfo[14]
                , List_for_zd.zdMyInfo[15]
                , List_for_zd.zdMyInfo[16]
                , List_for_zd.zdMyInfo[17]
                , List_for_zd.zdMyInfo[18]
                , List_for_zd.zdMyInfo[19]
                , List_for_zd.zdMyInfo[20]
                , List_for_zd.zdMyInfo[21]
                , List_for_zd.zdMyInfo[22]
                , List_for_zd.zdMyInfo[23]
                , List_for_zd.zdMyInfo[24]
                , List_for_zd.zdMyInfo[25]
                , List_for_zd.zdMyInfo[26]
                , List_for_zd.zdMyInfo[27]);
        NetworkService.getInstance()
                .getJSONApi()
                .postData(post)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post postResponse = response.body();

                       // textView.append(response.code() + "\n");
                       textView.append(postResponse.getId() + "\n");
                        //textView.append(post.getUserId() + "\n");
                       // textView.append(postResponse.getTitle() + "\n");
                        // textView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
        Intent intent = new Intent(this, PDFViewActivity_.class);
      //PDFViewActivity.DymX = Integer.parseInt(DymXX.getText().toString());
        PDFViewActivity.DymX = Integer.parseInt(DymXX);
        PDFViewActivity.DymY = Integer.parseInt(DymYY.getText().toString());
     //   intent.putExtra("X",DymXX.getText().toString());
     //   intent.putExtra("Y",DymYY.getText().toString());
        startActivity(intent);
    }
    public void getNeedPost() {
        NetworkService.getInstance()
                .getJSONApi()
                .getPostOfTitle(DymXX)
                .enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Post>> call, @NonNull Response<List<Post>> response) {
                        List<Post> posts = response.body();

                        for (Post post : posts) {
                            textView.append(post.getId() + "\n");
                            //textView.append(post.getUserId() + "\n");
                           // textView.append(post.getTitle() + "\n");
                            // textView.append(post.getBody() + "\n");
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }
    ///not needed but still
    public void pushPost() {
        //Post post = new Post (titlee.getText().toString());
        Post post = new Post (List_for_zd.zdMyInfo[0], List_for_zd.zdMyInfo[1], List_for_zd.zdMyInfo[2], List_for_zd.zdMyInfo[3]
                , List_for_zd.zdMyInfo[4]
                , List_for_zd.zdMyInfo[5]
                , List_for_zd.zdMyInfo[6]
                , List_for_zd.zdMyInfo[7]
                , List_for_zd.zdMyInfo[8]
                , List_for_zd.zdMyInfo[9]
                , List_for_zd.zdMyInfo[10]
                , List_for_zd.zdMyInfo[11]
                , List_for_zd.zdMyInfo[12]
                , List_for_zd.zdMyInfo[13]
                , List_for_zd.zdMyInfo[14]
                , List_for_zd.zdMyInfo[15]
                , List_for_zd.zdMyInfo[16]
                , List_for_zd.zdMyInfo[17]
                , List_for_zd.zdMyInfo[18]
                , List_for_zd.zdMyInfo[19]
                , List_for_zd.zdMyInfo[20]
                , List_for_zd.zdMyInfo[21]
                , List_for_zd.zdMyInfo[22]
                , List_for_zd.zdMyInfo[23]
                , List_for_zd.zdMyInfo[24]
                , List_for_zd.zdMyInfo[25]
                , List_for_zd.zdMyInfo[26]
                , List_for_zd.zdMyInfo[27]);
        NetworkService.getInstance()
                .getJSONApi()
                .postData(post)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post postResponse = response.body();

                        textView.append(response.code() + "\n");
                        textView.append(postResponse.getId() + "\n");
                        //textView.append(post.getUserId() + "\n");
                        //textView.append(postResponse.getTitle() + "\n");
                        // textView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }

    public void getPost() {
        NetworkService.getInstance()
                .getJSONApi()
              //  .getPostWithID(Integer.parseInt(idd.getText().toString()))
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textView.append(post.getId() + "\n");
                        //textView.append(post.getUserId() + "\n");
                        //textView.append(post.getTitle() + "\n");
                        // textView.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }







    public void loadIP () {
        sPref = getSharedPreferences("Server_IP", MODE_PRIVATE);
        String savedIP = sPref.getString(IP, "");
        ipp.setText(savedIP);
    }
    public void SaveIP () {
        sPref = getSharedPreferences("Server_IP", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(IP, ipp.getText().toString());
        ed.commit();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SaveIP();
    }
}
