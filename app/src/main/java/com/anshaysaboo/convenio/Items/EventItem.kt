package com.anshaysaboo.convenio.Items

import android.view.View
import android.widget.TextView
import com.anshaysaboo.convenio.Objects.Event
import com.anshaysaboo.convenio.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem


open class EventItem(eventToDisplay: Event): AbstractItem<EventItem.ViewHolder>() {
    var event: Event? = eventToDisplay

    override val type: Int
        get() = R.id.title_text_view

    override val layoutRes: Int
        get() = R.layout.cell_event

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<EventItem>(view) {
        var title: TextView = view.findViewById(R.id.title_text_view)
        var location: TextView = view.findViewById(R.id.location_text_view)
        var timeText: TextView = view.findViewById(R.id.time_text_view)
        var type: TextView = view.findViewById(R.id.type_text_view)

        override fun bindView(item: EventItem, payloads: MutableList<Any>) {
            title.text = item.event!!.title
            location.text = item.event!!.location
            timeText.text = item.event!!.getTimeText()
            type.text = item.event!!.type
        }

        override fun unbindView(item: EventItem) {
            title.text = null
            location.text = null
            timeText.text = null
        }
    }
}