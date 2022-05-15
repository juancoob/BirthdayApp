package com.example.birthdayapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.BirthDayUser
import com.example.usecases.FetchBirthdayUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchBirthdayUsersUseCase: FetchBirthdayUsersUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<UiState> = MutableStateFlow(UiState.Initial)
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = UiState.Data(
                fetchBirthdayUsersUseCase(
                    results = "10",
                    seed = "chalkboard",
                    inc = "name,dob"
                )
            )
        }
    }

    sealed class UiState {
        object Initial : UiState()
        data class Data(val list: List<BirthDayUser>) : UiState()
    }
}