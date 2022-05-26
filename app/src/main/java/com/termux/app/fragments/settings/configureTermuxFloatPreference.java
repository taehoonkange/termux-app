package com.termux.app.fragments.settings;

import android.content.Context;
import android.os.Bundle;

import androidx.preference.Preference;

import com.termux.R;
import com.termux.shared.termux.settings.preferences.TermuxFloatAppSharedPreferences;

public class configureTermuxFloatPreference extends configureTermuxPreference{
    private Preference termuxFloatPreference;

    @Override
    Preference findPreferenceMethod() {
        return termuxFloatPreference = findPreference("termux_float");
    }

    @Override
    void build(Context context, Preference termuxPreference) {
        if (termuxFloatPreference != null) {
            TermuxFloatAppSharedPreferences preferences = TermuxFloatAppSharedPreferences.build(context, false);
            // If failed to get app preferences, then likely app is not installed, so do not show its preference
            termuxFloatPreference.setVisible(preferences != null);
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
