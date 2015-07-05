package homelessless.govhack.org.homelessless;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import homelessless.govhack.org.homelessless.models.Category;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setup ViewPager with organisations
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }

        // Setup tabs and enable them to be scrollable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());

        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_ACCOM);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_CLOTHING);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_COUNSELLING);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_EMPLOYMENT_ASSIST);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_FOOD);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_HEALTH_SERVICES);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_HELP_LINES);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_SHOWERS_LAUNDRY);
        adapter.addFragment(new OrganisationListFragment(), Category.CATEGORY_TRAVEL_ASSIST);

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    static class Adapter extends FragmentPagerAdapter {
        private final List<OrganisationListFragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(OrganisationListFragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
