package io.github.mohamedisoliman.nytopstories.ui

import android.opengl.Visibility
import android.view.View
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
            .placeholder(R.mipmap.nytimes_logo_copy)
            .into(this)
    } else {
        Picasso.get().load(R.mipmap.nytimes_logo_copy)
            .into(this)
    }

}


fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun Boolean.toVisibility() = if (this) View.VISIBLE else View.INVISIBLE

fun Boolean.toVisibilityGone() = if (this) View.VISIBLE else View.GONE