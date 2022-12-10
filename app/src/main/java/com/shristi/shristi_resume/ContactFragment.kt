package com.shristi.shristi_resume

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast

class ContactFragment : Fragment(R.layout.fragment_contact), View.OnClickListener {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_contact, container, false)
//    }

    private lateinit var phoneLL: LinearLayout
    private lateinit var emailLL: LinearLayout
    private lateinit var linkedInLL: LinearLayout
    private lateinit var facebookLL: LinearLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phoneLL = view.findViewById(R.id.mobile)
        emailLL = view.findViewById(R.id.gmail)
        linkedInLL = view.findViewById(R.id.linkedin)
        facebookLL = view.findViewById(R.id.facebook)

        phoneLL.setOnClickListener(this)
        emailLL.setOnClickListener(this)
        linkedInLL.setOnClickListener(this)
        facebookLL.setOnClickListener(this)

    }

    private fun onMobileClicked() {
        val dialIntent = Intent(Intent.ACTION_DIAL)
        dialIntent.data = Uri.parse("tel:" + "+16418192198")
        startActivity(dialIntent)
    }

    private fun onEmailClicked() {
        sendEmail()
    }

    private fun onLinkedInClicked() {
        openWebUrl(getString(R.string.linkedin))
    }

    private fun onFacebookClicked() {
        openWebUrl(getString(R.string.facebook_profile))
    }

    private fun onResumeClicked() {

    }

    private fun openWebUrl(url: String) {
        val intent = Intent(requireActivity(), WebActivity::class.java)
        intent.putExtra("url",url)
        requireContext().startActivity(intent)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.mobile -> onMobileClicked()
            R.id.gmail -> onEmailClicked()
            R.id.linkedin -> onLinkedInClicked()
            R.id.facebook -> onFacebookClicked()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContactFragment()
    }


    private fun sendEmail() {
        val isAppInstalled: Boolean = isAppAvailable("com.google.android.gm")
        if (isAppInstalled) {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.data = (Uri.parse("mailto:" + getString(R.string.email)))
            myIntent.type = "text/plain"
            myIntent.setPackage("com.google.android.gm")
            myIntent.putExtra(Intent.EXTRA_EMAIL, getString(R.string.email))
            startActivity(Intent.createChooser(myIntent, "Share with"))
        } else {
            Toast.makeText(requireContext(), "App not Installed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isAppAvailable(appName: String?): Boolean {
        return try {
            requireContext().packageManager.getPackageInfo(appName!!, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

}