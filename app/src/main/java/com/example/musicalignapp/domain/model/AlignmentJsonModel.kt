package com.example.musicalignapp.domain.model

data class AlignmentJsonModel (
    val packageId: String,
    val alignmentElements: List<Map<String, String>>
)