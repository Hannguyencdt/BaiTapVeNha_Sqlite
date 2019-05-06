package devpro.vn.baitapvenha_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtId;
    private EditText edtTen;
    private EditText edtTuoi;
    private EditText edtDiaChi;
    private EditText edtNameClass;

    private Button bntAdd;
    private Button bntEdt;
    private Button bntDelete;
    private Button bntShow;

    private MyDatabaseHelper myDatabaseHelper;
    private ArrayList<StudentModel> studentModels;

    private RecyclerView rcStudent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inItView();
        myDatabaseHelper = new MyDatabaseHelper(MainActivity.this);


    }
    private void inItView(){
        edtId = findViewById(R.id.edtId);
        edtTen = findViewById(R.id.edtTen);
        edtTuoi = findViewById(R.id.edtTuoi);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtNameClass = findViewById(R.id.edtNameClass);
        rcStudent = findViewById(R.id.rcStudent);


        bntAdd = findViewById(R.id.bntAdd);
        bntEdt = findViewById(R.id.bntEdt);
        bntDelete = findViewById(R.id.bntDelete);
        bntShow = findViewById(R.id.bntShow);


        bntAdd.setOnClickListener(this);
        bntEdt.setOnClickListener(this);
        bntDelete.setOnClickListener(this);
        bntShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bntAdd:
                StudentModel modelAdd = new StudentModel();
                modelAdd.setName(edtTen.getText().toString());
                modelAdd.setOld(Integer.parseInt(edtTuoi.getText().toString()));
                modelAdd.setAdd(edtDiaChi.getText().toString());
                modelAdd.setNameClas(edtDiaChi.getText().toString());
                myDatabaseHelper.addStudent(modelAdd);
                break;

            case R.id.bntEdt:
                StudentModel modelUpdate = new StudentModel();
                modelUpdate.setName(edtTen.getText().toString());
                modelUpdate.setOld(Integer.parseInt(edtTen.getText().toString()));
                modelUpdate.setAdd(edtDiaChi.getText().toString());
                modelUpdate.setNameClas(edtNameClass.getText().toString());
                int id = Integer.parseInt(edtId.getText().toString());
                myDatabaseHelper.updateStudent(id, modelUpdate);
                break;

            case R.id.bntDelete:
                int idDelete = Integer.parseInt(edtId.getText().toString());
                myDatabaseHelper.deleteStudent(idDelete);

                break;
            case R.id.bntShow:



                Intent i  = new Intent(MainActivity.this, ListStudentActivity.class);
                startActivity(i);





//                for (StudentModel model : studentModels) {
//                    Log.d("HanCDT", "id" + model.getId() + " name    :" + model.getName());
//                }
                break;



        }


    }
}
