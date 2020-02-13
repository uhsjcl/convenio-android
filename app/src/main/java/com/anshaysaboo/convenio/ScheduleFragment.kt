package com.anshaysaboo.convenio


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anshaysaboo.convenio.Items.EventItem
import com.anshaysaboo.convenio.Objects.Event
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import java.util.*

class ScheduleFragment : Fragment() {

    private lateinit var eventsRecyclerView: RecyclerView
    private lateinit var adapter: FastAdapter<EventItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_schedule, container, false)
        eventsRecyclerView = view.findViewById(R.id.events_recycler_view)
        eventsRecyclerView.layoutManager = LinearLayoutManager(context)
        setupEvents()

        return view
    }

    private fun setupEvents() {
        // set up FastAdapter
        val itemAdapter = ItemAdapter<EventItem>()
        adapter = FastAdapter.with(itemAdapter)

        val ev = Event("Lorem Ipsum Dolor Sit Amet Lit Dit Bit", Date(), Date())
        ev.location = "Room 403"
        ev.type = "ACADEMIC"
        val item = EventItem(eventToDisplay = ev)

        val items = listOf(item, item, item)

        itemAdapter.add(items)

        eventsRecyclerView.setAdapter(adapter)
    }
}
