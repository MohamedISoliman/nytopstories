package io.github.mohamedisoliman.nytopstories.ui

import android.widget.ImageView
import com.squareup.picasso.Picasso
import io.github.mohamedisoliman.nytopstories.R


private val placeHolders = listOf(
    "https://okrp.com/wp-content/uploads/2013/03/nytimes-logo-copy.jpg",
    "https://primo-europe.eu/wp-content/uploads/2018/10/new-york-times-logo.jpg",
    "https://simons-rock.edu/_images/student-life/nytimes.jpg",
    "https://www.niemanlab.org/images/new-york-times-en-espanol-1.jpeg"

)

fun ImageView.loadImage(url: String? = null) {
    if (url != null) {
        Picasso.get().load(url)
            .into(this)
    } else {
        Picasso.get().load(R.mipmap.nytimes_logo_copy)
            .into(this)
    }

}