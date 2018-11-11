package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EndPointAsyncTaskTest extends AndroidTestCase {
    String TAG = EndpointsAsyncTask.class.getSimpleName();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void testJokeIsNotEmpty() throws Exception {
        EndpointsAsyncTask endpointsAsyncTask =  new EndpointsAsyncTask();
        endpointsAsyncTask.execute(InstrumentationRegistry.getTargetContext());
        String joke = endpointsAsyncTask.get(5, TimeUnit.SECONDS);
        Assert.assertTrue(!joke.equals(""));
    }

    @Test
    public void testVerifyResponse() {

        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.text_joke)).check(matches(isDisplayed()));
    }
}
