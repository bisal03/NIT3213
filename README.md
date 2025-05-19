Final Assignment

Overview
The Final Assignment is an Android application that showcases a login system, a dashboard with images and details, and a detail view for selected items. The app uses Retrofit for network operations, Hilt for dependency injection, and follows modern Android development practices.

Features
•	Login Screen: Allows users to log in using credentials.
•	Dashboard: Displays a horizontal list of images with titles fetched from a remote API.
•	Detail View: Shows detailed information about an item when selected from the dashboard.

Architecture
•	MVVM Pattern: Separates the application's logic into Model, View, and ViewModel layers.
•	Dependency Injection: Uses Hilt for managing dependencies.
•	Networking: Uses Retrofit for making API calls.

Dependencies
•	Retrofit - Type-safe HTTP client for Android and Java.
•	Hilt - Dependency injection library for Android.
•	Gson - JSON serialization/deserialization library.

Setup
1.	1.Clone the Repository:
git clone  https://github.com/bisal03/NIT3213

2.	Open the Project:
Open the project in Android Studio.

3.	Install Dependencies:
Sync the project with Gradle files to download the necessary dependencies.

4.	Configure API:
Ensure that the API base URL in NetworkModule is correctly set.


Usage
I.	Run the Application:
Connect an Android device or start an emulator.
Run the application from Android Studio.

II.	Login:
Enter your username and password on the login screen.

III.	Navigate:
After a successful login, you'll be taken to the dashboard where you can view a list of items.
Click on an item to see its detailed view.

API Endpoints
•	Login: POST /sydney/auth - Authenticates a user and returns a keypass.
•	Dashboard: GET /dashboard/art - Retrieves a list of entities for the dashboard.

Testing
Unit Tests

Unit tests are provided to ensure the correctness of various components, including:
•	API Service: Tests API calls and responses.
•	ViewModel: Tests ViewModel logic and state management.
To run unit tests, use the following command: ./gradlew test

![image](https://github.com/user-attachments/assets/30f483b3-95c0-46f4-80e2-c597a6caa21a)
