package com.keelim.comssa.ui.notification

import com.keelim.comssa.data.model.main.notification.Notification

sealed class NotificationState{
    object UnInitialized : NotificationState()
    object Loading : NotificationState()
    data class Success(
        val data: List<Notification>
    ) : NotificationState()

    data class Error(
        val message: String
    ) : NotificationState()
}
