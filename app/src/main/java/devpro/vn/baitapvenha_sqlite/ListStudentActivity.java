package devpro.vn.baitapvenha_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {
    private RecyclerView rcStudent;
    private MyDatabaseHelper myDatabaseHelper;
    private ArrayList<StudentModel> studentModel;
    private StudentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        myDatabaseHelper = new MyDatabaseHelper(ListStudentActivity.this);

        studentModel = myDatabaseHelper.getAllStudent();
        adapter = new StudentAdapter(this, studentModel);
        rcStudent.setLayoutManager(new LinearLayoutManager(ListStudentActivity.this));
        rcStudent.setAdapter(adapter);



    }
}
