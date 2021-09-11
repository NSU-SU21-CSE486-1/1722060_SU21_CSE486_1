# Assignment 03, CSE 486, Spring, 2021
**Sumiya Sadia(1722060042)**
**11/09/2021**

This assignment is a follow up on Assignment01 and Assignment02 that requires us to modify, and improve the Project codes to store multiple user profiles for your final project.
I have modified Project02 file and included Room Database for Data storing.

I have **Implemented** Dependencies for Room, LiveData, and ViewModel.
  
I have created Classes for Database entity containig colums for each University Affiliation, added a code for auto generating unique ID. Also Created Room Database, ViewModel, and an Adapter classes.


In the previous Assignment, lateral navigation was implemented in the Uniclubz Activiy, where each Tab contains a fragment where Students' Information show up. I have added two FAB buttons to the second and third Fragment that should open up yet another Fragments that take Inputs from the Users and save them. Unfortunately in my previous Assignment I couldn't handle fragment to fragment communication. As a result of that, I am facing a problem in this Assignment as well. 

The RecyclerView could not be shown in the app. When the app is run, it crashes instantly if the adapter class is called.Even if they are existing in the same ViewModel. 
The code doesn't show any errors so have added a Toast message to show that the ViewModel is working. 

