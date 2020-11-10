public class Meeting extends Comparable<Meeting>
{
  DateTime start, end;
  String topic;

  public Meeting(DateTime s, DateTime e, String topic)
  {
    this.start = s;
    this.end = e;
    this.topic = topic;
  }

  public String toString()
  {
  	return "Date: " + start + " " + end + "\nTopic: " + topic;
  }

  @Override
  public int compareTo(Meeting meeting){
  	if(this.start > meeting.start){
      	return 1;

    if(this.start == meeting.start)
        return 0;

    return -1;
  }

}

public class Calendar
{
  int userID;
  HashMap<LocalDate, ArrayList<Meeting>> meetings;

  public ArrayList<Meeting> getMeetingsDay(LocalDate day)
  {
  	if(!this.meetings.contains(day)) {
    	this.meetings.put(day, new ArrayList<Meeting>());
    }
    return this.meetings.getValue(day);
  }

	public static addMeeting(ArrayList<User> listOfUsers, LocalDate startTime, LocalDate endTime, String topic)
  {
		LocalDate date = startTime.toLocalDate();
    Meeting meeting = new Meeting(startTime, endTime, topic);

    foreach(User user : listofUsers)
    {
			Calendar calendar = user.getCalendar();

      //Add meeting to day.
      calendar.getMeetingsDay(date).add(meeting);
    }

  }

  public static displayUsersDay(int userID){

  	//Get current day.
    LocalDate current = new LocalDate();

    displayUsersCalendarForGivenDat(userID, current);
  }

  public displayUsersCalendarForGivenDay(int userID, LocalDate calendarDay) {
  	Calendar calendar = User.getUser(userID).getCalendar();

    ArrayList<Meeting> meetings = calendar.getMeetingsDay(calendarDay);

    foreach(Meeting meeting : meetings.sort())
    {
    	System.out.println(meeting.toString());
    }

  }

  public meetingTimeSuggestion(User organisingUser, LocalDate calendarDay, Time earliestTime, Time latestTime, int timeInterval)
  {
  	//Get user calendar.
    Calendar calendar = organisingUser.getCalendar();

    ArrayList<Meeting> availability = getAvailableSlots(calendar);

    foreach( Meeting meet : availability)
    {
    	System.out.println(meet.toString());
    }

  }

  private getAvailableSlots(Calendar calendar)
  {


  }

}
