package com.kerollosragaie.training_app.sessions.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeriesEntity(@PrimaryKey val id:Int,val trainingSeries: String,val socialPostsContent:String)
