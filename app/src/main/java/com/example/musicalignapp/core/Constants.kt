package com.example.musicalignapp.core

object Constants {

    //Firebase
    const val USERS_COLLECTION = "users"
    const val PROJECTS_PATH = "projects"
    const val IMAGES_PATH = "images"
    const val FILES_PATH = "files"
    const val JSON_PATH = "jsons"

    //Intent Extras
    const val ALIGN_EXTRA_PACKAGE_ID = "align_screen_extra_id"
    const val ALIGN_EXTRA_IMAGE_URL = "align_screen_extra_image_url"
    const val SYSTEM_REPLACE_ID = "system_replace_id"
    const val FILE_FRAGMENT_TYPE = "file_fragment_type"
    const val IMAGE_FRAGMENT_TYPE = "image_fragment_type"

    //Storage type
    const val IMAGE_TYPE = "image_type"
    const val MUSIC_FILE_TYPE = "music_file_type"
    const val JSON_TYPE = "json_type"

    //Success type FileFragment
    const val DELETE_TYPE = "delete_type"
    const val UPLOAD_TYPE = "upload_type"

    //Datastore Preferences
    const val PREFERENCES_NAME = "PREFERENCES_NAME"
    const val USER_ID_KEY = "userIdKey"
    const val USER_EMAIL_KEY = "userEmailKey"
    const val PATHS_TO_SHOW_KEY = "pathsToShowKey"
    const val SHOW_PATHS_KEY = "show_paths_key"

    //Separators
    const val CURRENT_ELEMENT_SEPARATOR = "%"
    const val REPEATED_PROJECT_SEPARATOR = "*"
}