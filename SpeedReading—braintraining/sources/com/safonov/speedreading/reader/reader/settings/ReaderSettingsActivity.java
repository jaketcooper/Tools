package com.safonov.speedreading.reader.reader.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.preference.PreferenceManager;
import android.support.p003v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.speedreading.alexander.speedreading.R;

public class ReaderSettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String changedTextSize;
    private SharedPreferences sharedPreferences;
    private String textSize;
    @BindString(2131624243)
    String textSizeDefaultValue;
    @BindString(2131624244)
    String textSizeKey;
    @BindView(2131296781)
    Toolbar toolbar;
    private Unbinder unbinder;

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.reader_settings_activity);
        this.unbinder = ButterKnife.bind((Activity) this);
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String string = this.sharedPreferences.getString(this.textSizeKey, this.textSizeDefaultValue);
        this.textSize = string;
        this.changedTextSize = string;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, ReaderSettingsFragment.newInstance()).commit();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle((int) R.string.settings);
        getSupportActionBar().setHomeAsUpIndicator((int) R.drawable.action_bar_back_icon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void finish() {
        if (this.textSize.equals(this.changedTextSize)) {
            setResult(0);
        } else {
            Intent data = new Intent();
            data.putExtra(this.textSizeKey, this.changedTextSize);
            setResult(-1, data);
        }
        super.finish();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String key) {
        if (key.equals(this.textSizeKey)) {
            this.changedTextSize = sharedPreferences2.getString(key, this.textSizeDefaultValue);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.unbinder.unbind();
        this.unbinder = null;
    }
}
