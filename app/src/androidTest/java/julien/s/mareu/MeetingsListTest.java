package julien.s.mareu;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import julien.s.mareu.controller.DI;
import julien.s.mareu.controller.ListMeetingActivity;
import julien.s.mareu.controller.MeetingApiService;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.hasMinimumChildCount;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Instrumented test
 */
@RunWith(AndroidJUnit4.class)
public class MeetingsListTest {

    private ListMeetingActivity mActivity;
    private MeetingApiService mApiService;

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityTestRule = new ActivityTestRule<>(ListMeetingActivity.class);

    @Before
    public void setUp(){

        mActivity = mActivityTestRule.getActivity();
        mApiService = DI.getNewApiService();
    }

    @Test
    public void myMeetingList_isNotEmpty() {
        onView((ViewMatchers.withId(R.id.list_meeting)))
                .check(matches(hasMinimumChildCount(1)));
    }

    @Test
    public void myMeetingList_onClick_openDialogFragment(){

    }

    @Test
    public void myMeetingList_onClickTrashCan_removeItem() {
        onView((ViewMatchers.withId(R.id.list_meeting)))
                .check(matches(hasChildCount(mApiService.getMeetingsList().size())));
        onView(allOf(ViewMatchers.withId(R.id.list_meeting),isDisplayed()))
                .perform();

    }
}
