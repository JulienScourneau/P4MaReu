package julien.s.mareu.meeting_list;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import julien.s.mareu.R;
import julien.s.mareu.controller.DI;
import julien.s.mareu.controller.ListMeetingActivity;
import julien.s.mareu.controller.MeetingApiService;
import julien.s.mareu.utils.DeleteViewAction;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static julien.s.mareu.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Instrumented test
 */
@RunWith(AndroidJUnit4.class)
public class MeetingsListTest {

    private int ITEM;
    private ListMeetingActivity mActivity;
    private MeetingApiService mApiService;

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityTestRule = new ActivityTestRule<>(ListMeetingActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
        mApiService = DI.getNewApiService();
        ITEM = mApiService.getMeetingsList().size();
    }

    @Test
    public void myMeetingList_isNotEmpty() {
        onView((ViewMatchers.withId(R.id.list_meeting)))
                .check(matches(hasChildCount(mApiService.getMeetingsList().size())));
    }

    @Test
    public void myMeetingList_onClick_addNewMeeting_withDialogFragment() {
        onView(withId(R.id.add_new_meeting_button))
                .perform(click());
        onView(allOf(withId(R.id.edit_hour), withText(startsWith("Heure")), isDisplayed()))
                .perform(click());
        onView(allOf(withId(android.R.id.button1), withText("OK"), isDisplayed()))
                .perform(scrollTo(), click());
        onView(allOf(withId(R.id.edit_date), withText("Date  00/00"), isDisplayed()))
                .perform(click());
        onView(allOf(withId(android.R.id.button1), withText("OK"), isDisplayed()))
                .perform(scrollTo(), click());
        onView(allOf(withId(R.id.edit_subject), isDisplayed()))
                .perform(replaceText("Test Meeting"), closeSoftKeyboard());
        onView(allOf(withId(R.id.edit_participant), isDisplayed()))
                .perform(replaceText("Test Participant"), closeSoftKeyboard());
        onView(allOf(withId(R.id.add_participant_button), isDisplayed()))
                .perform(click());
        onView(allOf(withId(android.R.id.button1), withText("Accepter"), isDisplayed()))
                .perform(scrollTo(), click());
        onView(withId(R.id.list_meeting))
                .check(withItemCount(ITEM+1));

    }

    @Test
    public void myMeetingList_onClickTrashCan_removeItem() {
        onView(withId(R.id.list_meeting))
                .check(withItemCount(ITEM+1));
        onView(withId(R.id.list_meeting))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
        onView(withId(R.id.list_meeting))
                .check(withItemCount(ITEM));
    }

    @Test
    public void myMeetingList_sortMeetingByDate() {
        onView(withId(R.id.menu_bar))
                .perform(click());
        onView(allOf(withId(R.id.title), withText("Date"), isDisplayed()))
                .perform(click());
    }

}

