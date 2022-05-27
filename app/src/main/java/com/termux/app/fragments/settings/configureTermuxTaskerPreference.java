package com.termux.app.fragments.settings;

import android.content.Context;
import android.os.Bundle;

import androidx.preference.Preference;

import com.termux.R;
import com.termux.shared.termux.settings.preferences.TermuxTaskerAppSharedPreferences;

public class configureTermuxTaskerPreference extends configureTermuxPreference{
    private Preference termuxTaskerPreference;

    @Override
    Preference findPreferenceMethod() {
        return termuxTaskerPreference = findPreference("termux_tasker");
    }

    @Override
    void build(Context context, Preference termuxPreference) {
        if (termuxTaskerPreference != null) {
            TermuxTaskerAppSharedPreferences preferences = TermuxTaskerAppSharedPreferences.build(context, false);
            // If failed to get app preferences, then likely app is not installed, so do not show its preference
            termuxTaskerPreference.setVisible(preferences != null);
        }
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
        Context context = getContext();
        generate(context);
        new Thread() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                generate(context);
            }
        }.start();

    }


}


