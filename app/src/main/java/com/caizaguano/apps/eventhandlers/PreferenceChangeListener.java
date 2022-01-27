package com.aperez.apps.eventhandlers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.widget.Toast;

import com.aperez.apps.androidfunwithflags.MainActivityKDCC;
import com.aperez.apps.androidfunwithflags.R;

import java.util.Set;

public class PreferenceChangeListener implements OnSharedPreferenceChangeListener {
    private MainActivityKDCC mainActivityKDCC;

    public PreferenceChangeListener(MainActivityKDCC mainActivityKDCC) {
        this.mainActivityKDCC = mainActivityKDCC;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.mainActivityKDCC.setPreferencesChanged(true);

        if (key.equals(this.mainActivityKDCC.getREGIONS())) {
            this.mainActivityKDCC.getQuizViewModel().setGuessRows(sharedPreferences.getString(
                    MainActivityKDCC.CHOICES, null));
            this.mainActivityKDCC.getQuizFragment().resetQuiz();
        } else if (key.equals(this.mainActivityKDCC.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.mainActivityKDCC.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.mainActivityKDCC.getQuizViewModel().setRegionsSet(regions);
                this.mainActivityKDCC.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.mainActivityKDCC.getString(R.string.default_region));
                editor.putStringSet(this.mainActivityKDCC.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.mainActivityKDCC, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.mainActivityKDCC, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
