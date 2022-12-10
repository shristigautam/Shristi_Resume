package com.shristi.shristi_resume

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class WorkAdapter(
    private val workList: MutableList<Work> = mutableListOf(),
) : RecyclerView.Adapter<WorkAdapter.WorkViewHolder>() {

    inner class WorkViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(work: Work) {
            val logoImageView: ImageView = view.findViewById(R.id.logo_image_view)
            val companyNameTextView: TextView = view.findViewById(R.id.company_name_text_view)
            val positionTextView: TextView = view.findViewById(R.id.position_text_view)
            val projectTextView: TextView = view.findViewById(R.id.project_text_view)
            val projectDescTextView: TextView = view.findViewById(R.id.project_desc_text_view)

            Glide.with(view.context).load(work.logo).into(logoImageView)
            companyNameTextView.text =
                work.companyName + " (" + work.fromDate + " - " + work.toDate + ")"
            positionTextView.text = work.title
            projectTextView.text = work.project_name
            projectDescTextView.text = work.project_desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_work, parent, false)
        return WorkViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkViewHolder, position: Int) {
        holder.bind(workList[position])
    }

    override fun getItemCount(): Int = workList.size
}