<h1> Automation App Project </h1>
<h2>Pre-requisites</h2>
To use this application, you need to have :
<ul>
  <li>Java</li>
  <li>Intellij Idea</li>
  <li>Appium</li>
</ul>
<br>

Note: "Appium" server should be started while using this application.

<p>
  The application logins to the Khalti app passed via Configuration file. Run the DashboardValidatorTest for checking the UI validation of 
different menus used in the application. The beforeTest annotation has the login configured where it enters the credentials and checks if the 
page is landed to dashboard page by validating the balance part. The menu validation part which is the dashboardValidation goes to every menus present along
with notifications tab and wait until the UI components are loaded in the menu section. Finally, after clicking and validating the UI components in every menu page
it goes to afterTest annotation which has the logout section written for the application. It goes in menu and clicks logout and confirmation.
</p>

<p>
  Execution video: <a href="https://drive.google.com/file/d/1BYLv0KoP63bM-p9bvFY-ElWMSNwb7o17/view?usp=sharing">Here</a>  
</p>
