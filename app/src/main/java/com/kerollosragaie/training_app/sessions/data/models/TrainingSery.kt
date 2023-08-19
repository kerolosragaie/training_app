package com.kerollosragaie.training_app.sessions.data.models

data class TrainingSery(
    val classes: List<Classe>,
    val coaches: List<Coache>,
    val coverPhoto: String,
    val difficulty: String,
    val id: String,
    val intensity: String,
    val overviewSection: OverviewSection,
    val seriesName: String
)