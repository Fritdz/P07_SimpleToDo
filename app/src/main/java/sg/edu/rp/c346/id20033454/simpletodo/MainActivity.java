package sg.edu.rp.c346.id20033454.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etTask;
    Button btnAdd;
    Button btnClr;
    ListView lvToDo;
    ArrayList<String> alTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask=findViewById(R.id.etTask);
        btnAdd=findViewById(R.id.btnAdd);
        btnClr=findViewById(R.id.btnClr);
        lvToDo=findViewById(R.id.lvToDo);

        alTasks = new ArrayList<String>();
        ArrayAdapter aatodo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alTasks);
        lvToDo.setAdapter(aatodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = etTask.getText().toString();
                alTasks.add(newTask);
                aatodo.notifyDataSetChanged();
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTasks.clear();
                aatodo.notifyDataSetChanged();
            }
        });




    }
}