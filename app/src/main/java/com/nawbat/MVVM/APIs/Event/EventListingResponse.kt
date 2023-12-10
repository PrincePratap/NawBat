package com.nawbat.MVVM.APIs.Event

data class EventListingResponse(
    val code: Int,
    val count: Int,
    val `data`: List<DataEvent>,
    val message: String,
    val statusCode: Int
)
data class EventImageDetail(
    val created_at: String,
    val event_image_id: Int,
    val image: String,
    val updated_at: String
)
data class Location(
    val coordinates: List<Double>,
    val type: String
)
data class DataEvent(
    val city: String,
    val created_at: String,
    val date: String,
    val description: String,
    val eventImageDetails: List<EventImageDetail>,
    val event_id: Int,
    val isPolledData: Int,
    val is_active: Int,
    val location: Location,
    val organizer_email: String,
    val organizer_mobile: String,
    val organizer_name: String,
    val pollCountData: Int,
    val price: Int,
    val time: String,
    val title: String,
    val updated_at: String,
    val userComing: Any,
    val userComingPollData: Int,
    val venue: String
)