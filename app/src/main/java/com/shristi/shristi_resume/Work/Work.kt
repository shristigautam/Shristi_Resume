package com.shristi.shristi_resume

data class Work(
    val companyName: String,
    val fromDate: String,
    val toDate: String,
    val title: String = "Mobile Developer",
    val project_name: String ="Project Name",
    val logo: String = "https://static8.depositphotos.com/1378583/1010/i/600/depositphotos_10108949-stock-photo-blue-flame-logo.jpg",
    val project_desc: String = "Project Desc"
) {
    companion object {
        fun getWorkList(): MutableList<Work> {
            return mutableListOf(
                Work(
                    "Robert Bosch",
                    "Oct 2021",
                    "Present",
                    "Mobile Developer",
                    "Ford Diagnow",
                    "data:image/jpeg;base64,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",
                    "Ford DiagNow provides diagnostic functionality in a convenient lightweight package enabling users to quickly address vehicle concerns without the need for a full diagnostic scan tool and laptop.",
                ),
                Work(
                    "Cellapp",
                    "April 2017",
                    "Oct 2021",
                    "Senior Mobile Developer",
                    "Smartpalika",
                    "data:image/png;base64,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",
                    "E-governance mobile applications for local governments of Nepal. Smartpalika aims to impact representatives, local governments and people with its smart tools and automation."
                ),
                Work(
                    "Web-robo",
                    "January 2017",
                    "March 2017",
                    "Mobile Development Intern",
                    "Webrobo Mobile App",
                    "https://pbs.twimg.com/profile_images/724186123207991296/0CQ-oo6M_400x400.jpg",
                    "Official mobile application of the company"
                ),
            )
        }
    }
}