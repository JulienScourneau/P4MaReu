package julien.s.mareu.controller;

import julien.s.mareu.model.Meeting;

public class DI {

    private static MeetingApiService service = new FakeApiService();

    public static MeetingApiService getMeetingApiService(){
        return service;
    }

    public static MeetingApiService getNewInstanceApiservice(){
        return new FakeApiService();
    }
}
