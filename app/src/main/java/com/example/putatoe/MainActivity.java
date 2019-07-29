package com.example.putatoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  static  final  String url="https://putatoe.herokuapp.com/api/v1/service";
    private ProgressDialog dialog;
    private List<Item> array=new ArrayList<Item>();
    private ListView listView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.list_item);
        adapter= new com.example.putatoe.Adapter(this,array);
        listView.setAdapter(adapter);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();


        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                hideDialog();

                for(int i=0;i<response.length();i++){

                    try{

                        JSONObject obj = response.getJSONObject(i);
                        Item item = new Item();
                        item.setId(obj.getInt("id"));
                        item.setName(obj.getString("name"));
                        item.setImage(obj.getString("image"));
                        item.setSupportMultipleProductPurchase(obj.getBoolean("supportMultipleProductPurchase"));
                        item.setDiscount(obj.getInt("discount"));



           array.add(item);

                    }catch (JSONException ex){
                        ex.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
AppController.getmInstance().addToRequestQueue(jsonArrayRequest);
    }

    public void  hideDialog(){

        if(dialog !=null){

            dialog.dismiss();
            dialog=null;
        }
    }
}
