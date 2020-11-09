struct User {
	long long id;
	string name;
	string email;
	long long phone;
	time_t jointime;

	User() {
		this->id = 0;
		this->name = "";
		this->email = "";
		this->phone = 0;
		this->jointime = time(0);
	}

	User(long long id, string name, string email, int phone) {
		this->id = id;
		this->name = name;
		this->email = email;
		this->phone = phone;
		this->jointime = time(0);
	}
};

unordered_map<long long, User> users;

long long generateRandomId();
void addNewUserProfile(string name, string emailAddress, long long phone_number);
void displayUserProfile(long long userID);
void changeUserName(long long userID, string newName);
void changeUserEmailAddress(long long userID, string newEmailAddress);
void changeUserPhoneNumber(long long userID, long long newPhoneNumber);