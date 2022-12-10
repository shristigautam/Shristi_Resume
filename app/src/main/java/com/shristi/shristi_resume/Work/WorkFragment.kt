package com.shristi.shristi_resume

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_new_skill_layout.view.*
import kotlinx.android.synthetic.main.fragment_work.view.*

class WorkFragment : Fragment(R.layout.fragment_work) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workRecyclerView: RecyclerView = view.findViewById(R.id.work_recycler_view)
        var adapter = WorkAdapter(Work.getWorkList())
        workRecyclerView.adapter = adapter

        //adding new experience
        view.fab_add.setOnClickListener {
            val mDialogView =
                LayoutInflater.from(requireContext()).inflate(R.layout.add_new_skill_layout, null)
            val mBuilder = AlertDialog.Builder(requireContext()).setView(mDialogView)
                .setTitle("Add new experience")
            val mAlertDialog = mBuilder.show()

            mDialogView.btn_add_new_skill.setOnClickListener {
                mAlertDialog.dismiss()

                //Creating a new experience with company name, from and to date
                val company_name = mDialogView.company_textfield.text.toString()
                val from_date = mDialogView.from_textfield.text.toString()
                val to_date = mDialogView.to_textfield.text.toString()
                val newWork = Work(company_name, from_date, to_date)
                var workList = Work.getWorkList()
                workList.add(newWork)
                val size = workList.size
                Toast.makeText(requireContext(), "New experience added to list!", Toast.LENGTH_LONG)
                    .show()

            }

            mDialogView.btn_cancel.setOnClickListener {
                mAlertDialog.dismiss()
                Toast.makeText(requireContext(), "Dismiss", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkFragment()
    }

}