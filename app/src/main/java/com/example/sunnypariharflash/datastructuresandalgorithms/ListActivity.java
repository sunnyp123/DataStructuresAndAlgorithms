package com.example.sunnypariharflash.datastructuresandalgorithms;

import android.app.IntentService;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

public class ListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ExpandableListAdapters listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        expListView = findViewById(R.id.listexpands);
        prepareListData();
        listAdapter = new ExpandableListAdapters(this,listDataHeader,listDataChild);
        expListView.setAdapter(listAdapter);
      expListView.setOnChildClickListener(new OnChildClickListener() {
          @Override
          public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
             Intent intent = new Intent(ListActivity.this,MainActivity.class);
             intent.putExtra("Group",groupPosition);
             intent.putExtra("Child",childPosition);
             startActivity(intent);
              return false;
          }
      });
      expListView.setOnGroupClickListener(new OnGroupClickListener() {
          @Override
          public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
              if(parent.isGroupExpanded(groupPosition)){
                  ImageView views = v.findViewById(R.id.updowngp);
                 views.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_upward_blacks_24dp));
              }
              else{
                  ImageView views = v.findViewById(R.id.updowngp);
                  views.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_downward_black_24dp));
              }
              return false;
          }
      });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        listDataHeader.add("Introduction");
        listDataHeader.add("Data Structures");
        listDataHeader.add("Algorithms");
        listDataHeader.add("Coding InterView Questions.");


        List<String> top250 = new ArrayList<String>();
        top250.add("Introduction to DataStructure");
        top250.add("Introduction to Algorithms");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Stack");
        nowShowing.add("Queue");
        nowShowing.add("LinkedList");
        nowShowing.add("Hash Table");
        nowShowing.add("Trees");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Time And Space Complexity");
        comingSoon.add("Searching");
        comingSoon.add("Sorting");
        comingSoon.add("Graph Theory");
        comingSoon.add("Dynamic Programming");
        List<String> coding = new ArrayList<String>();
        coding.add("TCS Questions");
        coding.add("Amazon Questions");


        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3),coding);
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
