# Resume App


** This is a portfolio app that I developed as an academic project for CD-473 Mobile Device Programming at MIU. **

*Note: email shristigautam@miu.edu and password “Shristi@123” have been initially saved in Shared Preferences, so please use these credentials to log in and check the app.
While developing this project, I have used Fragments, Intents, Menus, Tab Layout, Shared Preferences, Material Design, Swipe View, WebView and many other things learned in class.

### 1)	Login Activity with Validation from Shared Preference:
![Login](https://github.com/shristigautam/Shristi_Resume/blob/master/app/src/main/res/drawable-v24/images/login.PNG)


### 2)	Home Fragment and About Me Fragment:

![Home and About](https://github.com/shristigautam/Shristi_Resume/blob/master/app/src/main/res/drawable-v24/images/Home_and_Aboutme.PNG)
  

### 3)	Work Fragment 

I have used Recycler view for loading work experience data dynamically using Work Adapter. I have used FloatingActionButton and AlertDialog to add new experience: 

![Work](https://github.com/shristigautam/Shristi_Resume/blob/master/app/src/main/res/drawable-v24/images/Work.PNG)


##### The experience marked with red color is the newly added experience from the Alert Dialog: 

![Work Added](https://github.com/shristigautam/Shristi_Resume/blob/master/app/src/main/res/drawable-v24/images/Work_added.PNG)


### 4)	Contact Fragment 

I have used ACTION_DIAL intent for the phone call and WebView for opening the three links: 

![Contact](https://github.com/shristigautam/Shristi_Resume/blob/master/app/src/main/res/drawable-v24/images/Contact%20Me.PNG)
  

### 5)	Logout Menu 
I have used Overflow Menu for extra option (Logout) which clears the login value from shared preference and redirects the user to the Login page:

 ![Logout](https://github.com/shristigautam/Shristi_Resume/blob/master/app/src/main/res/drawable-v24/images/Logout.PNG)
