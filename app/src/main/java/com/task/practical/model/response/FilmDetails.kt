package com.task.practical.model.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class FilmDetails(
    @SerializedName("description")
    var description: String,
    @SerializedName("director")
    var director: String,
    @PrimaryKey
    @SerializedName("id")
    var id: String,
    @SerializedName("image")
    var image: String,
//        @SerializedName("locations")
//        var locations: List<String>,
    @SerializedName("movie_banner")
    var movieBanner: String,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("original_title_romanised")
    var originalTitleRomanised: String,
//        @SerializedName("people")
//        var people: List<String>,
    @SerializedName("producer")
    var producer: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("rt_score")
    var rtScore: String,
    @SerializedName("running_time")
    var runningTime: String,
//        @SerializedName("species")
//        var species: List<String>,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String
//        @SerializedName("vehicles")
//        var vehicles: List<String>
) : Parcelable