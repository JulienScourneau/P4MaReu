package julien.s.mareu.controller;

public class DI {

    private static MeetingApiService service = new FakeApiService();

    public static MeetingApiService getMeetingApiService(){
        return service;
    }
}
