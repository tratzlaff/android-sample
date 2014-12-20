package com.tratzlaff.androidsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DisplayMessageActivity extends ActionBarActivity
{
    /**
     * The system creates every new instance of Activity by calling its onCreate() method.
     * This method performs basic application startup logic that should happen only once
     * for the entire life of the activity.
     *
     * Once the onCreate() finishes execution, the system calls the onStart() and onResume() methods in quick succession.
     * Your activity never resides in the Created or Started states. Technically, the activity becomes visible to the
     * user when onStart() is called, but onResume() quickly follows and the activity remains in the Resumed state until
     * something occurs to change that, such as when a phone call is received, the user navigates to another activity,
     * or the device screen turns off.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/starting.html#Create
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Enable the app icon as the Up button by calling setDisplayHomeAsUpEnabled()
        // https://developer.android.com/training/basics/actionbar/adding-buttons.html#UpNav
        // https://developer.android.com/training/implementing-navigation/ancestral.html
        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Every Activity is invoked by an Intent, regardless of how the user navigated there.
        // You can get the Intent that started your activity by calling getIntent() and retrieve the data contained within the intent.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        // Add the TextView as the root view of the activity’s layout by passing it to setContentView().
        setContentView(textView);
    }

    /**
     * Stop ongoing actions that should not continue while paused (such as a video)
     * or persist any information that should be permanently
     * saved in case the user continues to leave your app.
     *
     * When your activity receives a call to onPause(), it may be an indication that the
     * activity will be paused for a moment and the user may return focus to your activity.
     * However, it's usually the first indication that the user is leaving your activity.
     *
     * Avoid performing CPU-intensive work during onPause(), such as writing to a database,
     * because it can slow the visible transition to the next activity.
     * You should instead perform heavy-load shutdown operations during onStop().
     *
     * When your activity is paused, the Activity instance is kept resident in memory and is
     * recalled when the activity resumes. You don’t need to re-initialize components that
     * were created during any of the callback methods leading up to the Resumed state.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/pausing.html#Pause
     */
    @Override
    protected void onPause()
    {
        super.onPause(); // Always call the superclass method first
    }

    /**
     * The system calls this method every time your activity comes into the foreground,
     * including when it's created for the first time or when the user resumes your activity from the Paused state.
     * As such, you should implement onResume() to initialize components that you release during onPause()
     * and perform any other initializations that must occur each time the activity enters the Resumed state
     * (such as begin animations and initialize components only used while the activity has user focus).
     *
     * https://developer.android.com/training/basics/activity-lifecycle/pausing.html#Resume
     */
    @Override
    protected void onResume()
    {
        super.onResume(); // Always call the superclass method first
    }

    /**
     * Most apps don't need to implement this method because local class references are destroyed with
     * the activity and your activity should perform most cleanup during onPause() and onStop().
     * However, if your activity includes background threads that you created during onCreate() or
     * other long-running resources that could potentially leak memory if not properly closed,
     * you should kill them during onDestroy().
     *
     * The system calls onDestroy() after it has already called onPause() and onStop() in all situations except one:
     * when you call finish() from within the onCreate() method.
     *
     * https://developer.android.com/training/basics/activity-lifecycle/starting.html#Destroy
     */
    @Override
    public void onDestroy()
    {
        super.onDestroy();  // Always call the superclass method first
    }



    /**
     * This auto-generated method can be removed if not needed.
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
