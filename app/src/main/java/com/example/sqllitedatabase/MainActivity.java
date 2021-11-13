package com.example.sqllitedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button1;
    EditText editText1,editText2,editText3;
    ListView listView;
    ArrayAdapter arrayAdapter;
    List<User>userList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        button1=findViewById(R.id.button1);
        editText1=findViewById(R.id.edittext1);
        editText2=findViewById(R.id.edittext2);
        editText3=findViewById(R.id.edittext3);
        readfrom();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();
                user.setName(editText1.getText().toString());
                user.setSurname(editText2.getText().toString());
                user.setPhonenumber(editText3.getText().toString());
                user.save();
                Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                readfrom();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                User user=User.findById(User.class, userList.get(position).getId());
                user.delete();
                readfrom();
                return true;
            }
        });
    }
    public void readfrom(){
        userList=User.listAll(User.class);
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i=0;i<userList.size();i++){
            arrayList.add(userList.get(i).getName());

        }
        arrayAdapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    

}