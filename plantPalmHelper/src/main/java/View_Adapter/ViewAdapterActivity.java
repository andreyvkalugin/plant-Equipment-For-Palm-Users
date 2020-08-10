package View_Adapter;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.barteksc.sample.Entry_Activity;
import com.github.barteksc.sample.List_for_zd;
import com.github.barteksc.sample.R;
import com.github.barteksc.sample.ReaderActivity;
import com.github.barteksc.sample.start_page;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import com.wnafee.vector.compat.ResourcesCompat;

import java.util.ArrayList;
import java.util.List;

import SQLite_Adapter.Zd;
import View_Adapter.Adapter.TabsFragmentAdapter;
import View_Adapter.dto.RemindDTO;
import View_Adapter.fragment.IdeasFragment;
import find.interfaces.onSearchListener;
import find.interfaces.onSimpleSearchActionsListener;

import find.utils.Util;
import find.widgets.MaterialSearchView;


public class ViewAdapterActivity extends AppCompatActivity implements onSimpleSearchActionsListener, onSearchListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;
    public static List<RemindDTO> listZdName = new ArrayList<>();
    private FloatingActionButton fab;
    public static int CurrentTab;


    private boolean mSearchViewAdded = false;
    private MaterialSearchView mSearchView;
    private WindowManager mWindowManager;
    private MenuItem searchItem;
    private boolean searchActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_adapter_activity);
        final Activity activity = this;
        ImageView backdrops = findViewById(R.id.backdrop);
        //backdrops.setImageResource(R.drawable.toolbar_back2);
        Drawable wave = ResourcesCompat.getDrawable(this, R.drawable.wave_avd);
        backdrops.setBackground(wave);
        ((Animatable) backdrops.getBackground()).start();








        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

        initZdList();
        initToolbar();
        initNavigationView();
        initTabs();
        materialDesignProper();

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                CurrentTab = position;
                //IdeasFragment.adapter.notifyDataSetChanged();
                Toast.makeText(activity, Integer.toString(CurrentTab), Toast.LENGTH_LONG).show();
            }
        });



    }

    private void materialDesignProper() {
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mSearchView = new MaterialSearchView(this);
        mSearchView.setOnSearchListener(this);
        mSearchView.setSearchResultsListener(this);
        mSearchView.setHintText("Search");

        if (toolbar != null) {
            // Delay adding SearchView until Toolbar has finished loading
            toolbar.post(new Runnable() {
                @Override
                public void run() {
                    if (!mSearchViewAdded && mWindowManager != null) {
                        mWindowManager.addView(mSearchView,
                                MaterialSearchView.getSearchViewLayoutParams(ViewAdapterActivity.this));
                        mSearchViewAdded = true;
                    }
                }
            });
        }
    }


    private void initZdList() {
        Thread w = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Zd> listZd = Entry_Activity.db.getAllZd();

                for (Zd zd : listZd) {
                    listZdName.add(new RemindDTO(zd.get_zd_name()));
                }

            }
        });
        w.start();
    }

    private void initTabs() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this,getSupportFragmentManager(),viewPager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        drawerLayout.setDrawerListener(toogle);
        toogle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.actionNotificationItem:
                        showNotificationTab();
                }
                return true;
            }
        });


    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
        toolbar.inflateMenu(R.menu.menu);

    }

    private void showNotificationTab() {
        viewPager.setCurrentItem(Constants.TAB_ALL_ZD);

    }

    private void scanZd() {
        viewPager.setCurrentItem(Constants.TAB_ZD_LIST);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewAdapterActivity.listZdName.clear();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                delimiter(result.getContents());
                IdeasFragment.adapter.notifyDataSetChanged();
                scanZd();

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void delimiter(String fullBody) {
        String[] subStr;
        String delimeter = "/";
        subStr = fullBody.split(delimeter);
        for (int i=0; i <28; i++){
           List_for_zd.zdMyInfo[i] = subStr[i];
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        searchItem = menu.findItem(R.id.search);
        searchItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                mSearchView.display();
                openKeyboard();
                return true;
            }
        });
        if(searchActive)
            mSearchView.display();
        return true;

    }

    private void openKeyboard(){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mSearchView.getSearchView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 0, 0, 0));
                mSearchView.getSearchView().dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, 0, 0, 0));
            }
        }, 200);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSearch(final String query) {
        final String queryMy =query;
        Toast.makeText(ViewAdapterActivity.this,queryMy,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchViewOpened() {
        Toast.makeText(ViewAdapterActivity.this,"Search View Opened",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void searchViewClosed() {
        Util.showSnackBarMessage(fab,"Search View Closed");
    }

    @Override
    public void onItemClicked(String item) {
        final String zdToFind = item;
        Toast.makeText(ViewAdapterActivity.this,item + " clicked",Toast.LENGTH_SHORT).show();
        Thread w = new Thread(new Runnable() {
            @Override
            public void run() {
                Zd zd = Entry_Activity.db.getZd(zdToFind);

                 List_for_zd.zdMyInfo[0]=zd.get_zd_name();
                 List_for_zd.zdMyInfo[1]=zd.get_zd_location();
                 List_for_zd.zdMyInfo[2]=zd.get_zd_blok_number();
                 List_for_zd.zdMyInfo[3]=zd.get_sa_name();
                 List_for_zd.zdMyInfo[4]=zd.get_uso_name();
                 List_for_zd.zdMyInfo[5]=zd.get_CI_number();
                 List_for_zd.zdMyInfo[6]=zd.get_zd_hod();
                 List_for_zd.zdMyInfo[7]=zd.get_zd_modbus_speed();
                 List_for_zd.zdMyInfo[8]=zd.get_zd_modbus_number();
                 List_for_zd.zdMyInfo[9]=zd.get_zd_modbus_setting();
                 List_for_zd.zdMyInfo[10]=zd.get_zd_max_torque();
                 List_for_zd.zdMyInfo[11]=zd.get_zd_torque_for_close();
                 List_for_zd.zdMyInfo[12]=zd.get_zd_torque_for_start_open();
                 List_for_zd.zdMyInfo[13]=zd.get_zd_torque_for_open();
                 List_for_zd.zdMyInfo[14]=zd.get_zd_torque_for_start_close();
                 List_for_zd.zdMyInfo[15]=zd.get_zd_type();
                 List_for_zd.zdMyInfo[16]=zd.get_zd_time_to_sleep();
                 List_for_zd.zdMyInfo[17]=zd.get_zd_discrete_command();
                 List_for_zd.zdMyInfo[18]=zd.get_zd_open_position();
                 List_for_zd.zdMyInfo[19]=zd.get_zd_close_position();
                 List_for_zd.zdMyInfo[20]=zd.get_zd_dimens_x();
                 List_for_zd.zdMyInfo[21]=zd.get_zd_dimens_y();
                 List_for_zd.zdMyInfo[22]=zd.get_zd_pdf_main();
                 List_for_zd.zdMyInfo[23]=zd.get_zd_pdf_uso();
                 List_for_zd.zdMyInfo[24]=zd.get_zd_pdf_main_page();
                 List_for_zd.zdMyInfo[25]=zd.get_zd_pdf_uso_page();
                 List_for_zd.zdMyInfo[26]=zd.get_zd_redundant();
                 List_for_zd.zdMyInfo[27]=zd.get_zd_redundant_2();
            }
        });
        w.start();
        IdeasFragment.adapter.notifyDataSetChanged();
        viewPager.setCurrentItem(Constants.TAB_ZD_LIST);
    }

    @Override
    public void onScroll() {

    }

    @Override
    public void error(String localizedMessage) {

    }

    @Override
    public void onCancelSearch() {
        Util.showSnackBarMessage(fab,"Search View Cleared");
        searchActive = false;
        mSearchView.hide();
    }

}
