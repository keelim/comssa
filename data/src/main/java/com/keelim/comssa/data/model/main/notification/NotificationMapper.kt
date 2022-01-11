package com.keelim.comssa.data.model.main.notification

import com.keelim.comssa.data.api.response.ResponseNotification

fun ResponseNotification.toNotification(): List<Notification> {
    return this.values.map {
        Notification(
            version = it[0],
            main = it[1],
            desc = it[2],
        )
    }
}