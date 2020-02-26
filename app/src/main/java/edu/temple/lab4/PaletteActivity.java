package edu.temple.lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class PaletteActivity extends AppCompatActivity {

    private ArrayList<CustomColor> list = new ArrayList<>();
    private ColorAdapter adapter;
    private boolean first = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        addColor();
        adapter = new ColorAdapter(this, list);
        Spinner spinner= findViewById(R.id.spinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (first){
                    first = false;
                    return;
                }
                Intent intent = new Intent(PaletteActivity.this,CanvasActivity.class);
                String color = list.get(i).getColor();
                intent.putExtra("color",color);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    private void addColor() {
        list.add(new CustomColor("White","#FFFFFF"));
        list.add(new CustomColor("BLUE","#0000ff"));
        list.add(new CustomColor("RED","#ff0000"));
        list.add(new CustomColor("YELLOW","#ffff00"));
        list.add(new CustomColor("MAGENTA","#ff00ff"));
        list.add(new CustomColor("LTGRAY","#cccccc"));
        list.add(new CustomColor("GREEN","#00ff00"));
        list.add(new CustomColor("NavajoWhite","#FFDEAD"));
        list.add(new CustomColor("GreenYellow","#ADFF2F"));
        list.add(new CustomColor("LightSalmon","#FFA07A"));
        list.add(new CustomColor("Tomato","#FF6347"));
        list.add(new CustomColor("Turquoise","#40E0D0"));
        list.add(new CustomColor("Maroon","#800000"));
    }
}