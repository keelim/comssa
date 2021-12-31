package com.keelim.comssa.ui.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keelim.comssa.domain.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class NotificationViewModel @Inject constructor(
    val searchUseCase: SearchUseCase
): ViewModel() {
    var _state:MutableStateFlow<NotificationState> = MutableStateFlow(NotificationState.UnInitialized)
    val state: StateFlow<NotificationState>
        get() = _state
    init {
        getNotification()
    }

    private fun getNotification() = viewModelScope.launch {
        _state.emit(
            NotificationState.Loading
        )
        runCatching {
            searchUseCase.getNotificationData()
        }.onSuccess {
            _state.emit(
                NotificationState.Success(
                    it
                )
            )
        }.onFailure {
            _state.emit(
                NotificationState.Error(
                    "오류가 발생하였습니다."
                )
            )
        }
    }
}