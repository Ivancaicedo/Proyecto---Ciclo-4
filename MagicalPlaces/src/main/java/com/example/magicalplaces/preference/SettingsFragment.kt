package com.example.magicalplaces.preference

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.preference.PreferenceFragmentCompat
import com.example.magicalplaces.R
import com.example.magicalplaces.main.MainActivity

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        (activity as MainActivity?)?.showIcon()
    }
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
    }
}