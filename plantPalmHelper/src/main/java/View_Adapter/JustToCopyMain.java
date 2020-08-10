package View_Adapter;

public class JustToCopyMain {
}
/**package View_Adapter;

 import android.app.Activity;
 import android.app.Application;
 import android.content.Intent;
 import android.os.Bundle;
 import android.graphics.drawable.Drawable;
 import android.support.annotation.NonNull;
 import android.support.design.widget.FloatingActionButton;
 import android.support.design.widget.NavigationView;
 import android.support.design.widget.TabLayout;
 import android.support.v4.view.ViewPager;
 import android.support.v4.widget.DrawerLayout;
 import android.support.v7.app.ActionBarDrawerToggle;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;
 import android.view.MenuItem;
 import android.view.View;
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

 import java.util.ArrayList;
 import java.util.List;

 import SQLite_Adapter.Zd;
 import View_Adapter.Adapter.TabsFragmentAdapter;
 import View_Adapter.dto.RemindDTO;
 import View_Adapter.fragment.IdeasFragment;


 public class ViewAdapterActivity extends AppCompatActivity {
 private Toolbar toolbar;
 private DrawerLayout drawerLayout;
 private ViewPager viewPager;
 public static List<RemindDTO> listZdName = new ArrayList<>();
 private FloatingActionButton fab;
 public static int CurrentTab;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 setTheme(R.style.AppDefault);
 super.onCreate(savedInstanceState);
 setContentView(R.layout.view_adapter_activity);
 final Activity activity = this;
 ImageView backdrops = findViewById(R.id.backdrop);
 backdrops.setImageResource(R.drawable.toolbar_back2);

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

 }
*/