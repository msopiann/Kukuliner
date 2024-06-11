package com.bangkit.kukuliner.ui.main

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.kukuliner.data.CulinaryRepository
import com.bangkit.kukuliner.data.remote.response.CulinaryResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val repository: CulinaryRepository) : ViewModel() {

    fun getThemeSettings() = repository.getThemeSettings()

    fun getCulinary() = repository.getCulinary()

    fun saveCulinary(culinary: CulinaryResponseItem) {
        viewModelScope.launch {
            repository.setFavoriteCulinary(culinary, true)
        }
    }

    fun deleteCulinary(culinary: CulinaryResponseItem) {
        viewModelScope.launch {
            repository.setFavoriteCulinary(culinary, false)
        }
    }

    fun getLastKnownLocation(onLocationRetrieved: (Location?) -> Unit) {
        viewModelScope.launch {
            val location = withContext(Dispatchers.IO) {
                repository.getLastKnownLocation()
            }
            onLocationRetrieved(location)
        }
    }
}
