object BuildConfigFields {

    val baseUrlRelease = Field(
        Type.STRING,
        "BASE_URL",
        "\"https://ghibliapi.herokuapp.com\""
    )

    val baseUrlDebug = Field(
        Type.STRING,
        "BASE_URL",
        "\"https://ghibliapi.herokuapp.com\""
    )


    private object Type {
        const val STRING = "String"
    }

    data class Field(val type: String, val title: String, val value: String)
}
