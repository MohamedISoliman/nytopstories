package io.github.mohamedisoliman.nytopstories.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.github.mohamedisoliman.nytopstories.R
import io.github.mohamedisoliman.nytopstories.ui.bookmarks.BookmarksFragment
import io.github.mohamedisoliman.nytopstories.ui.home.HomeFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment.newInstance(position + 1)
            1 -> BookmarksFragment.newInstance(position + 1)
            else -> throw NotImplementedError()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}