package com.fordroid.gameheroequiz.view;

import com.fordroid.gameheroequiz.R;
import com.fordroid.gameheroequiz.util.Constants;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

public class SettingsActivity extends PreferenceActivity{
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        addPreferencesFromResource(R.xml.settings);
 
        SharedPreferences settings = getSharedPreferences(Constants.SETTINGS, 0);
		int difficulty = settings.getInt(Constants.DIFFICULTY, 2);
		int language = settings.getInt(Constants.LANGUAGE, 1);
		
//		ListPreference listPreferenceLanguage = (ListPreference) findPreference("LANGUAGE");
//		listPreferenceLanguage.setValue(Integer.toString(language));

		ListPreference listPreferenceDifficulty = (ListPreference) findPreference("DIFFICULTY");
		listPreferenceDifficulty.setValue(Integer.toString(difficulty));
    }
}
