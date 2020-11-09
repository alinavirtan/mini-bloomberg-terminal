#include <bits/stdc++.h>
#include <ctime>

using namespace std;

#include "news.h"

long long generateRandomId() {
	//Get a random seed from the OS entropy device
	std::random_device rd;  

	// Use the 64-bit Mersenne Twister 19937 generator and seed it with entropy
	std::mt19937_64 eng(rd());
	
	// Define the distribution, by default it goes from 0 to MAX(long long)
	std::uniform_int_distribution<long long> distr;  

	return distr(eng);
}

/* Adds a new user to the system. 
 *It should generate unique ID and use current date for joining date */
void addNewUserProfile(string name, string emailAddress, long long phone_number) {
	long long id = generateRandomId();

	// Make sure the id is unique
	while (users.find(id) != users.end()) {
		id = generateRandomId();
	}

	users[id] = User(id, name, emailAddress, phone_number);
}

// Prints user information in a nicely formatted way
void displayUserProfile(long long userID) {
	if (users.find(userID) != users.end()) {
		cout << "Id: " << users[userID].id << endl;
		cout << "Name: " << users[userID].name << endl;
		cout << "Email: " << users[userID].email << endl;
		cout << "Phone: " << users[userID].phone << endl;
		cout << "Joining date: " << users[userID].jointime << endl;
	} else {
		cout << "User not found." << endl;
	}
}

// Updates username
void changeUserName(long long userID, string newName) {
	if (users.find(userID) != users.end()) {
		users[userID].name = newName;
	} else {
		cout << "User not found." << endl;
	}
}

// Updates user email address
void changeUserEmailAddress(long long userID, string newEmailAddress) {
	if (users.find(userID) != users.end()) {
		users[userID].email = newEmailAddress;
	} else {
		cout << "User not found" << endl;
	}
}

// Updates user phone number
void changeUserPhoneNumber(long long userID, long long newPhoneNumber) {
	if (users.find(userID) != users.end()) {
		users[userID].phone = newPhoneNumber;
	} else {
		cout << "User not found." << endl;
	}
}


int main() {
	return 0;
}