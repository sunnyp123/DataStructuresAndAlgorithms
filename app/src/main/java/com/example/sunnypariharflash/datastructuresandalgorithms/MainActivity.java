package com.example.sunnypariharflash.datastructuresandalgorithms;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Intent intent;
int gp,childs;
TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intent = getIntent();
        gp = intent.getIntExtra("Group",0);
        childs = intent.getIntExtra("Child",0);
        switch(gp){
            case 0:
                switch(childs){
                    case 0:
                        Toast.makeText(this, "Intro to DS", Toast.LENGTH_SHORT).show();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.add(R.id.activitys,new IntroDs(),"Data");
                        ft.commit();
                        break;
                    case 1:
                        Toast.makeText(this, "Intro to Algo", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 1:
                switch(childs){
                    case 0:
                        Toast.makeText(this, "Stack", Toast.LENGTH_SHORT).show();
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.add(R.id.activitys,new BlankFragment(),"Stack");
                        ft.commit();
                        break;
                    case 1:
                        Toast.makeText(this, "Queue", Toast.LENGTH_SHORT).show();
                        FragmentTransaction ftm = getSupportFragmentManager().beginTransaction();
                        ftm.add(R.id.activitys,new Queue(),"Queue");
                        ftm.commit();
                        break;
                    case 2:
                        Toast.makeText(this, "Linked List", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(this, "Hash Table", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(this, "Trees", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 2:
                switch(childs){
                    case 0:
                        Toast.makeText(this, "Complexity", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(this, "Sorting", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(this, "Graphs", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(this, "Dynamic Programming", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
            case 3:
                switch(childs){
                    case 0:
                        Toast.makeText(this, "TCS", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(this, "Amazon", Toast.LENGTH_SHORT).show();
                        break;
                }
                break;
        }
        setContentView(R.layout.activity_main);
        Toast.makeText(this, Integer.toString(gp)+" "+Integer.toString(childs), Toast.LENGTH_SHORT).show();
tabs = findViewById(R.id.tabslayout);
tabs.addTab(tabs.newTab().setText("Introduction"));
tabs.addTab(tabs.newTab().setText("Implementation"));
tabs.addTab(tabs.newTab().setText("Code").setIcon(R.drawable.ic_code_black_24dp));

    }
}
