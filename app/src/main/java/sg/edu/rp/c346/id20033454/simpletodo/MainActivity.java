package sg.edu.rp.c346.id20033454.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spnChoice;
    EditText etTask;
    Button btnAdd;
    Button btnDel;
    Button btnClr;
    ListView lvToDo;
    ArrayList<String> alTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnChoice=findViewById(R.id.spinner);
        etTask=findViewById(R.id.etTask);
        btnAdd=findViewById(R.id.btnAdd);
        btnDel=findViewById(R.id.btnDel);
        btnClr=findViewById(R.id.btnClr);
        lvToDo=findViewById(R.id.lvToDo);

        btnDel.setEnabled(false);
        etTask.setHint("Type in a new task here");

        alTasks = new ArrayList<String>();
        ArrayAdapter aatodo = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alTasks);
        lvToDo.setAdapter(aatodo);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = etTask.getText().toString();
                alTasks.add(newTask);
                aatodo.notifyDataSetChanged();
                etTask.setText("");
            }
        });

        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTasks.clear();
                aatodo.notifyDataSetChanged();
                etTask.setText("");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int delTask = Integer.parseInt((etTask.getText().toString()));
                alTasks.remove(delTask);
                aatodo.notifyDataSetChanged();
                etTask.setText("");
            }
        });

        spnChoice.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: //Add
                        btnAdd.setEnabled(true);
                        btnDel.setEnabled(false);
                        etTask.setHint("Type in a new task here");
                        break;
                    case 1: //Delete
                        btnAdd.setEnabled(false);
                        btnDel.setEnabled(true);
                        etTask.setHint("Type in the index of the task to be removed");
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
}