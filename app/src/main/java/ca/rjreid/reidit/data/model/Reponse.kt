package ca.rjreid.reidit.data.model

import android.os.Parcel
import android.os.Parcelable

data class Response(
        val kind: String,
        val data: ResponseData) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Response> = object : Parcelable.Creator<Response> {
            override fun createFromParcel(source: Parcel): Response = Response(source)
            override fun newArray(size: Int): Array<Response?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readParcelable<ResponseData>(ResponseData::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(kind)
        dest.writeParcelable(data, 0)
    }
}
