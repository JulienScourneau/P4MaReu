package julien.s.mareu.meeting_list;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
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
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Instrumented test
 */
@RunWith(AndroidJUnit4.class)
public class MeetingsListTest {

    private int ITEM = 5;
    private ListMeetingActivity mActivity;
    private MeetingApiService mApiService;

    @Rule
    public ActivityTestRule<ListMeetingActivity> mActivityTestRule = new ActivityTestRule<>(ListMeetingActivity.class);

    @Before
    public void setUp() {

        mActivity = mActivityTestRule.getActivity();
        mApiService = DI.getMeetingApiService();

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
                .check();

    }

    @Test
    public void myMeetingList_onClickTrashCan_removeItem() {
        onView(withId(R.id.list_meeting))
                .check(matches(hasChildCount(ITEM)));
        onView(withId(R.id.list_meeting))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, new DeleteViewAction()));
    }

    @Test
    public void myMeetingList_sortMeetingByDate() {
        onView(withId(R.id.menu_bar))
                .perform(click());
        onView(allOf(withId(R.id.title), withText("Date"),isDisplayed()))
                .perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}

