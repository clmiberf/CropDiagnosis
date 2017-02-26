package com.example.developer.cropdiagnosis.mvp.ui.activities.condition;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.developer.cropdiagnosis.R;
import com.example.developer.cropdiagnosis.mvp.ui.activities.base.BaseActivity;
import com.example.developer.cropdiagnosis.mvp.view.DiseaseConditionView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import fr.ganfra.materialspinner.MaterialSpinner;

public class DiseaseConditionActivity extends BaseActivity implements DiseaseConditionView {
    //评价
    @BindView(R.id.evaluate_selection)
    MaterialSpinner mspinEvaluate;
    //图片说明
    @BindView(R.id.image_crop)
    ImageView cropImage;
    //文字说明
    @BindView(R.id.word_instruction)
    TextView instruction;
    //病名
    @BindView(R.id.disease_name)
    TextView diseaseName;
    //病因
    @BindView(R.id.disease_cause)
    TextView diseaseCause;
    //解决方法
    @BindView(R.id.disease_solution)
    TextView solution;
    @BindView(R.id.solution_time)
    TextView solutionDate;
    //受理人
    @BindView(R.id.disease_accept_person)
    TextView acceptPerson;
    //补充
    @BindView(R.id.supplementary)
    TextView supplement;
    @BindView(R.id.disease_btn_submit)
    Button submit;


    private ArrayAdapter<String> evaluateAdapter = null;



    @Override
    public int getLayoutId() {
        return R.layout.content_disease_condition;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDiseaseName("张三");
        initAccpter("李四");
        initDiseaseCause("干旱病虫害");
        List<String> eva = Arrays.asList("sfsd","sdfsd","fdsfds");
        initEvaluate(eva);
        initSupplement("有待提高");
        initSoluteDate("2016.12.12");
        initWordInstruction("今天天气真好");
        initSolution("使用杀虫剂");

    }
//
//    @Override
//    public void initDiseaseImageView(String imageUrl) {
//        Bitmap bmp = null;
//        try {
//            URL myurl = new URL(imageUrl);
//            //获得链接
//            HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
//            connection.setConnectTimeout(6000);
//            connection.setDoInput(true);
//            connection.setUseCaches(false);
//            InputStream is = connection.getInputStream();
//            bmp = BitmapFactory.decodeStream(is);
//            is.close();
//            cropImage.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void initDiseaseName(String name) {
        diseaseName.setText(name);
    }

    @Override
    public void initWordInstruction(String instruction) {
        this.instruction.setText(instruction);
    }

    @Override
    public void initDiseaseCause(String cause) {
        diseaseCause.setText(cause);
    }

    @Override
    public void initSolution(String solution) {
        this.solution.setText(solution);
    }

    @Override
    public void initSoluteDate(String soluteDate) {
        this.solutionDate.setText(soluteDate);
    }

    @Override
    public void initAccpter(String accept) {
        acceptPerson.setText(accept);
    }

    @Override
    public void initEvaluate(List<String> evaluate) {
        evaluateAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,evaluate);
        evaluateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinEvaluate.setAdapter(evaluateAdapter);
        mspinEvaluate.setError("init evaluateSpinner error");
    }

    @Override
    public void initSupplement(String supplement) {
        this.supplement.setText(supplement);
    }
}
