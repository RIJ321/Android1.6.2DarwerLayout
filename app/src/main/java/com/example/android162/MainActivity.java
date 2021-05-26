package com.example.android162;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;

import com.example.android162.fragments.CheckFragment;
import com.example.android162.fragments.DraftFragment;
import com.example.android162.fragments.FAQFragment;
import com.example.android162.fragments.HistoryFragment;
import com.example.android162.fragments.InboxesFragment;
import com.example.android162.databinding.ActivityMainBinding;
import com.example.android162.fragments.SettingsFragment;
import com.example.android162.fragments.SingleInboxFragment;
import com.example.android162.fragments.TouchFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActivityMainBinding binding;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        drawerLayout=binding.drawerLayout;
        toggle = new ActionBarDrawerToggle(this, binding.drawerLayout, R.string.drawer_open, R.string.close);
        setSupportActionBar(binding.toolbar);
        toggle.syncState();
        binding.drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        addNavs();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
    @Override

    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    private void addNavs() {
        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment = null;
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.inboxes:
                        fragment = new InboxesFragment();
                        break;
                    case R.id.inbox:
                        fragment = new SingleInboxFragment();
                        item.setChecked(true);
                        break;
                    case R.id.history:
                        fragment = new HistoryFragment();
                        break;
                    case R.id.check:
                        fragment = new CheckFragment();
                        break;
                    case R.id.draft:
                        fragment = new DraftFragment();
                        break;
                    case R.id.send:
                        fragment = new TouchFragment();
                        break;
                    case R.id.settings:
                        fragment = new SettingsFragment();
                        break;
                    case R.id.help:
                        fragment = new FAQFragment();
                        break;
                    default:
                        fragment = new InboxesFragment();
                }
                binding.drawerLayout.closeDrawers();
                selectFragment(fragment);
                item.setChecked(true);
                setTitle(item.getTitle());
                return false;
            }
        });
    }


    private void selectFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.main_container, fragment).commit();
    }


}