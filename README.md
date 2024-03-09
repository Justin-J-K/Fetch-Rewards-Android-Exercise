# Fetch Rewards Android Exercise

A native Android mobile application that queries JSON data from https://fetch-hiring.s3.amazonaws.com/hiring.json and displays it as a list of items that are sorted by name and grouped by list ID. Each group has a header in the list. This exercise is part of an application to Fetch Rewards, and created by Justin Kim.

## Exercise Requirements

* Items grouped by `listId`
* Items sorted by `listId` then by `name`
* Items where `name` is blank or null is ignored

## Building and Running Project

1. Install latest version of [Android Studio](https://developer.android.com/studio) (Android Studio Iguanua | 2023.2.1 as of March 8, 2024)
2. Clone repository using `git clone https://github.com/Justin-J-K/Fetch-Rewards-Android-Exercise.git`
3. Open the project by clicking `Open` on the "Welcome to Android Studio" screen or clicking `File->Open...`, and selecting the folder of the repository
4. Configure emulator or connected device to use at least API 34
5. Run application by clicking the green run arrow or press `Shift+F10` (or `Control+R` on MacOS)
