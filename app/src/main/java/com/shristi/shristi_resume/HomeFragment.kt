package com.shristi.shristi_resume

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.shristi.shristi_resume.model.Skill
import com.shristi.shristi_resume.model.Skills
import kotlinx.android.synthetic.main.add_new_skill_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.io.FileWriter
import java.io.IOException


class HomeFragment : Fragment() {

    lateinit var list:ArrayList<Skill>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        list = ArrayList<Skill>()

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.fab_add.setOnClickListener {
            //Toast.makeText(requireContext(), "add new", Toast.LENGTH_SHORT).show()
            val mDialogView = LayoutInflater.from(requireContext()).inflate(R.layout.add_new_skill_layout, null)
            val mBuilder = AlertDialog.Builder(requireContext()).setView(mDialogView).setTitle("Add Your New Skill")
            val mAlertDialog = mBuilder.show()

            mDialogView.btn_add_new_skill.setOnClickListener {
                mAlertDialog.dismiss()
                val new_skill_name = mDialogView.et_add_new_skill.text.toString()

                // Create an Skill object using the EditText Inputs
                val s = Skill()
                s.name = new_skill_name
                list.add(s)
                Toast.makeText(requireContext(), "Added into List ${ s.toString() }", Toast.LENGTH_LONG).show()
                /* Will fix later for add to GSON file to external storage */
                /*
                if(list.size>0){

                    val temp_skill = Skills()
                    temp_skill.skills = list

                    val gson = Gson()
                    val response = gson.toJson(temp_skill)
                    val path = Environment.getExternalStorageDirectory().absolutePath+"/skill_gson.json"
                    //Toast.makeText(requireContext(), path, Toast.LENGTH_SHORT).show()
                    try
                    {
                        val writer = FileWriter(path)
                        writer.write(response)
                        writer.flush()
                        writer.close()
                        //Toast.makeText(requireContext(), "Write successfully on file", Toast.LENGTH_LONG).show()
                    }
                    catch (e1: IOException) {
                        println("******* CATCH AGAIN ****")
                        e1.printStackTrace()
                    }
                } else {
                    Toast.makeText(requireContext(), "Can not write empty list", Toast.LENGTH_SHORT).show()
                }
                */
                /*Will fix later for add to GSON file to external storage */
            }

            mDialogView.btn_cancel.setOnClickListener {
                mAlertDialog.dismiss()
                Toast.makeText(requireContext(), "Dismiss", Toast.LENGTH_SHORT).show()
            }
        }

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

}