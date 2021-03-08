# KatalonPSLogin
## A demo Katalon repo for Peoplesoft login as a base for other navigation

-Your repo should contain a .gitignore that excludes the global profile files. This makes sure that you are not sharing your username and passwords in your repos.

### To use:
- Copy the default profile and name it for the environment and login type you plan to use. i.e. Production - local 
- Then edit that profile and add the values for the url, username, password (encrypted text) and the type of login (local or cas)
- Use that profile when running the test script blocks

To get the encrypted text in Katalon, click on the help menu and select Encrypt Text. Enter the plane text and then copy the encrypted text to the clipboard. Paste the encrypted text in the global variable value.
