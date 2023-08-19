package com.kerollosragaie.training_app.sessions.data.data_source.remote

import com.google.gson.Gson
import com.kerollosragaie.training_app.sessions.data.models.TrainingSeries


class RemoteDataSourceImpl : RemoteDataSource {
    override suspend fun getTrainingSeries(): TrainingSeries {
        val gson = Gson()
        return gson.fromJson(Remote_DATA, TrainingSeries::class.java)
    }

}

val Remote_DATA by lazy {
    """
{
  "id":"1",
  "trainingSeries": [
    {
      "id": "1",
      "coverPhoto": "https://example.com/cover_photo.jpg",
      "seriesName": "Training Series 1",
      "difficulty": "Intermediate",
      "intensity": "Level 3",
      "coaches": [
        {
          "coachId": "1",
          "coachName": "Coach 1"
        },
        {
          "coachId": "2",
          "coachName": "Coach 2"
        }
      ],
      "overviewSection": {
        "description": "Description of Training Series 1",
        "overviewVideo": "https://example.com/overview_video.mp4"
      },
      "classes": [
        {
          "classId": "1",
          "className": "Class 1",
          "coachId": "1",
          "duration": "30:20 mins"
        },
        {
          "classId": "2",
          "className": "Class 2",
          "coachId": "2",
          "duration": "45:00 mins"
        }
      ]
    },
    {
      "id": "2",
      "coverPhoto": "https://example.com/cover_photo2.jpg",
      "seriesName": "Training Series 2",
      "difficulty": "Beginner",
      "intensity": "Level 2",
      "coaches": [
        {
          "coachId": "3",
          "coachName": "Coach 3"
        }
      ],
      "overviewSection": {
        "description": "Description of Training Series 2",
        "overviewVideo": "https://example.com/overview_video2.mp4"
      },
      "classes": [
        {
          "classId": "3",
          "className": "Class 3",
          "coachId": "3",
          "duration": "60:00 mins"
        }
      ]
    }
  ],
  "socialPosts": [
    {
      "postId": "1",
      "seriesId": "1",
      "postContent": "This is a social post related to Training Series 1"
    },
    {
      "postId": "2",
      "seriesId": "1",
      "postContent": "Another social post related to Training Series 1"
    },
    {
      "postId": "3",
      "seriesId": "2",
      "postContent": "Social post related to Training Series 2"
    }
  ]
}
"""

}