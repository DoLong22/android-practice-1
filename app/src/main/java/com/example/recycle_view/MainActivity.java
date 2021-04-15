package com.example.recycle_view;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.recycle_view.adapter.ItemAdapter;
import com.example.recycle_view.model.Item;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner imgSpinner;
    private ImageView imageView;
    private EditText editTextID;
    private EditText editTextName;
    private TextView tvDatePicker;
    private Button btnAdd;
    private RecyclerView recyclerItem;
    private ItemAdapter itemAdapter;
    private int imgResource;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
        recyclerItem.setAdapter(itemAdapter);
        recyclerItem.setLayoutManager(new LinearLayoutManager(this));
        recyclerItem.setHasFixedSize(true);
        handleItemSelected();
    }
    public void setListener(){
        btnAdd.setOnClickListener(this);
        tvDatePicker.setOnClickListener(this);
    }

    public void initView() {
        imgSpinner = findViewById(R.id.img_spinner);
        imageView = findViewById(R.id.imageView);
        editTextID = findViewById(R.id.editTextID);
        editTextName = findViewById(R.id.editTextName);
        recyclerItem = findViewById(R.id.recycler_item);
        btnAdd = findViewById(R.id.btnAdd);
        tvDatePicker = findViewById(R.id.tvDatePicker);
        itemAdapter = new ItemAdapter();
    }
    public void handleItemSelected(){
        imgSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String srcImg = parent.getItemAtPosition(position).toString();
                switch (srcImg){
                    case "Image 1":
                        imageView.setImageResource(R.drawable.a10fff21351c677b4f20ff5c629ccb30);
                        imgResource = R.drawable.a10fff21351c677b4f20ff5c629ccb30;
                        break;
                    case "Image 2":
                        imageView.setImageResource(R.drawable.antarctic);
                        imgResource = R.drawable.antarctic;
                        break;
                    case "Image 3":
                        imageView.setImageResource(R.drawable.grandeco);
                        imgResource = R.drawable.grandeco;
                        break;
                    case "Image 4":
                        imageView.setImageResource(R.drawable.image_day);
                        imgResource = R.drawable.image_day;
                        break;
                    default:
                        imageView.setImageResource(R.drawable.b4cf36f67cfd53453a3cb4ae7c86bf15);
                        imgResource = R.drawable.b4cf36f67cfd53453a3cb4ae7c86bf15;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:{
                String id, name, date;
                id = editTextID.getText().toString();
                name = editTextName.getText().toString();
                date = tvDatePicker.getText().toString();
                itemAdapter.addToList(new Item(id,name,imgResource, date));
                break;
            }
            case R.id.tvDatePicker:{
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDatePicker.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                }, year, month, day);
                datePickerDialog.show();
                break;
            }
        }
    }
}